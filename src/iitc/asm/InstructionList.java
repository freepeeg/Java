package iitc.asm;

import iitc.im.AdjustableIterator;
import iitc.im.Precondition;
import org.objectweb.asm.Opcodes;
import org.objectweb.asm.tree.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * InstructionList
 *
 * @author Ian
 * @version 1.0
 */
public class InstructionList implements Opcodes, Iterable<AbstractInsnNode> {
    private static String[] OPCODES = {
            "nop", "aconst_null", "iconst_m1", "iconst_0", "iconst_1", "iconst_2", "iconst_3", "iconst_4", "iconst_5",
            "lconst_0", "lconst_1", "fconst_0", "fconst_1", "fconst_2", "dconst_0", "dconst_1", "bipush", "sipush",
            "ldc", "N/A", "N/A", "iload", "lload", "fload", "dload", "aload", "N/A", "N/A", "N/A", "N/A", "N/A", "N/A",
            "N/A", "N/A", "N/A", "N/A", "N/A", "N/A", "N/A", "N/A", "N/A", "N/A", "N/A", "N/A", "N/A", "N/A",
            "iaload", "laload", "faload", "daload", "aaload", "baload", "caload", "saload", "istore", "lstore", "fstore", "dstore", "astore",
            "N/A", "N/A", "N/A", "N/A", "N/A", "N/A", "N/A", "N/A", "N/A", "N/A", "N/A", "N/A", "N/A", "N/A", "N/A", "N/A", "N/A", "N/A", "N/A", "N/A",
            "iastore", "lastore", "fastore", "dastore", "aastore", "bastore", "castore", "sastore",
            "pop", "pop2", "dup", "dup_x1", "dup_x2", "dup2", "dup2_x1", "dup2_x2", "swap", "iadd", "ladd", "fadd", "dadd", "isub", "lsub", "fsub", "dsub",
            "imul", "lmul", "fmul", "dmul", "idiv", "ldiv", "fdiv", "ddiv", "irem", "lrem", "frem", "drem", "ineg", "lneg", "fneg", "dneg",
            "ishl", "lshl", "ishr", "lshr", "iushr", "lushr", "iand", "land", "ior", "lor", "ixor", "lxor", "iinc",
            "i2l", "i2f", "i2d", "l2i", "l2f", "l2d", "f2i", "f2l", "f2d", "d2i", "d2l", "d2f", "i2b", "i2c", "i2s",
            "lcmp", "fcmpl", "fcmpg", "dcmpl", "dcmpg", "ifeq", "ifne", "iflt", "ifge", "ifgt", "ifle",
            "if_icmpeq", "if_icmpne", "if_icmplt", "if_icmpge", "if_icmpgt", "if_icmple", "if_acmpeq", "if_acmpne",
            "goto", "jsr", "ret", "tableswitch", "lookupswitch", "ireturn", "lreturn", "freturn", "dreturn", "areturn",
            "return", "getstatic", "putstatic", "getfield", "putfield", "invokevirtual", "invokespecial",
            "invokestatic", "invokeinterface", "invokedynamic", "new", "newarray", "anewarray", "arraylength",
            "athrow", "checkcast", "instanceof", "monitorenter", "monitorexit", "N/A", "multianewarray", "ifnull", "ifnonnull"
    };
    protected final InsnList instructions;

    public InstructionList(MethodNode method) {
        this(method.instructions);
    }

    protected InstructionList(InsnList instructions) {
        this.instructions = instructions;
    }

    public static InstructionList revealGotos(MethodNode method) {
        return new ControlFlowList(method);
    }

    public static String opcodeString(AbstractInsnNode node) {
        return node != null && node.getOpcode() < OPCODES.length && node.getOpcode() >= 0 ? OPCODES[node.getOpcode()] : "NULL";
    }

