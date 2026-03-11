package Game;

import Player.Player;
import java.awt.*;

public class Game {

    public Color[][] colorGrid;
    public byte[][] gameGrid;

    public Player player1;
    public Player player2;

    private int colorGridX;
    private int colorGridY;

    private final int player1InitialPosX;
    private final int player1InitialPosY;
    private final int player2InitialPosX;
    private final int player2InitialPosY;

    public final int cellSize = 10;
    private final int MOVE_DELAY_MS = 20;

    public Game(int colorGridX, int colorGridY) {
        this.colorGridX = colorGridX;
        this.colorGridY = colorGridY;

        player1InitialPosX = colorGridX - 1;
        player1InitialPosY = colorGridY - 1;
        player2InitialPosX = 0;
        player2InitialPosY = 0;

        this.player1 = new Player(player1InitialPosX, player1InitialPosY, Color.RED);
        this.player2 = new Player(player2InitialPosX, player2InitialPosY, Color.BLUE);

        colorGrid = new Color[colorGridX][colorGridY];

        System.out.println("p1: " + player1.getCoordinates().x + ";" + player1.getCoordinates().y);
        System.out.println("p2: " + player2.getCoordinates().x + ";" + player2.getCoordinates().y);
    }

    private void colorTile(int x, int y, Player player){
        colorGrid[y][x] = player.color;
    }

    public void moveUp(Player player) {
        int y = player.y - 1;
        int x = player.x;

        if (!canMove(player))
            return;
        if (!isPosibleToMoveThere(x, y))
            return;

        player.y--;
        colorTile(x,y,player);
    }

    public void moveDown(Player player) {
        int y = player.y + 1;
        int x = player.x;

        if (!canMove(player))
            return;
        if (!isPosibleToMoveThere(x, y))
            return;

        player.y++;
        colorTile(x,y,player);
    }

    public void moveLeft(Player player) {
        int y = player.y;
        int x = player.x - 1;

        if (!canMove(player))
            return;
        if (!isPosibleToMoveThere(x, y))
            return;

        player.x--;
        colorTile(x,y,player);
    }

    public void moveRight(Player player) {
        int y = player.y;
        int x = player.x + 1;

        if (!canMove(player))
            return;
        if (!isPosibleToMoveThere(x, y))
            return;

        player.x++;
        colorTile(x,y,player);
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

        if (x > colorGridX - 1 || x < 0) {
            return false;
        }

        if (y > colorGridY - 1 || y < 0) {
            return false;
        }

        return true;
    }

    public void drawPlayer(int x, int y, Graphics g, Player player) {
        if (!isPosibleToMoveThere(x, y)) {
            return;
        }

        g.setColor(colorGrid[y][x] == null ? player.color : colorGrid[y][x]);
        g.fillRect(x * cellSize, y * cellSize, cellSize, cellSize);

    }

}