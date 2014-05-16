package iitc.asm;

import org.objectweb.asm.Opcodes;
import org.objectweb.asm.tree.*;

/**
 * NodeAnalyser
 *
 * @author Ian
 * @version 1.0
 */
public abstract class NodeAnalyser {
    public static int paramCount(MethodNode method) {
        return paramCount(method.desc);
    }

    public static int paramCount(String descriptor) {
        int count = 0;
        if (descriptor.contains("(") && descriptor.contains(")")) {
            String param = descriptor.substring(descriptor.indexOf("(") + 1, descriptor.indexOf(")"));
            for (char c : param.toCharArray()) {
                if (c == ';')
                    count++;
            }
        }
        return count;
    }

    public static String methodReturnObject(MethodNode method) {
        return methodReturnObject(method.desc);
    }

    public static String methodReturnDescriptor(MethodNode method) {
        return methodReturnDescriptor(method.desc);
    }

    public static String methodReturnObject(String descriptor) {
        String returnDescriptor = methodReturnDescriptor(descriptor);
        if (returnDescriptor == null)
            return null;
        return objectFromDescriptor(returnDescriptor);
    }

    public static String methodReturnDescriptor(String descriptor) {
        return descriptor.contains("(") && descriptor.contains(")") ? descriptor.substring(descriptor.indexOf(")") + 1) : null;
    }

    public static int arrayLength(FieldNode field) {
        return arrayLength(field.desc);
    }

    public static String objectFromDescriptor(FieldNode field) {
        return objectFromDescriptor(field.desc);
    }

    public static String objectFromDescriptor(String descriptor) {
        String end = descriptor;
        if (end.startsWith("[")) {
            end = end.substring(end.lastIndexOf('[') + 1);
        }
        if (end.startsWith("L")) {
            return end.substring(1, end.length() - 1);
        } else if (end.equals("V")) {
            return "void";
        } else
            for (Primitive primitive : Primitive.values()) {
                if (end.equals(primitive.getDescriptor())) {
                    return primitive.toString();
                }
            }
        return null;
    }

    public static int arrayLength(String descriptor) {
        if (isArray(descriptor)) {
            int count = 0;
            for (char c : descriptor.toCharArray()) {
                if (c == '[')
                    count++;
            }
            return count;
        }
        return 0;
    }

    public static boolean isArray(FieldNode field) {
        return isArray(field.desc);
    }

    public static boolean isArray(String descriptor) {
        return descriptor.startsWith("[");
    }

    public static boolean isReference(MethodNode method, MethodInsnNode instance) {
        return method.name.equals(instance.name) && method.desc.equals(instance.desc);
    }

    public static boolean isReference(FieldNode field, FieldInsnNode instance) {
        return field.name.equals(instance.name) && field.desc.equals(instance.desc);
    }

    public static boolean nameMatch(String className, Class<?> objectClass) {
        return className.equals(ClassUtils.getPathTo(objectClass));
    }

    public static boolean nameMatch(ClassNode node, Class<?> objectClass) {
        return nameMatch(node.name, objectClass);
    }

    public static boolean hasInterface(ClassNode node, Class<?> interfaceClass) {
        return node.interfaces.contains(ClassUtils.getPathTo(interfaceClass));
    }

    public static boolean hasInterface(ClassNode node, String interfaceName) {
        return node.interfaces.contains(interfaceName);
    }

    public static boolean descriptorMatch(FieldNode field, Primitive descriptor, int arrayLength) {
        return descriptorMatch(field.desc, descriptor, arrayLength);
    }

    public static boolean descriptorMatch(FieldNode field, Primitive descriptor) {
        return descriptorMatch(field.desc, descriptor);
    }

    public static boolean descriptorMatch(FieldNode field, Class<?> _class, int arrayLength) {
        return descriptorMatch(field.desc, _class, arrayLength);
    }

    public static boolean descriptorMatch(FieldNode field, Class<?> _class) {
        return descriptorMatch(field.desc, _class);
    }

    public static boolean descriptorMatch(FieldInsnNode field, Primitive descriptor, int arrayLength) {
        return descriptorMatch(field.desc, descriptor, arrayLength);
    }

    public static boolean descriptorMatch(FieldInsnNode field, Primitive descriptor) {
        return descriptorMatch(field.desc, descriptor);
    }

    public static boolean descriptorMatch(FieldInsnNode field, Class<?> _class, int arrayLength) {
        return descriptorMatch(field.desc, _class, arrayLength);
    }

    public static boolean descriptorMatch(FieldInsnNode field, Class<?> _class) {
        return descriptorMatch(field.desc, _class);
    }