    public static String descriptionString(AbstractInsnNode node) {
        if (node == null)
            return "null";
        else if (node instanceof VarInsnNode) {
            VarInsnNode var = (VarInsnNode) node;
            return "Variable: var= " + var.var + ", opcode= " + var.getOpcode();
        } else if (node instanceof JumpInsnNode) {
            JumpInsnNode jump = (JumpInsnNode) node;
            return "Jump: destination= \"" + jump.label.getLabel().info + "\", opcode= " + jump.getOpcode();
        } else if (node instanceof LabelNode) {
            LabelNode label = (LabelNode) node;
            return "Label: " + label.getLabel().info + ", opcode= " + label.getOpcode();
        } else if (node instanceof FrameNode) {
            FrameNode frame = (FrameNode) node;
            return "Frame: type= " + frame.type + ", local= " + frame.local + ", stack= " + frame.stack + ", opcode= " + frame.getOpcode();
        } else if (node instanceof InsnNode) {
            InsnNode isns = (InsnNode) node;
            return "Insn: opcode= " + isns.getOpcode();
        } else if (node instanceof FieldInsnNode) {
            FieldInsnNode field = (FieldInsnNode) node;
            return "Field: name= \"" + field.name + "\", descriptor= \"" + field.desc + "\", owner= \"" + field.owner + "\", opcode= " + field.getOpcode();
        } else if (node instanceof LdcInsnNode) {
            LdcInsnNode ldc = (LdcInsnNode) node;
            return "Ldc: opcode= " + ldc.getOpcode() + ", cst= " + ldc.cst + ", opcode= " + ldc.getOpcode();
        } else if (node instanceof MethodInsnNode) {
            MethodInsnNode method = (MethodInsnNode) node;
            return "Method: name= \"" + method.name + "\", descriptor= \"" + method.desc + "\", owner= \"" + method.owner + "\", opcode= " + method.getOpcode();
        } else if (node instanceof TypeInsnNode) {
            TypeInsnNode type = (TypeInsnNode) node;
            return "Type: desc= \"" + type.desc + "\", opcode= " + type.getOpcode();
        } else if (node instanceof IincInsnNode) {
            IincInsnNode iinc = (IincInsnNode) node;
            return "Increment: var= " + iinc.var + ", amount= " + iinc.incr + ", opcode= " + iinc.getOpcode();
        } else
            return node.toString();
    }

    public void set(AbstractInsnNode location, AbstractInsnNode replacement) {
        instructions.set(location, replacement);
        System.out.println("Setting " + opcodeString(replacement) + " as " + opcodeString(location));
    }

    public List<List<AbstractInsnNode>> findAll(AbstractInsnNode... pattern) {
        return findAll(12, 0, pattern);
    }

    public List<List<AbstractInsnNode>> findAll(AbstractInsnNode start, AbstractInsnNode[] pattern) {
        return findAll(12, start, pattern);
    }

    public List<List<AbstractInsnNode>> findAll(int maxSpacing, AbstractInsnNode[] pattern) {
        return findAll(maxSpacing, 0, pattern);
    }

    public List<List<AbstractInsnNode>> findAll(int maxSpacing, AbstractInsnNode start, AbstractInsnNode[] pattern) {
        return findAll(maxSpacing, indexOf(start), pattern);
    }

    public List<List<AbstractInsnNode>> findAll(int maxSpacing, int start, AbstractInsnNode[] pattern) {
        List<List<AbstractInsnNode>> allPatterns = new ArrayList<>();
        List<AbstractInsnNode> occurrence;
        while ((occurrence = find(maxSpacing, start, pattern)) != null) {
            allPatterns.add(occurrence);
            start = indexOf(occurrence.get(occurrence.size() - 1)) + 1;
        }
        return allPatterns.size() > 0 ? allPatterns : null;
    }

    public List<AbstractInsnNode> find(AbstractInsnNode... pattern) {
        return find(12, 0, pattern);
    }

    public List<AbstractInsnNode> find(AbstractInsnNode start, AbstractInsnNode[] pattern) {
        return find(12, start, pattern);
    }

    public List<AbstractInsnNode> find(int maxSpacing, AbstractInsnNode[] pattern) {
        return find(maxSpacing, 0, pattern);
    }

    public List<AbstractInsnNode> find(int maxSpacing, AbstractInsnNode start, AbstractInsnNode[] pattern) {
        return find(maxSpacing, indexOf(start), pattern);
    }

    public void remove(AbstractInsnNode node) {
        instructions.remove(node);
    }

    private List<AbstractInsnNode> find(int maxSpacing, int start, AbstractInsnNode[] pattern) {
        if (pattern == null || pattern.length == 0 || start < 0 || maxSpacing < 1)
            return null;
        AdjustableIterator<AbstractInsnNode> fromStart = iterator(start);
        int patternIndex = 0;
        int offset = 0;
        List<AbstractInsnNode> nodes = new ArrayList<>();
        AbstractInsnNode next = null;
        while (patternIndex < pattern.length && fromStart.hasNext()) {
            if (offset < maxSpacing) {
                next = fromStart.next();
                if (isMatch(next, pattern[patternIndex])) {
                    //System.out.println("[MATCH] " + InstructionList.opcodeString(next) + " ---> " + InstructionList.opcodeString(pattern[patternIndex]) + " ||| " + InstructionList.descriptionString(next) + " ---> " + InstructionList.descriptionString(pattern[patternIndex]));
                    offset = 0;
                    patternIndex++;
                    nodes.add(next);
                } else {
                    //System.out.println("[NOMATCH] " + InstructionList.opcodeString(next) + " ---> " + InstructionList.opcodeString(pattern[patternIndex]) + " ||| " + InstructionList.descriptionString(next) + " ---> " + InstructionList.descriptionString(pattern[patternIndex]));
                    offset++;
                }
            } else {
                if (nodes.size() == pattern.length) {
                    return nodes;
                } else if (nodes.size() > 0) {
                    int nodeIndex = indexOf(nodes.get(nodes.size() - 1));
                    fromStart.adjust(nodeIndex + 1);
                } else if (next == null) {
                    fromStart.adjust(start + maxSpacing);
                } else {
                    int newIndex = indexOf(next);
                    fromStart.adjust(newIndex > start ? newIndex + 1 : start + maxSpacing);
                }
                offset = 0;
                patternIndex = 0;
                nodes = new ArrayList<>();
            }
        }
        return nodes.size() == pattern.length ? nodes : null;
    }

