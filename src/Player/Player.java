package Player;

import java.awt.Color;;

public class Player {
    public int x;
    public int y;
    public Color color;
    public long lastMoveTime = 0;
    public Coordinates dynamicInitPos;
    public boolean isSafe = true;

    public int tilesPainted = 1;

    public Player(int x, int y, Color color) {
        this.x = x;
        this.y = y;
        this.color = color;
    }

    public void sumOneToTilesPainted(){
        this.tilesPainted++;
    }

    public void postMoveActions(Color[][] colorGrid, int colorGridX, int colorGridY){
        setPlayerSafe(this, colorGridX, colorGridY, colorGrid);
        this.sumOneToTilesPainted();
    }

    public Coordinates getCoordinates() {
        return new Coordinates(this.x, this.y);
    }

    private void setIsSafe(boolean safe) {
        if (safe == false) {
            this.dynamicInitPos = new Coordinates(this.x, this.y);
        }
        this.isSafe = safe;
    }

    public boolean getIsSafe() {
        return this.isSafe;
    }

    public void setPlayerSafe(Player player, int colorGridX, int colorGridY, Color[][] colorGrid) {

        Color right;
        Color left;
        Color up;
        Color down;
        Color upLeft;
        Color upRight;
        Color downLeft;
        Color downRight;

        if (player.x + 1 >= colorGridX) {
            right = new Color(0, 0, 0);
        } else {
            right = colorGrid[player.y][player.x + 1];
            if (right == null)
                right = new Color(0, 0, 0);
        }

        if (player.x - 1 < 0) {
            left = new Color(0, 0, 0);
        } else {
            left = colorGrid[player.y][player.x - 1];
            if (left == null)
                left = new Color(0, 0, 0);
        }

        if (player.y - 1 < 0) {
            up = new Color(0, 0, 0);
        } else {
            up = colorGrid[player.y - 1][player.x];
            if (up == null)
                up = new Color(0, 0, 0);
        }

        if (player.y + 1 >= colorGridY) {
            down = new Color(0, 0, 0);
        } else {
            down = colorGrid[player.y + 1][player.x];
            if (down == null)
                down = new Color(0, 0, 0);
        }

        if (player.x - 1 < 0 || player.y - 1 < 0) {
            upLeft = new Color(0, 0, 0);
        } else {
            upLeft = colorGrid[player.y - 1][player.x - 1];
            if (upLeft == null)
                upLeft = new Color(0, 0, 0);
        }

        if (player.x + 1 >= colorGridX || player.y - 1 < 0) {
            upRight = new Color(0, 0, 0);
        } else {
            upRight = colorGrid[player.y - 1][player.x + 1];
            if (upRight == null)
                upRight = new Color(0, 0, 0);
        }

        if (player.x - 1 < 0 || player.y + 1 >= colorGridY) {
            downLeft = new Color(0, 0, 0);
        } else {
            downLeft = colorGrid[player.y + 1][player.x - 1];
            if (downLeft == null)
                downLeft = new Color(0, 0, 0);
        }

        if (player.x + 1 >= colorGridX || player.y + 1 >= colorGridY) {
            downRight = new Color(0, 0, 0);
        } else {
            downRight = colorGrid[player.y + 1][player.x + 1];
            if (downRight == null)
                downRight = new Color(0, 0, 0);
        }

        int sumRed = up.getRed() + down.getRed() + left.getRed() + right.getRed()
                + upLeft.getRed() + upRight.getRed() + downLeft.getRed() + downRight.getRed();

        int sumBlue = up.getBlue() + down.getBlue() + left.getBlue() + right.getBlue()
                + upLeft.getBlue() + upRight.getBlue() + downLeft.getBlue() + downRight.getBlue();

        // 8 tiles = 8 * 255 = 2040
        if (player.color == Color.BLUE && sumBlue >= 2040) {
            this.setIsSafe(true);
        } else if (player.color == Color.BLUE) {
            this.setIsSafe(false);
        }

        if (player.color == Color.RED && sumRed >= 2040) {
            this.setIsSafe(true);
        } else if (player.color == Color.RED) {
            this.setIsSafe(false);
        }
    }
}
