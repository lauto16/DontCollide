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
