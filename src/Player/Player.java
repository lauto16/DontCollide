package Player;
import java.awt.Color;;

public class Player {
    public int x;
    public int y;
    public Color color;
    public long lastMoveTime = 0;

    public Player(int x, int y, Color color){
        this.x = x;
        this.y = y;
        this.color = color;
    }

    public Coordinates getCoordinates(){
        return new Coordinates(this.x, this.y);
    }

}
