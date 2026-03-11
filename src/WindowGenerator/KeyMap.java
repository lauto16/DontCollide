package WindowGenerator;

import javax.swing.*;
import java.awt.event.ActionEvent;
import Game.Game;

public class KeyMap {
    public static void map(InputMap im, ActionMap am, KeysPressed kp, Game game, Runnable repaint) {
        // PLAYER 1 PRESS
        im.put(KeyStroke.getKeyStroke("pressed UP"), "p1UpPress");
        im.put(KeyStroke.getKeyStroke("pressed DOWN"), "p1DownPress");
        im.put(KeyStroke.getKeyStroke("pressed LEFT"), "p1LeftPress");
        im.put(KeyStroke.getKeyStroke("pressed RIGHT"), "p1RightPress");

        // PLAYER 1 RELEASE
        im.put(KeyStroke.getKeyStroke("released UP"), "p1UpRelease");
        im.put(KeyStroke.getKeyStroke("released DOWN"), "p1DownRelease");
        im.put(KeyStroke.getKeyStroke("released LEFT"), "p1LeftRelease");
        im.put(KeyStroke.getKeyStroke("released RIGHT"), "p1RightRelease");

        // PLAYER 2 PRESS
        im.put(KeyStroke.getKeyStroke("pressed W"), "p2UpPress");
        im.put(KeyStroke.getKeyStroke("pressed S"), "p2DownPress");
        im.put(KeyStroke.getKeyStroke("pressed A"), "p2LeftPress");
        im.put(KeyStroke.getKeyStroke("pressed D"), "p2RightPress");

        // PLAYER 2 RELEASE
        im.put(KeyStroke.getKeyStroke("released W"), "p2UpRelease");
        im.put(KeyStroke.getKeyStroke("released S"), "p2DownRelease");
        im.put(KeyStroke.getKeyStroke("released A"), "p2LeftRelease");
        im.put(KeyStroke.getKeyStroke("released D"), "p2RightRelease");

        // ACTIONS PLAYER 1
        am.put("p1UpPress", new AbstractAction() {
            public void actionPerformed(ActionEvent e) {
                if (!kp.p1UpPressed) {
                    game.moveUp(game.player1);
                    repaint.run();
                }
                kp.p1UpPressed = true;
            }
        });

        am.put("p1DownPress", new AbstractAction() {
            public void actionPerformed(ActionEvent e) {
                if (!kp.p1DownPressed) {
                    game.moveDown(game.player1);
                    repaint.run();
                }
                kp.p1DownPressed = true;
            }
        });

        am.put("p1LeftPress", new AbstractAction() {
            public void actionPerformed(ActionEvent e) {
                if (!kp.p1LeftPressed) {
                    game.moveLeft(game.player1);
                    repaint.run();
                }
                kp.p1LeftPressed = true;
            }
        });

        am.put("p1RightPress", new AbstractAction() {
            public void actionPerformed(ActionEvent e) {
                if (!kp.p1RightPressed) {
                    game.moveRight(game.player1);
                    repaint.run();
                }

                kp.p1RightPressed = true;
            }
        });

        am.put("p1UpRelease", new AbstractAction() {
            public void actionPerformed(ActionEvent e) {
                kp.p1UpPressed = false;
            }
        });

        am.put("p1DownRelease", new AbstractAction() {
            public void actionPerformed(ActionEvent e) {
                kp.p1DownPressed = false;
            }
        });

        am.put("p1LeftRelease", new AbstractAction() {
            public void actionPerformed(ActionEvent e) {
                kp.p1LeftPressed = false;
            }
        });

        am.put("p1RightRelease", new AbstractAction() {
            public void actionPerformed(ActionEvent e) {
                kp.p1RightPressed = false;
            }
        });

        // ACTIONS PLAYER 2
        am.put("p2UpPress", new AbstractAction() {
            public void actionPerformed(ActionEvent e) {
                if (!kp.p2UpPressed) {
                    game.moveUp(game.player2);
                    repaint.run();
                }
                kp.p2UpPressed = true;
            }
        });

        am.put("p2DownPress", new AbstractAction() {
            public void actionPerformed(ActionEvent e) {
                if (!kp.p2DownPressed) {
                    game.moveDown(game.player2);
                    repaint.run();
                }
                kp.p2DownPressed = true;
            }
        });

        am.put("p2LeftPress", new AbstractAction() {
            public void actionPerformed(ActionEvent e) {
                if (!kp.p2LeftPressed) {
                    game.moveLeft(game.player2);
                    repaint.run();
                }
                kp.p2LeftPressed = true;
            }
        });

        am.put("p2RightPress", new AbstractAction() {
            public void actionPerformed(ActionEvent e) {
                if (!kp.p2RightPressed) {
                    game.moveRight(game.player2);
                    repaint.run();
                }

                kp.p2RightPressed = true;
            }
        });

        am.put("p2UpRelease", new AbstractAction() {
            public void actionPerformed(ActionEvent e) {
                kp.p2UpPressed = false;
            }
        });
        
        am.put("p2DownRelease", new AbstractAction() {
            public void actionPerformed(ActionEvent e) {
                kp.p2DownPressed = false;
            }
        });
        
        am.put("p2LeftRelease", new AbstractAction() {
            public void actionPerformed(ActionEvent e) {
                kp.p2LeftPressed = false;
            }
        });
        
        am.put("p2RightRelease", new AbstractAction() {
            public void actionPerformed(ActionEvent e) {
                kp.p2RightPressed = false;
            }
        });
    }
}
