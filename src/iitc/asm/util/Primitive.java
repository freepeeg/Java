package iitc.asm.util;

/**
 * Primitive
 *
 * @author Ian
 * @version 1.0
 */
public enum Primitive {
    BYTE("B"), CHAR("C"), DOUBLE("D"), FLOAT("F"), INT("I"), LONG("J"), SHORT("S"), BOOLEAN("Z");
    private final String identifer;

    Primitive(String identifier) {
        this.identifer = identifier;
    }

    protected String getDescriptor() {
        return identifer;
    }

    protected String getDescriptor(int arrayLength) {
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < arrayLength; i++) {
            builder.append("[");
        }
        return builder.append(identifer).toString();
    }

    @Override
    public String toString() {
        return name().toLowerCase();
    }
}