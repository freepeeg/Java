package iitc.math;

import iitc.tree.Tree;

/**
 * Equation
 *
 * @author Ian
 * @version 1.0
 */
public class Equation {
    private final Object tree;

    public Equation(String equation) {
        this(SyntaxTokenizer.toTree(equation));
    }

    public Equation(char variable) {
        this.tree = variable;
    }

    public Equation(Tree syntaxTree) {
        this.tree = syntaxTree;
    }

    private static Object lhs(Tree tree) {
        if (tree == null)
            return null;
        Tree rest = tree.rest();
        return rest == null ? null : rest.first();
    }

    private static Object rhs(Tree tree) {
        if (tree == null)
            return null;
        Tree rest = tree.rest();
        if (rest == null)
            return null;
        Tree second = rest.rest();
        return second == null ? null : second.first();
    }

    public Number evaluate() throws AssociationException {
        return evaluate(tree);
    }

    private Number evaluate(Object tree) throws AssociationException {
        if (!(tree instanceof Tree))
            throw new AssociationException(tree);
        Tree t = (Tree) tree;
        Object op = op(t);
        Object lhs = lhs(t);
        Object rhs = rhs(t);
        Number second_value = rhs instanceof Tree ? evaluate(rhs) : (Number) rhs;
        if (lhs instanceof String)
            throw new AssociationException(lhs);
        Number value = lhs instanceof Tree ? evaluate(lhs) : (Number) lhs;
        if (rhs == null)
            return UnaryOperator.getByOp(op).evaluate(value);
        return BinaryOperator.getByOp(op).evaluate(value, second_value);
    }

    private Object op(Tree tree) {
        return tree == null ? null : tree.first();
    }

    public Number evaluate(Tree bindings) throws AssociationException {
        return evaluate(tree, bindings);
    }

    private Number evaluate(Object tree, Tree bindings) throws AssociationException {
        if (tree instanceof Tree) {
            Tree t = (Tree) tree;
            Object op = op(t);
            Object lhs = lhs(t);
            Object rhs = rhs(t);
            Number value = lhs instanceof Tree ? evaluate(lhs, bindings) : lhs instanceof Number ? (Number) lhs : (Number) lhs(bindings.get(lhs));
            if (rhs == null)
                return UnaryOperator.getByOp(op).evaluate(value);
            Number second_value = rhs instanceof Tree ? evaluate(rhs, bindings) : rhs instanceof Number ? (Number) rhs : (Number) lhs(bindings.get(rhs));
            return BinaryOperator.getByOp(op).evaluate(value, second_value);
        }
        return tree instanceof Number ? (Number) tree : (Number) lhs(bindings.get(tree));
    }

    public boolean equals(Object o, Tree bindings) {
        if (!(o instanceof Equation))
            return false;
        Equation e = (Equation) o;
        try {
            Number result = e.evaluate(bindings);
            return result.equals(evaluate(bindings));
        } catch (AssociationException e1) {
            return false;
        }
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Equation))
            return false;
        Equation e = (Equation) o;
        try {
            Number result = e.evaluate();
            return result.equals(evaluate());
        } catch (AssociationException e1) {
            return false;
        }
    }
}