    private boolean isMatch(AbstractInsnNode one, AbstractInsnNode two) {
        //condition to match two null params
        if (one == null && two == null || (two != null && two.getOpcode() == 9000))
            return true;
        if (one != null && two != null && (one.getOpcode() != two.getOpcode()))
            return false;

        if (one instanceof VarInsnNode && two instanceof VarInsnNode) {
            VarInsnNode var = (VarInsnNode) one;
            VarInsnNode var2 = (VarInsnNode) two;
            return var.var == 9000 || var2.var == 9000 || var.var == var2.var;
        } else if (one instanceof JumpInsnNode && two instanceof JumpInsnNode) {
            JumpInsnNode jump = (JumpInsnNode) one;
            JumpInsnNode jump2 = (JumpInsnNode) two;
            if (jump2.label == null || jump2.label.getLabel() == null)
                return true;
            Object info = jump.label.getLabel().info;
            Object info2 = jump2.label.getLabel().info;
            return info != null && info2 != null && info.equals(info2);
        } else if (one instanceof LabelNode && two instanceof LabelNode) {
            LabelNode label = (LabelNode) one;
            LabelNode label2 = (LabelNode) two;
            Object info = label.getLabel().info;
            Object info2 = label2.getLabel().info;
            return info != null && info2 != null && info.equals(info2);
        } else if (one instanceof IntInsnNode && two instanceof IntInsnNode) {
            IntInsnNode node = (IntInsnNode) one;
            IntInsnNode node2 = (IntInsnNode) two;
            return node2.operand == 9000 || node.operand == 9000 || node.operand == node2.operand;
        } else if (one instanceof FrameNode && two instanceof FrameNode) {
            FrameNode frame = (FrameNode) one;
            FrameNode frame2 = (FrameNode) two;
            return frame.type == frame2.type && (frame2.local == null || frame.local != null && frame.local.equals(frame2.local)) && (frame2.stack == null || frame.stack != null && frame.stack.equals(frame2.stack));
        } else if (one instanceof FieldInsnNode && two instanceof FieldInsnNode) {
            FieldInsnNode field = (FieldInsnNode) one;
            FieldInsnNode field2 = (FieldInsnNode) two;
            return (field2.name == null || field.name.equals(field2.name)) && (field2.desc == null || field.desc.equals(field2.desc)) && (field2.owner == null || field.owner.equals(field2.owner));
        } else if (one instanceof LdcInsnNode && two instanceof LdcInsnNode) {
            LdcInsnNode ldc = (LdcInsnNode) one;
            LdcInsnNode ldc2 = (LdcInsnNode) two;
            return ldc2.cst == null || (ldc.cst != null && ldc.cst.equals(ldc2.cst));
        } else if (one instanceof MethodInsnNode && two instanceof MethodInsnNode) {
            MethodInsnNode method = (MethodInsnNode) one;
            MethodInsnNode method2 = (MethodInsnNode) two;
            return (method2.name == null || method.name.equals(method2.name)) && (method2.desc == null || method.desc.equals(method2.desc)) && (method2.owner == null || method.owner.equals(method2.owner));
        } else if (one instanceof TypeInsnNode && two instanceof TypeInsnNode) {
            TypeInsnNode type = (TypeInsnNode) one;
            TypeInsnNode type2 = (TypeInsnNode) two;
            return type2.desc == null || type.desc.equals(type2.desc);
        } else if (one instanceof IincInsnNode && two instanceof IincInsnNode) {
            IincInsnNode iinc = (IincInsnNode) one;
            IincInsnNode iinc2 = (IincInsnNode) two;
            return iinc.var == iinc2.var && iinc.incr == iinc2.incr;
        } else
            //returning true here implies just matching opcodes as there are no specific cases to evaluate
            return true;
    }

