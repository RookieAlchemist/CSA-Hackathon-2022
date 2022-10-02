import javax.swing.*;
import java.awt.*;

public class Starting {
    private int x, y;

    public Starting(int X, int Y) {
        x = X;
        y = Y;
    }

    public int getX() {
        return x;
    }
    public int getY() {
        return y;
    }

    public void move(int num) {
        x += num;
    }
    public void moveY(int num) {
        y += num;
    }

    public Rectangle getRect() {
        return new Rectangle(x, y, 150, 100);
    }

    public void draw(Graphics g) {
        g.drawRect(x, y, 150, 100);
    }
}

