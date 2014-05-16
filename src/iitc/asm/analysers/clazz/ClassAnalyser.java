package iitc.asm.analysers.clazz;


import iitc.asm.InjectingClassLoader;
import iitc.asm.analysers.Analyser;
import org.objectweb.asm.tree.ClassNode;

/**
 * ClassAnalyser
 *
 * @author Ian
 * @version 1.0
 */
public abstract class ClassAnalyser extends Analyser {
    protected ClassAnalyser(InjectingClassLoader loader) {
        super(loader, "N/A");
    }

    public abstract void analyse(ClassNode node);

    public void analyse() {
        for (ClassNode node : loader.getNodes().values())
            analyse(node);
    }
}
