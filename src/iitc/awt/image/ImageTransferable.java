package iitc.awt.image;

import java.awt.*;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.Transferable;
import java.awt.datatransfer.UnsupportedFlavorException;

/**
 * ImageTransferable
 *
 * @author Ian
 * @version 1.0
 */
public class ImageTransferable implements Transferable {
    private final DataFlavor[] flavors;
    private Image image;

    public ImageTransferable(Image image) {
        this.image = image;
        this.flavors = new DataFlavor[]{DataFlavor.imageFlavor};
    }

    public Image getTransferData(DataFlavor flavor) throws UnsupportedFlavorException {
        if (isDataFlavorSupported(flavor))
            return image;
        throw new UnsupportedFlavorException(flavor);
    }

    public boolean isDataFlavorSupported(DataFlavor flavor) {
        return flavor.equals(DataFlavor.imageFlavor);
    }

    public DataFlavor[] getTransferDataFlavors() {
        return flavors;
    }
}