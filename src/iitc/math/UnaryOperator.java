package iitc.math;

/**
 * UnaryOperator
 *
 * @author Ian
 * @version 1.0
 */
public enum UnaryOperator {
    NEGATIVE("-", "negative", 0) {
        @Override
        public double evaluate(double d) {
            return -d;
        }

        @Override
        public int evaluate(int i) {
            return -i;
        }
    }, SIN("sin", "sine", 0) {
        @Override
        public double evaluate(double d) {
            return Math.sin(d);
        }

        @Override
        public int evaluate(int i) {
            return (int) Math.sin(i);
        }
    }, COS("cos", "cosine", Math.PI / 2) {
        @Override
        public double evaluate(double d) {
            return Math.cos(d);
        }

        @Override
        public int evaluate(int i) {
            return (int) Math.cos(i);
        }
    }, TAN("tan", "tangent", 0) {
        @Override
        public double evaluate(double d) {
            return Math.tan(d);
        }

        @Override
        public int evaluate(int i) {
            return (int) Math.tan(i);
        }
    }, COT("cot", "cotangent", 0) {
        @Override
        public double evaluate(double d) {
            return 1.0 / Math.tan(d);
        }

        @Override
        public int evaluate(int i) {
            return 1 / (int) Math.tan(i);
        }
    }, SEC("sec", "secant", 0) {
        @Override
        public double evaluate(double d) {
            return 1.0 / Math.cos(d);
        }

        @Override
        public int evaluate(int i) {
            return 1 / (int) Math.cos(i);
        }
    }, CSC("csc", "cosecant", 0) {
        @Override
        public double evaluate(double d) {
            return 1.0 / Math.cos(d);
        }

        @Override
        public int evaluate(int i) {
            return 1 / (int) Math.cos(i);
        }
    }, SQRT("sqrt", "square root", 0) {
        @Override
        public double evaluate(double d) {
            return Math.sqrt(d);
        }

        @Override
        public int evaluate(int i) {
            return (int) Math.sqrt(i);
        }
    },
    ROUND("round", "round", 0) {
        @Override
        public double evaluate(double d) {
            return Math.round(d);
        }

        @Override
        public int evaluate(int i) {
            return Math.round(i);
        }
    },
    FLOOR("floor", "floor", 0) {
        @Override
        public double evaluate(double d) {
            return Math.floor(d);
        }

        @Override
        public int evaluate(int i) {
            return i;
        }
    },
    CEIL("ceil", "ceil", 0) {
        @Override
        public double evaluate(double d) {
            return Math.ceil(d);
        }

        @Override
        public int evaluate(int i) {
            return i;
        }
    };
    protected Object op;
    protected Object eng;
    protected double safevalue;

    UnaryOperator(Object op, Object eng, double safevalue) {
        this.op = op;
        this.eng = eng;
        this.safevalue = safevalue;
    }

    public static UnaryOperator getByOp(Object op) {
        for (UnaryOperator o : values())
            if (o.op.equals(op))
                return o;
        throw new IllegalArgumentException("Operator must match one of the constants.");
    }

    public static UnaryOperator getByEng(Object eng) {
        for (UnaryOperator o : values())
            if (o.eng.equals(eng))
                return o;
        throw new IllegalArgumentException("Operator must match one of the constants.");
    }

    public abstract double evaluate(double d);

    public abstract int evaluate(int i);

    public Number evaluate(Number a) {
        return evaluate(a == null ? safevalue : a instanceof Integer ? a.intValue() : a.doubleValue());
    }
}
