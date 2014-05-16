package iitc.asm.cfg;

import iitc.im.ListOperations;
import org.objectweb.asm.tree.AbstractInsnNode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/**
 * CodeBlock
 *
 * @author Ian
 * @version 1.0
 */
public class CodeBlock implements Iterable<AbstractInsnNode> {
    private final List<AbstractInsnNode> instructions;
    private CodeBlock ifTrue;
    private CodeBlock ifFalse;

    public CodeBlock(AbstractInsnNode[] nodes) {
        this();
        add(nodes);
    }

    public CodeBlock() {
        this.instructions = new ArrayList<>();
    }

    public boolean add(AbstractInsnNode... nodes) {
        return Collections.addAll(this.instructions, nodes);
    }

    public boolean removeAll(AbstractInsnNode... nodes) {
        return ListOperations.removeAll(this.instructions, nodes);
    }

    public boolean isEmpty() {
        return instructions.isEmpty();
    }

    public void setBlock(boolean result, AbstractInsnNode... nodes) {
        if (result)
            (ifTrue) = new CodeBlock(nodes);
        else
            ifFalse = new CodeBlock(nodes);
    }

    public CodeBlock ifFalse() {
        return ifFalse;
    }

    public CodeBlock ifTrue() {
        return ifTrue;
    }

    @Override
    public String toString() {
        return "Code Block: " + instructions + ", TRUE: " + ifTrue + ", FALSE: " + ifFalse;
    }

    @Override
    public Iterator<AbstractInsnNode> iterator() {
        return instructions.iterator();
    }
}
