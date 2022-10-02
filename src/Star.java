import java.awt.*;
import java.util.Random;

public class Star{
    private int x, y;

    public Star(){
        Random rand = new Random();
        x = rand.nextInt(400);
        y = rand.nextInt(400);
    }

    public void move(){
        x -= 10;
        if(x < 0){
            x = 405;
        }
    }

    public void move(int num){
        x += num;
    }
    public void moveY(int num){
        y += num;
    }

    public void draw(Graphics g){
        g.setColor(Color.white);
        g.fillOval(x, y, 5, 5);
    }
}