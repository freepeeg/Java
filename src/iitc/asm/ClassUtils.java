package iitc.asm;

/**
 * ClassUtils
 *
 * @author Ian
 * @version 1.0
 */
public class ClassUtils {
    public static String getPathTo(Class<?> _class) {
        StringBuilder canvas = new StringBuilder(_class.getName());
        for (int i = 0; i < canvas.length(); i++) {
            char c = canvas.charAt(i);
            if (c == '.')
                canvas.replace(i, i + 1, "/");
        }
        return canvas.toString();
    }

    public static String getDescriptor(Class<?> _class) {
        return getDescriptor(getPathTo(_class));
    }

    public static String getDescriptor(String className) {
        return "L" + className + ";";
    }

    public static String getDescriptor(Class<?> _class, int arrayLength) {
        return getDescriptor(getPathTo(_class), arrayLength);
    }

    public static String getDescriptor(String className, int arraylength) {
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < arraylength; i++)
            builder.append("[");
        return builder.append("L").append(className).append(";").toString();
    }
}
