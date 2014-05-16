package iitc.asm.info;

import org.objectweb.asm.tree.FieldNode;

/**
 * FieldNodeInformationSheet
 *
 * @author Ian
 * @version 1.0
 */
public class FieldNodeInformationSheet implements InformationSheet {
    private final FieldNode field;

    public FieldNodeInformationSheet(FieldNode field) {
        this.field = field;
    }

    @Override
    public int getAccess() {
        return field.access;
    }

    @Override
    public String getName() {
        return field.name;
    }

    public String getDescriptor() {
        return field.desc;
    }

    @Override
    public String getSignature() {
        return field.signature;
    }

    @Override
    public String toString() {
        return "Name: \"" + getName() + "\", type,\"" + getDescriptor() + "\", access: " + getAccess() + ", signature: \"" + getSignature();
    }
}
