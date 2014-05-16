package iitc.asm;

/**
 * ASMCondition
 *
 * @author Ian
 * @version 1.0
 */
public interface ASMCondition<A> {
    public static final ASMCondition<Object> TRUE = new ASMCondition<Object>() {
        @Override
        public boolean validate(Object o) {
            return true;
        }
    };
    public static final ASMCondition FALSE = new ASMCondition<Object>() {
        @Override
        public boolean validate(Object o) {
            return false;
        }
    };

    public boolean validate(A a);
}
