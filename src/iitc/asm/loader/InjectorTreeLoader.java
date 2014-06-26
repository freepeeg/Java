package iitc.asm.loader;

import iitc.asm.tools.Tool;
import iitc.asm.Tree;

import java.util.ArrayList;
import java.util.List;

/**
 * InjectorTreeLoader
 *
 * @author Ian
 * @version 1.0
 */
public class InjectorTreeLoader extends TreeLoader implements Injector {
    private final List<Tool<InjectorTreeLoader>> tools;

    private InjectorTreeLoader(Tree tree) {
        super(tree);
        this.tools = new ArrayList<>();
    }

    public boolean add(Tool<InjectorTreeLoader> tool) {
        return tools.add(tool);
    }

    public boolean remove(Tool<InjectorTreeLoader> tool) {
        return tools.remove(tool);
    }

    @Override
    public boolean inject() {
        boolean injected = true;
        for (Tool<InjectorTreeLoader> tool : tools) {
            if (!tool.work(this)) {
                injected = false;
            }
        }
        return injected;
    }
}
