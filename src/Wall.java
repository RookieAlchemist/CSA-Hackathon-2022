import javax.swing.*;
import java.awt.*;

public class Wall {
    private int x, y, left, right;

    public Wall(int xcoord, int ycoord) {
        x = xcoord;
        y = ycoord;
    }

    public void move(int num) {
        x += num;
    }
    public void moveY(int num) {
        y += num;
    }

    public int getX() {
        return x;
    }
    public int getY() {
        return y;
    }

    public Rectangle getRect() {
        return new Rectangle(x, y, 20, 100);
    }

    public void draw(Graphics g) {
        g.fillRect(x, y, 20, 100);
    }
}

