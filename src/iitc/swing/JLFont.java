package iitc.swing;

import javax.swing.*;
import java.awt.*;

/**
 * JLFont
 *
 * @author Ian
 * @version 1.0
 */
public class JLFont {
    public static Font fillContainer(JLabel component, Font original) {
        if (original == null)
            return original;
        String text = component.getText();
        FontMetrics metrics = component.getFontMetrics(original);
        if (metrics == null)
            return original;
        int width = metrics.stringWidth(text);
        Insets insets = component.getInsets();
        int compWidth = component.getWidth() - insets.left - insets.right;
        double widthRatio = (double) compWidth / (double) width;
        int newFontSize = (int) (original.getSize() * widthRatio);
        int compHeight = component.getHeight() - insets.top - insets.bottom;
        int fontToUse = (int) Math.round(Math.min(newFontSize, compHeight) * 0.9);
        return new Font(original.getName(), Font.PLAIN, fontToUse);
    }
}
