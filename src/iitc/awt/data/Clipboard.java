package iitc.awt.data;

import iitc.awt.image.ImageTransferable;

import java.awt.*;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.StringSelection;
import java.awt.datatransfer.Transferable;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.io.IOException;

/**
 * Clipboard
 *
 * @author Ian
 * @version 1.0
 */
public class Clipboard {
    public static void write(Image image) {
        write(new ImageTransferable(image));
    }

    public static void write(String string) {
        write(new StringSelection(string));
    }

    public static void write(Transferable content) {
        Toolkit.getDefaultToolkit().getSystemClipboard().setContents(content, null);
    }

    public static Object read(DataFlavor dataType) throws IOException, UnsupportedFlavorException {
        Transferable t = Toolkit.getDefaultToolkit().getSystemClipboard().getContents(null);
        return t.getTransferData(dataType);
    }

}
