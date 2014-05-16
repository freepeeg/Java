package iitc.swing;

import javax.swing.*;
import java.awt.*;

/**
 * LookAndFeelMenu
 *
 * @author Ian
 * @version 1.0
 */
public class LookAndFeelMenu extends JMenu {

    public LookAndFeelMenu(JFrame parent, LookAndFeel... lnfs) {
        this("Themes", parent, lnfs);
    }

    public LookAndFeelMenu(String title, JFrame parent, LookAndFeel... lnfs) {
        super(title);
        for (LookAndFeel lnf : lnfs) {
            add(new LookAndFeelMenuItem(lnf, this, parent));
        }
        update();
    }

    public void update() {
        for (Component c : getMenuComponents()) {
            JCheckBoxMenuItem item = ((JCheckBoxMenuItem) c);
            item.setSelected(UIManager.getLookAndFeel().getName().equals(item.getText()));
        }
    }
}