    public int indexOf(AbstractInsnNode node) {
        return instructions.indexOf(node);
    }

    public AbstractInsnNode getLast() {
        return instructions.getLast();
    }

    public AbstractInsnNode getFirst() {
        return instructions.getFirst();
    }

    public AbstractInsnNode get(int index) {
        return instructions.get(index);
    }

    public int size() {
        return instructions.size();
    }

    public boolean isEmpty() {
        return size() == 0;
    }

    public boolean contains(Object o) {
        return o instanceof AbstractInsnNode && instructions.contains((AbstractInsnNode) o);
    }

    public FieldInsnNode field(String descriptor) {
        for (AbstractInsnNode node : this)
            if (node instanceof FieldInsnNode && ((FieldInsnNode) node).desc.equals(descriptor))
                return (FieldInsnNode) node;
        return null;
    }

    public List<FieldInsnNode> fields(String descriptor) {
        List<FieldInsnNode> fields = new ArrayList<>(size());
        for (AbstractInsnNode node : this)
            if (node instanceof FieldInsnNode && ((FieldInsnNode) node).desc.equals(descriptor))
                fields.add((FieldInsnNode) node);
        return fields;
    }

    public List<AbstractInsnNode> opcodes(int opcode) {
        List<AbstractInsnNode> instructions = new ArrayList<>(this.instructions.size());
        for (AbstractInsnNode node : this)
            if (node.getOpcode() == opcode)
                instructions.add(node);
        return instructions;
    }

    public AbstractInsnNode opcode(int opcode) {
        for (AbstractInsnNode node : this)
            if (node.getOpcode() == opcode)
                return node;
        return null;
    }

    public <A extends AbstractInsnNode> A type(Class<A> type, Precondition<A>... conditions) {
        for (AbstractInsnNode node : this)
            if (node.getClass().equals(type)) {
                A cast = (A) node;
                for (Precondition<A> a : conditions)
                    if (!a.condition(cast))
                        return null;
                return cast;
            }
        return null;
    }

    public <A extends AbstractInsnNode> List<A> types(Class<A> type, Precondition<A>... conditions) {
        List<A> instructions = new ArrayList<>(this.instructions.size());
        for (AbstractInsnNode node : this)
            if (node.getClass().equals(type)) {
                A cast = (A) node;
                boolean passed = true;
                for (Precondition<A> a : conditions)
                    if (!a.condition(cast))
                        passed = false;
                if (passed)
                    instructions.add(cast);
            }
        return instructions;
    }

    @Override
    public AdjustableIterator<AbstractInsnNode> iterator() {
        return iterator(0);
    }

    public AdjustableIterator<AbstractInsnNode> iterator(int index) {
        return iterator(index, true);
    }

    public AdjustableIterator<AbstractInsnNode> iterator(final boolean skipNullNodes) {
        return iterator(0, skipNullNodes);
    }

    public AdjustableIterator<AbstractInsnNode> iterator(final int index, final boolean skipNullNodes) {
        return new AdjustableIterator<AbstractInsnNode>() {
            int i = index;

            @Override
            public boolean hasNext() {
                return i < size();
            }

            @Override
            public AbstractInsnNode next() {
                AbstractInsnNode current = instructions.get(i++);
                return skipNullNodes && hasNext() && current.getOpcode() == -1 ? next() : current;
            }

            @Override
            public void remove() {
                instructions.remove(instructions.get(i));
            }

            @Override
            public void adjust(int index) {
                i = index;
            }

            @Override
            public int getIndex() {
                return i;
            }
        };
    }

    @Override
    public String toString() {
        return Arrays.toString(instructions.toArray());
    }

    /**
     * ControlFlowList
     * <p/>
     * This simply replaces gotos with the destination node so you don't have to mess with them
     *
     * @author Ian
     */
    private static class ControlFlowList extends InstructionList {

        public ControlFlowList(MethodNode method) {
            super(method);
        }

        @Override
        public AdjustableIterator<AbstractInsnNode> iterator() {
            return new AdjustableIterator<AbstractInsnNode>() {
                int index = 0;

                @Override
                public boolean hasNext() {
                    return index < size();
                }

                @Override
                public AbstractInsnNode next() {
                    AbstractInsnNode current = instructions.get(index++);
                    return current.getOpcode() == GOTO ? instructions.get(instructions.indexOf(((JumpInsnNode) current).label)).getNext() : current;
                }

                @Override
                public void remove() {
                    instructions.remove(instructions.get(index));
                }

                @Override
                public void adjust(int index) {
                    this.index = index;
                }

                @Override
                public int getIndex() {
                    return index;
                }
            };
        }
    }
}