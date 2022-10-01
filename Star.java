import java.awt.*;
import java.util.Random;

public class Star{
    private int x, y;

    public Star(){
        Random rand = new Random();
        x = rand.nextInt(800);
        y = rand.nextInt(600);
    }

    public void move(){
        x -= 15;
        if(x < 0){
            x = 805;
        }
    }

    public void draw(Graphics g){
        g.setColor(Color.white);
        g.fillOval(x, y, 5, 5);
    }
}