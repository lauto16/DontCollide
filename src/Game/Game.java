package Game;

import Player.Player;
import java.awt.*;

public class Game {

    Color[][] grid;

    public Player player1;
    public Player player2;

    private int gridX;
    private int gridY;

    private final int player1InitialPosX = 50;
    private final int player1InitialPosY = 50;
    private final int player2InitialPosX = 0;
    private final int player2InitialPosY = 0;
    public final int cellSize = 10;
    private final int MOVE_DELAY_MS = 20;

    public Game(int gridX, int gridY) {
        this.gridX = gridX;
        this.gridY = gridY;

        this.player1 = new Player(player1InitialPosX, player1InitialPosY, Color.RED);
        this.player2 = new Player(player2InitialPosX, player2InitialPosY, Color.BLUE);
        grid = new Color[gridX][gridY];
    }

    public void moveUp(Player player) {
        int y = player.y - 1;
        int x = player.x;

        if (!canMove(player))
            return;
        if (!isPosibleToMoveThere(x, y))
            return;

        player.y--;
    }

    public void moveDown(Player player) {
        int y = player.y + 1;
        int x = player.x;

        if (!canMove(player))
            return;
        if (!isPosibleToMoveThere(x, y))
            return;

        player.y++;
    }

    public void moveLeft(Player player) {
        int y = player.y;
        int x = player.x - 1;

        if (!canMove(player))
            return;
        if (!isPosibleToMoveThere(x, y))
            return;

        player.x--;
    }

    public void moveRight(Player player) {
        int y = player.y;
        int x = player.x + 1;

        if (!canMove(player))
            return;
        if (!isPosibleToMoveThere(x, y))
            return;

        player.x++;
    }

    private boolean canMove(Player player) {
        long now = System.currentTimeMillis();

        if (now - player.lastMoveTime < MOVE_DELAY_MS) {
            return false;
        }

        player.lastMoveTime = now;
        return true;
    }

    private boolean isPosibleToMoveThere(int x, int y) {

        if (x > gridX - 1 || x < 0) {
            return false;
        }

        if (y > gridY - 1 || y < 0) {
            return false;
        }

        return true;
    }

    public void drawPlayer(int x, int y, Graphics g, Player player) {
        if (!isPosibleToMoveThere(x, y)) {
            return;
        }

        g.setColor(grid[y][x] == null ? player.color : grid[y][x]);
        g.fillRect(x * cellSize, y * cellSize, cellSize, cellSize);

    }

}