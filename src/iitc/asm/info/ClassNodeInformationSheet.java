package iitc.asm.info;

import org.objectweb.asm.tree.ClassNode;

import java.util.List;

/**
 * ClassNodeInformationSheet
 *
 * @author Ian
 * @version 1.0
 */
public class ClassNodeInformationSheet implements InformationSheet {
    private final ClassNode node;

    public ClassNodeInformationSheet(ClassNode node) {
        this.node = node;
    }

    public MethodNodeInformationSheet[] getMethodSheets() {
        MethodNodeInformationSheet[] sheets = new MethodNodeInformationSheet[node.methods.size()];
        for (int i = 0; i < sheets.length; i++) {
            sheets[i] = new MethodNodeInformationSheet(node.methods.get(i));
        }
        return sheets;
    }

    public FieldNodeInformationSheet[] getFieldSheets() {
        FieldNodeInformationSheet[] sheets = new FieldNodeInformationSheet[node.fields.size()];
        for (int i = 0; i < sheets.length; i++) {
            sheets[i] = new FieldNodeInformationSheet(node.fields.get(i));
        }
        return sheets;
    }

    public List<String> getInterfaces() {
        return node.interfaces;
    }

    @Override
    public int getAccess() {
        return node.access;
    }

    @Override
    public String getName() {
        return node.name;
    }

    @Override
    public String getSignature() {
        return node.signature;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder("Name: \"" + node.name + "\", access: " + getAccess() + ", interfaces: " + getInterfaces().toString() + ", signature: \"" + getSignature() + "\"\n");
        builder.append("Fields\n\n");
        for (FieldNodeInformationSheet sheet : getFieldSheets()) {
            builder.append(sheet.toString()).append("\n");
        }
        builder.append("Methods\n\n");
        for (MethodNodeInformationSheet sheet : getMethodSheets())
            builder.append(sheet.toString()).append("\n");
        return builder.toString();
    }
}
