package iitc.math;

/**
 * BinaryOperator
 *
 * @author Ian
 * @version 1.0
 */
public enum BinaryOperator {
    ADD("+", "sum", 0) {
        @Override
        public int evaluate(int a, int b) {
            return a + b;
        }

        @Override
        public double evaluate(double a, double b) {
            return a + b;
        }
    }, SUBTRACT("-", "difference", 0) {
        @Override
        public int evaluate(int a, int b) {
            return a - b;
        }

        @Override
        public double evaluate(double a, double b) {
            return a - b;
        }
    }, DIVIDE("/", "quotient", 1) {
        @Override
        public int evaluate(int a, int b) {
            return a / b;
        }

        @Override
        public double evaluate(double a, double b) {
            return a / b;
        }
    }, MULTIPLY("*", "product", 1) {
        @Override
        public int evaluate(int a, int b) {
            return a * b;
        }

        @Override
        public double evaluate(double a, double b) {
            return a * b;
        }
    }, EXPT("expt", "power", 1) {
        @Override
        public int evaluate(int a, int b) {
            return (int) Math.pow(a, b);
        }

        @Override
        public double evaluate(double a, double b) {
            return Math.pow(a, b);
        }
    };
    protected Object op;
    protected Object eng;
    protected double safevalue;

    BinaryOperator(Object op, Object eng, double safevalue) {
        this.op = op;
        this.eng = eng;
        this.safevalue = safevalue;
    }

    public static BinaryOperator getByOp(Object op) {
        for (BinaryOperator o : values())
            if (o.op.equals(op))
                return o;
        throw new IllegalArgumentException("Operator must match one of the constants.");
    }

    public static BinaryOperator getByEng(Object eng) {
        for (BinaryOperator o : values())
            if (o.eng.equals(eng))
                return o;
        throw new IllegalArgumentException("Operator must match one of the constants.");
    }

    public abstract int evaluate(int a, int b);

    public abstract double evaluate(double a, double b);

    public Number evaluate(Number a, Number b) {
        if (a == null && b == null)
            return evaluate(safevalue, safevalue);

        return evaluate(a == null ? safevalue : a instanceof Integer ? a.intValue() : a.doubleValue(), b == null ? safevalue : b instanceof Integer ? b.intValue() : b.doubleValue());
    }
}
