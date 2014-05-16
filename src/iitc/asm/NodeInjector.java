package iitc.asm;

import org.objectweb.asm.Opcodes;
import org.objectweb.asm.tree.*;

import java.util.ListIterator;

/**
 * NodeInjector
 *
 * @author Ian
 * @version 1.0
 */
public class NodeInjector implements Opcodes {
    public static boolean inject(ClassNode node, MethodNode method) {
        return node.methods.add(method);
    }

    public static boolean inject(ClassNode node, FieldNode field) {
        return node.fields.add(field);
    }

    public static void setSuper(ClassNode node, Class<?> _class) {
        setSuper(node, ClassUtils.getPathTo(_class));
    }

    public static void setSuper(ClassNode node, String superClass) {
        String replacedSuper = "";
        if (!node.superName.equals(""))
            replacedSuper = node.superName;
        if (!replacedSuper.equals("")) {
            for (final MethodNode mn : node.methods) {
                ListIterator<?> ili = mn.instructions.iterator();
                while (ili.hasNext()) {
                    AbstractInsnNode ain = (AbstractInsnNode) ili.next();
                    if (ain.getOpcode() == Opcodes.INVOKESPECIAL) {
                        MethodInsnNode min = (MethodInsnNode) ain;
                        if (min.owner.equals(replacedSuper)) {
                            min.owner = superClass;
                        }
                    }
                }
            }
        }
        node.superName = superClass;
    }

    public static boolean injectInterface(ClassNode node, Class<?> _class) {
        return injectInterface(node, ClassUtils.getPathTo(_class));
    }

    public static boolean injectInterface(ClassNode node, String classPath) {
        return node != null && classPath != null && node.interfaces.add(classPath);
    }

    public static void addStaticFieldAccessor(ClassNode injection, ClassNode parent, Primitive new_return_type, FieldNode field, String methodName) {
        addStaticFieldAccessor(injection, parent, new_return_type, field, methodName, null);
    }

    public static void addStaticFieldAccessor(ClassNode injection, ClassNode parent, Primitive new_return_type, FieldNode field, String methodName, Object multiplier) {
        addStaticFieldAccessor(injection, parent.name, new_return_type.getDescriptor(), field.desc, field.name, methodName, multiplier);
    }

    public static void addStaticFieldAccessor(ClassNode injection, ClassNode parent, Primitive new_return_type, int arrayLength, FieldNode field, String methodName) {
        addStaticFieldAccessor(injection, parent, new_return_type, arrayLength, field, methodName, null);
    }

    public static void addStaticFieldAccessor(ClassNode injection, ClassNode parent, Primitive new_return_type, int arrayLength, FieldNode field, String methodName, Object multiplier) {
        addStaticFieldAccessor(injection, parent.name, new_return_type.getDescriptor(arrayLength), field.desc, field.name, methodName, multiplier);

    }

    public static void addStaticFieldAccessor(ClassNode injection, ClassNode parent, Class<?> new_return_type, FieldNode field, String methodName) {
        addStaticFieldAccessor(injection, parent, new_return_type, field, methodName, null);
    }

    public static void addStaticFieldAccessor(ClassNode injection, ClassNode parent, Class<?> new_return_type, FieldNode field, String methodName, Object multiplier) {
        addStaticFieldAccessor(injection, parent.name, ClassUtils.getDescriptor(new_return_type), field.desc, field.name, methodName, multiplier);
    }

    public static void addStaticFieldAccessor(ClassNode injection, ClassNode parent, Class<?> new_return_type, int arrayLength, FieldNode field, String methodName) {
        addStaticFieldAccessor(injection, parent, new_return_type, arrayLength, field, methodName, null);
    }

    public static void addStaticFieldAccessor(ClassNode injection, ClassNode parent, Class<?> new_return_type, int arrayLength, FieldNode field, String methodName, Object multiplier) {
        addStaticFieldAccessor(injection, parent.name, ClassUtils.getDescriptor(new_return_type, arrayLength), field.desc, field.name, methodName, multiplier);
    }

    public static void addStaticFieldAccessor(ClassNode injection, ClassNode parent, String new_return_type, int arrayLength, FieldNode field, String methodName) {
        addStaticFieldAccessor(injection, parent.name, ClassUtils.getDescriptor(new_return_type, arrayLength), field.desc, field.name, methodName, null);
    }

    public static void addStaticFieldAccessor(ClassNode injection, ClassNode parent, String new_return_type, FieldNode field, String methodName) {
        addStaticFieldAccessor(injection, parent.name, new_return_type, field.desc, field.name, methodName, null);
    }

    public static void addStaticFieldAccessor(ClassNode injection, ClassNode parent, String new_return_type, int arrayLength, FieldNode field, String methodName, Object multiplier) {
        addStaticFieldAccessor(injection, parent.name, ClassUtils.getDescriptor(new_return_type, arrayLength), field.desc, field.name, methodName, multiplier);
    }

    public static void addStaticFieldAccessor(ClassNode injection, ClassNode parent, String new_return_type, FieldNode field, String methodName, Object multiplier) {
        addStaticFieldAccessor(injection, parent.name, new_return_type, field.desc, field.name, methodName, multiplier);
    }

    /**
     * Injects a static method into the client.
     *
     * @param injection class name of what class to inject in.
     * @param parent    class name of static field
     * @param ifaceDesc descriptor of interface
     * @param desc      field descriptor
     * @param field     field name
     * @param name      method name
     */
    public static void addStaticFieldAccessor(ClassNode injection, String parent, String ifaceDesc, String desc, String field, String name) {
        addStaticFieldAccessor(injection, parent, ifaceDesc, desc, field, name, null);
    }

