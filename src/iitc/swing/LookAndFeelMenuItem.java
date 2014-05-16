package iitc.swing;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * LookAndFeelMenuItem
 *
 * @author Ian
 * @version 1.0
 */
public class LookAndFeelMenuItem extends JCheckBoxMenuItem {
    public LookAndFeelMenuItem(final LookAndFeel lnf, final LookAndFeelMenu menu, final JFrame parent) {
        super(lnf.getName());
        addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                updateUI(lnf, parent);
                menu.update();
            }
        });
    }

    public void updateUI(final LookAndFeel lnf, final JFrame parent) {
        if (!UIManager.getLookAndFeel().equals(lnf))
            try {
                parent.setMinimumSize(null);
                UIManager.setLookAndFeel(lnf);
                SwingUtilities.updateComponentTreeUI(parent);
                parent.revalidate();
                //parent.pack();
                parent.setMinimumSize(parent.getPreferredSize());
            } catch (Exception e) {
                e.printStackTrace();
            }
    }
}
