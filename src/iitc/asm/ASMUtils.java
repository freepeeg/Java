package iitc.asm;

import org.objectweb.asm.Opcodes;
import org.objectweb.asm.tree.*;

import java.util.ListIterator;

/**
 * ASMUtils
 *
 * @author Ian
 * @version 1.0
 */
public class ASMUtils {

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

    public static class Node {
        public static boolean implementsClass(ClassNode node, Class<?> _interface) {
            return implementsClass(node, Paths.get(_interface));
        }

        public static boolean implementsClass(ClassNode node, String _interface) {
            return node.interfaces.contains(_interface);
        }

        public static class FromInsn {
            public static FieldNode field(ClassNode parent, FieldInsnNode instance) {
                for (FieldNode field : parent.fields)
                    if (field.name.equals(instance.name))
                        return field;
                return null;
            }

            public static MethodNode method(ClassNode parent, MethodInsnNode instance) {
                for (MethodNode method : parent.methods)
                    if (method.name.equals(instance.name) && method.desc.equals(instance.desc))
                        return method;
                return null;
            }
        }
    }

    public static class Descriptor {
        public static String get(Class<?> _class) {
            return "L" + Paths.get(_class) + ";";
        }

        public static String get(Class<?> _class, int arrayLength) {
            StringBuilder builder = new StringBuilder();
            for (int i = 0; i < arrayLength; i++)
                builder.append("[");
            return builder.append(get(_class)).toString();
        }

        public static String get(Primitive primitive) {
            return primitive.getDescriptor();
        }

        public static String get(Primitive primitive, int arrayLength) {
            return primitive.getDescriptor(arrayLength);
        }
    }

    public static class Method implements Opcodes {
        public static MethodNode staticVariableGetter(ClassNode fieldParent, String methodName, String methodDesc, FieldNode field) {
            return staticVariableGetter(fieldParent, methodName, methodDesc, field, null);
        }

        public static MethodNode staticVariableGetter(ClassNode fieldParent, String methodName, String methodDesc, FieldNode field, Number multiplier) {
            return staticVariableGetter(fieldParent, methodName, methodDesc, field.name, field.desc, multiplier);
        }

        public static MethodNode staticVariableGetter(ClassNode fieldParent, String methodName, String methodDesc, String fieldName, String fieldDesc) {
            return staticVariableGetter(fieldParent, methodName, methodDesc, fieldName, fieldDesc, null);
        }

        public static MethodNode staticVariableGetter(ClassNode fieldParent, String methodName, String methodDesc, String fieldName, String fieldDesc, Number multiplier) {
            MethodNode mn = new MethodNode(ACC_PUBLIC, methodName, "()" + methodDesc, null, null);
            mn.instructions.add(new FieldInsnNode(GETSTATIC, fieldParent.name, fieldName, fieldDesc));
            if (multiplier != null) {
                mn.instructions.add(new LdcInsnNode(multiplier));
                mn.instructions.add(new InsnNode(IMUL));
            }
            mn.instructions.add(new InsnNode(getReturnOpcode(fieldDesc)));
            return mn;
        }

        public static MethodNode localVariableGetter(ClassNode parent, String methodName, String methodDesc, FieldNode field) {
            return localVariableGetter(parent, methodName, methodDesc, field, null);
        }

        public static MethodNode localVariableGetter(ClassNode parent, String methodName, String methodDesc, FieldNode field, Number multiplier) {
            return localVariableGetter(parent, methodName, methodDesc, field.name, field.desc, multiplier);
        }

        public static MethodNode localVariableGetter(ClassNode parent, String methodName, String methodDesc, String fieldName, String fieldDesc) {
            return localVariableGetter(parent, methodName, methodDesc, fieldName, fieldDesc, null);
        }

        public static MethodNode localVariableGetter(ClassNode parent, String methodName, String methodDesc, String fieldName, String fieldDesc, Number multiplier) {
            MethodNode mn = new MethodNode(ACC_PUBLIC, methodName, "()" + methodDesc, null, null);
            mn.instructions.add(new VarInsnNode(ALOAD, 0));
            mn.instructions.add(new FieldInsnNode(GETFIELD, parent.name, fieldName, fieldDesc));
            if (multiplier != null) {
                mn.instructions.add(new LdcInsnNode(multiplier));
                mn.instructions.add(new InsnNode(IMUL));
            }
            mn.instructions.add(new InsnNode(getReturnOpcode(fieldDesc)));
            return mn;
        }
    }

    public static class Injector {
        public static void replaceSubclass(ClassNode target, Class<?> subclass) {
            replaceSubclass(target, Paths.get(subclass));
        }

        public static void replaceSubclass(ClassNode target, String subclass) {
            String replacedSuper = "";
            if (!target.superName.equals(""))
                replacedSuper = target.superName;
            if (!replacedSuper.equals("")) {
                for (final MethodNode mn : target.methods) {
                    ListIterator<?> ili = mn.instructions.iterator();
                    while (ili.hasNext()) {
                        AbstractInsnNode ain = (AbstractInsnNode) ili.next();
                        if (ain.getOpcode() == Opcodes.INVOKESPECIAL) {
                            MethodInsnNode min = (MethodInsnNode) ain;
                            if (min.owner.equals(replacedSuper)) {
                                min.owner = subclass;
                            }
                        }
                    }
                }
            }
            target.superName = subclass;
        }
    }

    public static class Paths {
        public static String get(Class<?> _class) {
            StringBuilder canvas = new StringBuilder(_class.getName());
            for (int i = 0; i < canvas.length(); i++) {
                char c = canvas.charAt(i);
                if (c == '.')
                    canvas.replace(i, i + 1, "/");
            }
            return canvas.toString();
        }
    }
}
