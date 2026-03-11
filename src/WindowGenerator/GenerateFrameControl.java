package WindowGenerator;

import javax.swing.*;
import java.awt.*;
import Game.Game;
import KeyMapping.*;

public class GenerateFrameControl {

    public final int gridX;
    public final int gridY;
    private Game game;

    private final int height;
    private final int width;
    private final String title;
    public final JFrame frame;
    private int rows = 1;
    private int cols = 1;
    private int hgap = 5;
    private int vgap = 5;

    public InputMap im;
    public ActionMap am;

    Color[][] grid;


    public GenerateFrameControl(int height, int width, String title, int gridX, int gridY, Game game) {
        this.height = height;
        this.width = width;
        this.title = title;

        this.gridX = gridX;
        this.gridY = gridY;

        grid = new Color[gridX][gridY];

        this.frame = new JFrame(this.title);
        this.game = game;
    }

    public void drawGrid(Graphics g) {

        for (int row = 0; row < 51; row++) {
            for (int col = 0; col < 51; col++) {

                g.setColor(game.colorGrid[row][col] == null ? Color.WHITE : game.colorGrid[row][col]);
                g.fillRect(col * game.cellSize, row * game.cellSize, game.cellSize, game.cellSize);

                g.setColor(Color.LIGHT_GRAY);
                g.drawRect(col * game.cellSize, row * game.cellSize, game.cellSize, game.cellSize);
            }
        }

    }

    private JPanel gridPanel = new JPanel() {
        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            drawGrid(g);
            game.drawPlayer(game.player1.x, game.player1.y, g, game.player1);
            game.drawPlayer(game.player2.x, game.player2.y, g, game.player2);
        }

    };

    public void generateWindow() {
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new GridLayout(this.rows, this.cols, this.hgap, this.vgap));

        frame.pack();
        frame.setResizable(false);
        frame.setSize(this.width, this.height);

        frame.add(gridPanel);

        gridPanel.setFocusable(true);

        im = gridPanel.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW);
        am = gridPanel.getActionMap();

        KeysPressed kp = new KeysPressed();
        KeyMap.map(im, am, kp, game, () -> gridPanel.repaint());

        frame.setVisible(true);
    }

}