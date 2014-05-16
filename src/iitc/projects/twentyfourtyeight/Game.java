package iitc.projects.twentyfourtyeight;

import iitc.awt.Colors;
import iitc.swing.JLFont;

import javax.swing.*;
import java.awt.*;
import java.text.NumberFormat;

/**
 * Game
 *
 * @author Ian
 * @version 1.0
 */
public class Game extends JFrame {
    protected final BoardManager manager;

    static {
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (UnsupportedLookAndFeelException | ClassNotFoundException | InstantiationException | IllegalAccessException e) {
            e.printStackTrace();
        }
    }

    public Game(final Board game) {
        super("Welcome " + game.user + "!");
        final JPanel game_panel = new JPanel();
        this.manager = new BoardManager(game) {
            @Override
            public JFrame getParent() {
                return Game.this;
            }

            @Override
            protected JComponent getContainer() {
                return game_panel;
            }
        };
        game_panel.setLayout(new GridLayout(manager.getLength(), manager.getLength(), 2, 1));
        game_panel.setBorder(BorderFactory.createLineBorder(Color.black));
        manager.addBoardListener(new GameListener() {
            @Override
            public void onWin(GameEvent e) {
                manager.setState(Board.State.FINISHED);
                for (Component c : game_panel.getComponents())
                    if (c instanceof JLabel) {
                        JLabel j = ((JLabel) c);
                        if (!j.getText().equals("" + 2048))
                            j.setEnabled(false);
                    }
            }

            @Override
            public void onLoss(GameEvent e) {
                manager.setState(Board.State.FINISHED);
            }

            @Override
            public void onPause(GameEvent e) {
                System.out.println("Paused");
            }

            @Override
            public void onResume(GameEvent e) {
                System.out.println("Resumed");
            }
        });
        for (int row = 0; row < manager.getLength(); row++) {
            for (int col = 0; col < manager.getLength(row); col++) {
                final int finalRow = row;
                final int finalCol = col;
                JLabel label = new JLabel() {
                    @Override
                    public Color getBackground() {
                        switch (manager.get(finalRow, finalCol)) {
                            case 2:
                                return Colors.decode(245, 222, 179);
                            case 4:
                                return Colors.decode(210, 180, 140);
                            case 8:
                                return Colors.decode(238, 221, 130);
                            case 16:
                                return Colors.decode(255, 140, 0);
                            case 32:
                                return Colors.decode(255, 150, 0);
                            case 64:
                                return Colors.decode(255, 160, 0);
                            case 128:
                                return Colors.decode(255, 170, 0);
                            case 256:
                                return Colors.decode(255, 180, 0);
                            case 512:
                                return Colors.decode(255, 190, 0);
                            case 1024:
                                return Colors.decode(255, 200, 0);
                            case 2048:
                                return Colors.decode(255, 210, 0);
                            default:
                                return Color.white;
                        }
                    }

                    @Override
                    public String getText() {
                        return manager.get(finalRow, finalCol) == 0 ? "" : "" + manager.get(finalRow, finalCol);
                    }

                    @Override
                    public Font getFont() {
                        return JLFont.fillContainer(this, super.getFont());
                    }
                };
                label.setHorizontalAlignment(SwingConstants.CENTER);
                label.setBorder(BorderFactory.createLineBorder(Color.black));
                label.setOpaque(true);
                game_panel.add(label);
            }
        }
        setMinimumSize(new Dimension(game.current.length * 20, 100 + game.current.length * 20));
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        JPanel main = new JPanel(new BorderLayout(5, 5));
        main.add(game_panel, BorderLayout.CENTER);
        JLabel title = new JLabel("2048 - Remade for Java.");
        JLabel score = new
                JLabel() {
                    @Override
                    public String getText() {
                        return "Score: " + NumberFormat.getInstance().format(manager.getScore());
                    }
                };
        Font top = new Font(title.getFont().getName(), Font.PLAIN, 20);
        title.setFont(top);
        title.setHorizontalAlignment(SwingConstants.CENTER);
        title.setVerticalAlignment(SwingConstants.CENTER);
        score.setFont(top);
        score.setHorizontalAlignment(SwingConstants.CENTER);
        score.setVerticalAlignment(SwingConstants.CENTER);
        main.add(title, BorderLayout.NORTH);
        main.add(score, BorderLayout.SOUTH);
        setContentPane(main);
        game_panel.setFocusable(true);
    }

    public BoardManager getManager() {
        return manager;
    }

    public void start() {
        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }
}
