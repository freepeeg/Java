package iitc.asm;

import iitc.asm.cfg.CodeBlock;
import org.objectweb.asm.tree.AbstractInsnNode;
import org.objectweb.asm.tree.MethodNode;

import java.util.LinkedList;
import java.util.List;

/**
 * ControlFlowGraph
 *
 * @author Ian
 * @version 1.0
 */
public class ControlFlowGraph {
    private final MethodNode method;

    public ControlFlowGraph(MethodNode method) {
        this.method = method;
    }

    private boolean isLeader(AbstractInsnNode node) {
        return node != null && (isInvocation(node) || isUnconditionalBranchTarget(node) || isConditionalBranchTarget(node) || isCompoundConditionalBranchTarget(node));
    }

    private boolean isCompoundConditionalBranchTarget(AbstractInsnNode node) {
        AbstractInsnNode next = node.getNext();
        return next != null && next.getOpcode() > 169 && next.getOpcode() < 172;
    }

    private boolean isInvocation(AbstractInsnNode node) {
        return node.getOpcode() > 181 && node.getOpcode() < 187;
    }

    private boolean isConditionalBranchTarget(AbstractInsnNode node) {
        AbstractInsnNode prev = node.getPrevious();
        return prev != null && prev.getOpcode() > 152 && prev.getOpcode() < 167;
    }

    private boolean isUnconditionalBranchTarget(AbstractInsnNode node) {
        AbstractInsnNode prev1 = node.getPrevious();
        if (prev1 == null)
            return false;
        AbstractInsnNode prev2 = prev1.getPrevious();
        if (prev2 == null)
            return false;
        AbstractInsnNode prev3 = prev2.getPrevious();
        return prev3 != null && prev3.getOpcode() > 166 && prev3.getOpcode() < 170;
    }

    public List<CodeBlock> getBasicBlocks() {
        List<CodeBlock> blocks = new LinkedList<>();
        InstructionList list = new InstructionList(method);
        int key = 0;
        blocks.add(key, new CodeBlock());
        for (AbstractInsnNode node : list) {
            CodeBlock current = blocks.get(key);
            if (isLeader(node)) {
                if (current.isEmpty()) {
                    current.add(node);
                } else {
                    key++;
                    CodeBlock newBlock = new CodeBlock();
                    newBlock.add(node);
                    blocks.add(key, newBlock);
                }
                //invocations are their own block so to make it easy, build next block
                if (isInvocation(node)) {
                    key++;
                    blocks.add(key, new CodeBlock());
                }
            } else
                current.add(node);
        }
        return blocks;
    }
}
