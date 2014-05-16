package iitc.asm;

import iitc.asm.analysers.clazz.ClassFinder;
import iitc.asm.analysers.clazz.ClassInjectingFinder;
import iitc.asm.analysers.field.FieldFinder;
import org.objectweb.asm.tree.ClassNode;
import org.objectweb.asm.tree.FieldNode;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.*;
import java.util.concurrent.TimeUnit;
import java.util.jar.JarFile;

/**
 * InjectingClassLoader
 *
 * @author Ian
 * @version 1.0
 */
public class InjectingClassLoader extends JarClassLoader {
    protected final List<ClassAnalyser> cleaners;
    protected final List<ClassFinder> finders;
    private final Map<String, String> hookToNodeMapping;
    private final Map<String, String> nodeToHookMapping;
    private final Map<String, List<String>> hookedMethodMapping;
    private final List<ClassFinder> failures;
    private final List<ClassAnalyser> preProcessorFailures;
    private final List<FieldFinder> fieldFailures;
    private int fields = 0;
    private int injectors = 0;
    private int preProcessingTime = 0;
    private int findingTime = 0;
    private int fieldTime = 0;
    private boolean injected;

    public InjectingClassLoader(String url) throws IOException {
        this(url, new ArrayList<ClassAnalyser>(), new ArrayList<ClassFinder>());
    }

    public InjectingClassLoader(URL url) throws IOException {
        this(url, new ArrayList<ClassAnalyser>(), new ArrayList<ClassFinder>());
    }

    public InjectingClassLoader(File file) throws IOException {
        this(file, new ArrayList<ClassAnalyser>(), new ArrayList<ClassFinder>());
    }

    public InjectingClassLoader(JarFile file) throws IOException {
        this(file, new ArrayList<ClassAnalyser>(), new ArrayList<ClassFinder>());
    }

    public InjectingClassLoader(String url, List<ClassAnalyser> cleaners, List<ClassFinder> finders) throws IOException {
        super(url);
        this.cleaners = cleaners;
        this.finders = finders;
        this.hookToNodeMapping = new TreeMap<>();
        this.nodeToHookMapping = new TreeMap<>();
        this.hookedMethodMapping = new HashMap<>();
        this.failures = new ArrayList<>();
        this.fieldFailures = new ArrayList<>();
        this.preProcessorFailures = new ArrayList<>();
        this.injected = false;
    }

    public InjectingClassLoader(URL url, List<ClassAnalyser> cleaners, List<ClassFinder> finders) throws IOException {
        super(url);
        this.cleaners = cleaners;
        this.finders = finders;
        this.hookToNodeMapping = new TreeMap<>();
        this.nodeToHookMapping = new TreeMap<>();
        this.hookedMethodMapping = new HashMap<>();
        this.failures = new ArrayList<>();
        this.fieldFailures = new ArrayList<>();
        this.preProcessorFailures = new ArrayList<>();
        this.injected = false;
    }

    public InjectingClassLoader(File file, List<ClassAnalyser> cleaners, List<ClassFinder> finders) throws IOException {
        super(file);
        this.cleaners = cleaners;
        this.finders = finders;
        this.hookToNodeMapping = new TreeMap<>();
        this.nodeToHookMapping = new TreeMap<>();
        this.hookedMethodMapping = new HashMap<>();
        this.failures = new ArrayList<>();
        this.fieldFailures = new ArrayList<>();
        this.preProcessorFailures = new ArrayList<>();
        this.injected = false;
    }

    public InjectingClassLoader(JarFile file, List<ClassAnalyser> cleaners, List<ClassFinder> finders) throws IOException {
        super(file);
        this.cleaners = cleaners;
        this.finders = finders;
        this.hookToNodeMapping = new TreeMap<>();
        this.nodeToHookMapping = new TreeMap<>();
        this.hookedMethodMapping = new HashMap<>();
        this.failures = new ArrayList<>();
        this.fieldFailures = new ArrayList<>();
        this.preProcessorFailures = new ArrayList<>();
        this.injected = false;
    }

    public void storeMethod(String inject, String parent, String getter, FieldNode method, Object multi) {
        if (multi == null)
            storeMethod(inject, String.format("%-25s %s.%s", getter, parent, method.name));
        else
            storeMethod(inject, String.format("%-25s %s.%-2s * %s", getter, parent, method.name, multi));
    }

    public void storeMethod(String inject, String parent, String getter, String method, Object multi) {
        if (multi == null)
            storeMethod(inject, String.format("%-25s %s.%s", getter, parent, method));
        else
            storeMethod(inject, String.format("%-25s %s.%-2s * %s", getter, parent, method, multi));
    }

    public void storeMethod(String inject, String parent, String getter, FieldNode method) {
        storeMethod(inject, String.format("%-25s %s.%s", getter, parent, method.name));
    }

    public void storeMethod(String inject, String parent, String getter, String method) {
        storeMethod(inject, String.format("%-25s %s.%s", getter, parent, method));
    }

    public void storeMethod(String parent, String getter, FieldNode method, Object multi) {
        if (multi == null)
            storeMethod(parent, String.format("%-25s %s.%s", getter, parent, method.name));
        else
            storeMethod(parent, String.format("%-25s %s.%-2s * %s", getter, parent, method.name, multi));
    }