    /**
     * Injects a static method into the client.
     *
     * @param injection  class name of what class to inject in.
     * @param parent     class name of static field
     * @param ifaceDesc  descriptor of interface
     * @param desc       field descriptor
     * @param field      field name
     * @param name       method name
     * @param multiplier the multiplier
     */

    public static void addStaticFieldAccessor(ClassNode injection, String parent, String ifaceDesc, String desc, String field, String name, Object multiplier) {
        MethodNode mn = new MethodNode(ACC_PUBLIC, name, "()" + ifaceDesc, null, null);
        mn.instructions.add(new FieldInsnNode(GETSTATIC, parent, field, desc));
        if (multiplier != null) {
            mn.instructions.add(new LdcInsnNode(multiplier));
            mn.instructions.add(new InsnNode(IMUL));
        }
        mn.instructions.add(new InsnNode(getReturnOpcode(desc)));
        injection.methods.add(mn);
    }

    public static void addGetter(ClassNode injection, FieldNode field, Class<?> new_return_type, int arrayLength, String getter_name) {
        addGetter(injection, field, new_return_type, arrayLength, getter_name, null);
    }

    public static void addGetter(ClassNode injection, FieldNode field, Class<?> new_return_type, int arrayLength, String getter_name, Object multiplier) {
        addGetter(injection, field.name, ClassUtils.getDescriptor(new_return_type, arrayLength), field.desc, getter_name, multiplier);
    }

    public static void addGetter(ClassNode injection, FieldNode field, Class<?> new_return_type, String getter_name) {
        addGetter(injection, field, new_return_type, getter_name, null);
    }

    public static void addGetter(ClassNode injection, FieldNode field, Class<?> new_return_type, String getter_name, Object multiplier) {
        addGetter(injection, field.name, ClassUtils.getDescriptor(new_return_type), field.desc, getter_name, multiplier);
    }

    public static void addGetter(ClassNode injection, FieldNode field, String new_return_type, String getter_name) {
        addGetter(injection, field, new_return_type, getter_name, null);
    }

    public static void addGetter(ClassNode injection, FieldNode field, String new_return_type, String getter_name, Object multiplier) {
        addGetter(injection, field.name, new_return_type, field.desc, getter_name, multiplier);
    }

    public static void addGetter(ClassNode injection, FieldNode field, Primitive new_return_type, int arrayLength, String getter_name) {
        addGetter(injection, field, new_return_type, arrayLength, getter_name, null);
    }

    public static void addGetter(ClassNode injection, FieldNode field, Primitive new_return_type, int arrayLength, String getter_name, Object multiplier) {
        addGetter(injection, field.name, new_return_type.getDescriptor(arrayLength), field.desc, getter_name, multiplier);
    }

    public static void addGetter(ClassNode injection, FieldNode field, Primitive new_return_type, String getter_name) {
        addGetter(injection, field, new_return_type, getter_name, null);
    }

    public static void addGetter(ClassNode injection, FieldNode field, Primitive new_return_type, String getter_name, Object multiplier) {
        addGetter(injection, field.name, new_return_type.getDescriptor(), field.desc, getter_name, multiplier);
    }

    /**
     * Injects a method to a class
     *
     * @param injection  class name to inject to
     * @param fieldName  field name
     * @param desc       interface descriptor
     * @param fieldDesc  field descriptor
     * @param methodName method name
     */
    public static void addGetter(ClassNode injection, String fieldName, String desc, String fieldDesc, String methodName) {
        addGetter(injection, fieldName, desc, fieldDesc, methodName, null);
    }

    /**
     * Injects a method to a class
     *
     * @param injection  class name to inject to
     * @param fieldName  field name
     * @param desc       interface descriptor
     * @param fieldDesc  field descriptor
     * @param methodName method name
     * @param multiplier the multiplier
     */
    public static void addGetter(ClassNode injection, String fieldName, String desc, String fieldDesc, String methodName, Object multiplier) {
        MethodNode mn = new MethodNode(ACC_PUBLIC, methodName, "()" + desc, null, null);
        mn.instructions.add(new VarInsnNode(ALOAD, 0));
        mn.instructions.add(new FieldInsnNode(GETFIELD, injection.name, fieldName, fieldDesc));
        if (multiplier != null) {
            mn.instructions.add(new LdcInsnNode(multiplier));
            mn.instructions.add(new InsnNode(IMUL));
        }
        mn.instructions.add(new InsnNode(getReturnOpcode(desc)));
        injection.methods.add(mn);
    }

    protected static int getOpcode(String desc) {
        desc = desc.substring(desc.indexOf("L") + 1);
        if (desc.length() > 1) {
            return 25;
        }
        char c = desc.charAt(0);
        switch (c) {
            case 'B':
            case 'C':
            case 'I':
            case 'S':
            case 'Z':
                return 21;
            case 'J':
                return 22;
            case 'F':
                return 23;
            case 'D':
                return 24;
        }
        throw new RuntimeException("bad_return");
    }

    /**
     * Return opcode for methods.
     *
     * @param desc the descriptor
     * @return
     */

    protected static int getReturnOpcode(String desc) {
        desc = desc.substring(desc.indexOf(")") + 1);
        if (desc.length() > 1) {
            return 176;
        }
        char c = desc.charAt(0);
        switch (c) {
            case 'B':
            case 'C':
            case 'I':
            case 'S':
            case 'Z':
                return 172;
            case 'J':
                return 173;
            case 'F':
                return 174;
            case 'D':
                return 175;
            case 'E':
            case 'G':
            case 'H':
            case 'K':
            case 'L':
            case 'M':
            case 'N':
            case 'O':
            case 'P':
            case 'Q':
            case 'R':
            case 'T':
            case 'U':
            case 'V':
            case 'W':
            case 'X':
            case 'Y':
        }
        throw new RuntimeException("bad_return");
    }
}
