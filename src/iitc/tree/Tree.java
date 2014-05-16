package iitc.tree;

import iitc.math.AssociationException;
import iitc.math.Equation;

/**
 * Tree
 *
 * @author Ian
 * @version 1.0
 */
public class Tree {
    private Object first;
    private Tree rest;

    public Tree(Object... first) {
        if (first == null || first.length == 0)
            throw new IllegalArgumentException("Must have one element to properly construct a node.");
        this.first = first[0];
        if (first.length == 1)
            this.rest = null;
        else {
            Tree rest = new Tree(first[1]);
            for (int i = 2; i < first.length; i++)
                rest.append(first[i]);
            this.rest = rest;
        }
    }

    public Tree(Object first, Tree rest) {
        this.first = first;
        this.rest = rest;
    }

    public static void main(String... args) throws AssociationException {
        Tree x_squared = new Tree("+", 3,
                new Tree("expt", new Tree("-", 7, new Tree("/", 4, 2)),
                        3));
        System.out.println(x_squared);
        System.out.println(new Equation(x_squared).evaluate());
    }

    public Tree rest() {
        return rest;
    }

    public Object first() {
        return first;
    }

    @SuppressWarnings("unchecked")
    public Tree get(Object key) {
        if (key == null)
            return null;
        if (key.equals(first))
            return this;
        else if (first instanceof Tree) {
            Tree tree = ((Tree) first).get(key);
            if (tree != null)
                return tree;
        }
        return rest == null ? null : rest.get(key);
    }

    public Tree union(Tree tree) {
        if (tree == null)
            return this;
        if (!contains(tree.first))
            append(tree.first);
        return union(tree.rest);
    }

    public boolean contains(Object key) {
        return get(key) != null;
    }

    public Tree append(Object rest) {
        return append(new Tree(rest));
    }

    public Tree append(Tree rest) {
        end().rest(rest);
        return this;
    }

    protected Tree end() {
        return rest == null ? this : rest.end();
    }

    public Tree rest(Tree rest) {
        this.rest = rest;
        return this;
    }

    public Tree rest(Object rest) {
        return rest(new Tree(rest));
    }

    public Tree first(Object first) {
        this.first = first;
        return this;
    }

    @Override
    public String toString() {
        return ("(" + string(this));
    }

    private String string(Tree lst) {
        return ((lst == null) ? ")"
                : (lst.first == null ? "()" : lst.first.toString())
                + ((lst.rest == null) ? ")"
                : " " + string(lst.rest)));
    }
}
