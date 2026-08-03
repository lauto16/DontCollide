import Game.Game;
import WindowGenerator.GenerateFrameControl;

public class App {
    public static void main(String[] args) throws Exception {
        int gridX = 51;
        int gridY = 51;
        Game game = new Game(gridX, gridY);

        GenerateFrameControl window = new GenerateFrameControl(550, 530, "App", gridX, gridY, game);

        window.generateWindow();
    }
}

/*The player has to have at least 5 tiles around him tinted his color to be safe, if he is not safe, then the other player
can kill him by colliding with any part of the grid with the color red, at the same time, the more tiles you have, the slower you move
and the more points you have.*/
