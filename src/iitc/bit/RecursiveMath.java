package iitc.bit;

/**
 * RecursiveMath
 * <p/>
 * <p >Do not use this class if you care for stack addition or speed.. It's a joke.</p>
 *
 * @author Ian
 * @version 1.0
 */
public class RecursiveMath {

    public static int add(int a, int b) {
        return b == 0 ? a : add(a ^ b, (a & b) << 1);
    }

    public static int subtract(int a, int b) {
        return add(a, add(~b, 1));
    }

    public static int multiply(int a, int b) {
        return b == 0 ? 0 : add(a, multiply(a, subtract(b, 1)));
    }

    public static int factorial(int a) {
        return a == 0 ? 1 : multiply(a, factorial(subtract(a, 1)));
    }

    public static int pow(int a, int b) {
        return b == 0 ? 1 : multiply(a, pow(a, subtract(b, 1)));
    }

    public static double sqrt(int a) {
        //TODO:Do it.. lol
        return -1;
    }
}
