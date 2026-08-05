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

    public InputMap im;
    public ActionMap am;

    private JLabel player1Points;
    private JLabel player2Points;

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

    public void updatePoints() {
        player1Points.setText("" + game.player1.tilesPainted);
        player2Points.setText("" + game.player2.tilesPainted);
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
        frame.setLayout(new BorderLayout());

        JPanel scorePanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 60, 10));

        player1Points = new JLabel();
        player1Points.setForeground(game.player1.color);
        player1Points.setFont(new Font("Arial", Font.BOLD, 18));

        player2Points = new JLabel();
        player2Points.setForeground(game.player2.color);
        player2Points.setFont(new Font("Arial", Font.BOLD, 18));

        scorePanel.add(player1Points);
        scorePanel.add(player2Points);

        updatePoints();

        frame.add(scorePanel, BorderLayout.NORTH);
        frame.add(gridPanel, BorderLayout.CENTER);

        frame.setSize(width, height);
        frame.setResizable(false);

        gridPanel.setFocusable(true);

        im = gridPanel.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW);
        am = gridPanel.getActionMap();

        KeysPressed kp = new KeysPressed();
        KeyMap.map(im, am, kp, game, () -> {
            updatePoints();
            gridPanel.repaint();
        });

        frame.setVisible(true);
    }
}