    public void storeMethod(String parent, String getter, String method, Object multi) {
        if (multi == null)
            storeMethod(parent, String.format("%-25s %s.%s", getter, parent, method));
        else
            storeMethod(parent, String.format("%-25s %s.%-2s * %s", getter, parent, method, multi));
    }

    public void storeMethod(String parent, String getter, FieldNode method) {
        storeMethod(parent, String.format("%-25s %s.%s", getter, parent, method.name));
    }

    public void storeMethod(String parent, String getter, String method) {
        storeMethod(parent, String.format("%-25s %s.%s", getter, parent, method));
    }

    private void storeMethod(String parent, String method) {
        List<String> methods = hookedMethodMapping.get(parent);
        if (methods == null) {
            List<String> newMethods = new ArrayList<>();
            this.hookedMethodMapping.put(parent, newMethods);
            newMethods.add(method);
        } else
            methods.add(method);
    }

    public ClassNode findSuper(ClassNode node) {
        return find(node.superName);
    }

    public ClassNode find(FieldNode field) {
        return find(NodeAnalyser.objectFromDescriptor(field));
    }

    public ClassNode find(ASMCondition<ClassNode> condition) {
        for (ClassNode node : nodes.values())
            if (condition.validate(node))
                return node;
        return null;
    }

    public ClassNode find(String name) {
        return name == null ? null : nodes.get(name);
    }

    public void storeHook(String iface, ClassNode node) {
        this.hookToNodeMapping.put(iface, node.name);
        this.nodeToHookMapping.put(node.name, iface);
    }

    public String getHookByNode(ClassNode node) {
        return getHookByNode(node.name);
    }

    public String getHookByNode(String node) {
        return nodeToHookMapping.get(node);
    }

    public String getNodeByHook(Class<?> iface) {
        return getNodeByHook(ClassUtils.getPathTo(iface));
    }

    public String getNodeByHook(String iface) {
        return hookToNodeMapping.get(iface);
    }

    public boolean add(ClassAnalyser... cleaners) {
        return Collections.addAll(this.cleaners, cleaners);
    }

    public boolean add(ClassFinder... finders) {
        return Collections.addAll(this.finders, finders);
    }

    public boolean inject() {
        if (!injected) {
            for (ClassAnalyser cleaner : cleaners) {
                cleaner.onStart();
                if (!cleaner.perform())
                    preProcessorFailures.add(cleaner);
                cleaner.onFinish();
                preProcessingTime += cleaner.getTime();
            }
            for (ClassFinder finder : finders) {
                finder.onStart();
                if (!finder.locate())
                    failures.add(finder);
                finder.onFinish();
                findingTime += finder.getTime();
                if (finder instanceof ClassInjectingFinder)
                    injectors++;
            }
            //find fields after classes so they can use the proper hook mapping
            for (ClassFinder finder : finders) {
                fields += finder.fieldCount();
                finder.locateFields();
                fieldTime += finder.getFieldTime();
                fieldFailures.addAll(finder.getFailed());
            }
            injected = true;
        }
        return true;
    }

    public void printLogString() {
        for (ClassAnalyser analyser : cleaners) {
            System.out.println("\t- " + analyser.getClass().getSimpleName() + " [" + TimeUnit.MILLISECONDS.convert(analyser.getTime(), TimeUnit.NANOSECONDS) + "ms]");
        }
        for (ClassFinder finder : finders) {
            System.out.println("\t- " + finder.getClass().getSimpleName() + " [" + TimeUnit.MILLISECONDS.convert(finder.getTime(), TimeUnit.NANOSECONDS) + "ms]");
        }
        System.out.println();
        int count = 0;
        for (Map.Entry<String, String> hook : hookToNodeMapping.entrySet()) {
            String object = hook.getKey().substring(hook.getKey().lastIndexOf('/') + 1);
            List<String> methods = hookedMethodMapping.get(hook.getValue());
            System.out.printf("%-25s\t  %-2s\n", object, hook.getValue());
            System.out.println(hook.getKey());
            if (methods != null) {
                count += methods.size();
                for (String s : methods) {
                    System.out.println("\t" + s);
                }
            }
            System.out.println();
        }
        System.out.println(hookToNodeMapping.size() + "/" + injectors + " classes identified, " + count + "/" + fields + " fields identified, 0 methods identified.");
        if (preProcessorFailures.size() > 0)
            System.out.println("Cleaner Failures: " + preProcessorFailures);
        if (failures.size() > 0)
            System.out.println("Class Failures: " + failures);
        if (fieldFailures.size() > 0)
            System.out.println("Field Failures: " + fieldFailures);
        System.out.println("Preprocessing [" + TimeUnit.MILLISECONDS.convert(preProcessingTime, TimeUnit.NANOSECONDS) + "ms]");
        System.out.println("Node finding [" + TimeUnit.MILLISECONDS.convert(findingTime, TimeUnit.NANOSECONDS) + "ms]");
        System.out.println("Field finding [" + TimeUnit.MILLISECONDS.convert(fieldTime, TimeUnit.NANOSECONDS) + "ms]");
    }
}