    public static boolean descriptorMatch(String descriptorOne, Primitive descriptorTwo, int arrayLength) {
        return descriptorMatch(descriptorOne, descriptorTwo.getDescriptor(arrayLength));
    }

    public static boolean descriptorMatch(String descriptorOne, Primitive descriptorTwo) {
        return descriptorMatch(descriptorOne, descriptorTwo.getDescriptor());
    }

    public static boolean descriptorMatch(String descriptor, Class<?> _class, int arrayLength) {
        return descriptorMatch(descriptor, ClassUtils.getDescriptor(_class, arrayLength));
    }

    public static boolean descriptorMatch(String descriptor, Class<?> _class) {
        return descriptorMatch(descriptor, ClassUtils.getDescriptor(_class));
    }

    public static boolean descriptorMatch(FieldInsnNode field, String descriptor) {
        return descriptorMatch(field.desc, descriptor);
    }

    public static boolean descriptorMatch(FieldNode field, String descriptor) {
        return descriptorMatch(field.desc, descriptor);
    }

    public static boolean descriptorMatch(String descriptorOne, String descriptorTwo) {
        return descriptorOne.equals(descriptorTwo);
    }

    public static FieldNode getField(ClassNode node, FieldInsnNode instance) {
        for (FieldNode field : node.fields) {
            if (isReference(field, instance))
                return field;
        }
        return null;
    }

    public static FieldNode getField(ClassNode node, String name) {
        for (FieldNode field : node.fields) {
            if (field.name.equals(name))
                return field;
        }
        return null;
    }

    public static MethodNode getMethod(ClassNode node, MethodInsnNode instance) {
        for (MethodNode method : node.methods) {
            if (isReference(method, instance))
                return method;
        }
        return null;
    }

    public static MethodNode getMethod(ClassNode node, String name) {
        for (MethodNode method : node.methods) {
            if (method.name.equals(name))
                return method;
        }
        return null;
    }

    public static FieldNode localField(ClassNode node, Primitive type, int arrayLength) {
        for (FieldNode field : node.fields) {
            if ((field.access & Opcodes.ACC_STATIC) == 0 && descriptorMatch(field, type, arrayLength)) {
                return field;
            }
        }
        return null;
    }

    public static FieldNode staticField(ClassNode node, Primitive type, int arrayLength) {
        for (FieldNode field : node.fields) {
            if ((field.access & Opcodes.ACC_STATIC) != 0 && descriptorMatch(field, type, arrayLength)) {
                return field;
            }
        }
        return null;
    }

    public static FieldNode localField(ClassNode node, Primitive type) {
        return localField(node, type, 0);
    }

    public static FieldNode staticField(ClassNode node, Primitive type) {
        return staticField(node, type, 0);
    }

    public static FieldNode localField(InjectingClassLoader loader, ClassNode node, Class<?> type, int arrayLength) {
        for (FieldNode field : node.fields) {
            if ((field.access & Opcodes.ACC_STATIC) == 0 && arrayLength(field) == arrayLength) {
                ClassNode fieldNode = loader.find(field);
                if (fieldNode != null && hasInterface(fieldNode, type))
                    return field;
            }
        }
        return null;
    }

    public static FieldNode staticField(InjectingClassLoader loader, ClassNode node, Class<?> type, int arrayLength) {
        for (FieldNode field : node.fields) {
            if ((field.access & Opcodes.ACC_STATIC) != 0 && arrayLength(field) == arrayLength) {
                ClassNode fieldNode = loader.find(field);
                if (fieldNode != null && hasInterface(fieldNode, type))
                    return field;
            }
        }
        return null;
    }

    public static FieldNode localField(InjectingClassLoader loader, ClassNode node, Class<?> type) {
        return localField(loader, node, type, 0);
    }

    public static FieldNode staticField(InjectingClassLoader loader, ClassNode node, Class<?> type) {
        return staticField(loader, node, type, 0);
    }

    public static FieldNode localField(ClassNode node, Class<?> type, int arrayLength) {
        for (FieldNode field : node.fields)
            if ((field.access & Opcodes.ACC_STATIC) == 0 && descriptorMatch(field, type, arrayLength))
                return field;
        return null;
    }

    public static FieldNode staticField(ClassNode node, Class<?> type, int arrayLength) {
        for (FieldNode field : node.fields)
            if ((field.access & Opcodes.ACC_STATIC) != 0 && descriptorMatch(field, type, arrayLength))
                return field;
        return null;
    }

    public static FieldNode localField(ClassNode node, Class<?> type) {
        return localField(node, type, 0);
    }

    public static FieldNode staticField(ClassNode node, Class<?> type) {
        return staticField(node, type, 0);
    }
}
