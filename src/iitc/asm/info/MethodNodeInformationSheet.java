package iitc.asm.info;

import org.objectweb.asm.tree.*;

import java.util.Iterator;

/**
 * MethodNodeInformationSheet
 *
 * @author Ian
 * @version 1.0
 */
public class MethodNodeInformationSheet implements InformationSheet {
    private final MethodNode method;

    public MethodNodeInformationSheet(MethodNode method) {
        this.method = method;
    }

    public InsnList getInstructions() {
        return method.instructions;
    }

    @Override
    public int getAccess() {
        return method.access;
    }

    @Override
    public String getName() {
        return method.name;
    }

    public String getDescriptor() {
        return method.desc;
    }

    @Override
    public String getSignature() {
        return method.signature;
    }

    private String getString(AbstractInsnNode node) {
        if (node instanceof VarInsnNode) {
            VarInsnNode var = (VarInsnNode) node;
            return "Variable: var= " + var.var + ", opcode= " + var.getOpcode();
        }
        if (node instanceof JumpInsnNode) {
            JumpInsnNode jump = (JumpInsnNode) node;
            return "Jump: destination= \"" + jump.label.getLabel().info + ", opcode= " + jump.getOpcode();
        }
        if (node instanceof LabelNode) {
            LabelNode label = (LabelNode) node;
            System.out.println("Label: " + label.getLabel().info + ", opcode= " + label.getOpcode());
        }
        if (node instanceof FrameNode) {
            FrameNode frame = (FrameNode) node;
            return "Frame: type= " + frame.type + ", local= " + frame.local + ", stack= " + frame.stack + ", opcode= " + frame.getOpcode();
        }
        if (node instanceof InsnNode) {
            InsnNode isns = (InsnNode) node;
            return "Insn: opcode= " + isns.getOpcode();
        }
        if (node instanceof FieldInsnNode) {
            FieldInsnNode field = (FieldInsnNode) node;
            return "Field: name= \"" + field.name + "\", descriptor= \"" + field.desc + "\", owner= \"" + field.owner + "\", opcode= " + field.getOpcode();
        }
        return node.toString();
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder("Name: \"" + getName() + "\", descriptor: \"" + getDescriptor() + "\", access: " + getAccess() + ", signature: \"" + getSignature() + "\"\n");
        Iterator<AbstractInsnNode> instructs = getInstructions().iterator();
        while (instructs.hasNext()) {
            AbstractInsnNode node = instructs.next();
            builder.append("\t").append(getString(node)).append("\n");
        }
        return builder.toString();
    }
}
