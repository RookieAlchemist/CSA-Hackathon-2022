import javax.swing.*;
import java.awt.*;

public class Player {
    private int x, y, left, right;

    public Player(int l, int r) {
        left = l;
        right = r;
        x = 175;
        y = 250;
    }

    public void move(boolean[] keys) {
        /*if (keys[left] && x > 0) {
            x -= 10;
        }
        if (keys[right] && x < 720) {
            x += 10;
        }*/
    }

    public int getX() {
        return x;
    }
    public int getY() {
        return y;
    }

    public Rectangle getRect() {
        return new Rectangle(x, y, 50, 50);
    }

    public void draw(Graphics g) {
        g.fillRect(x, y, 50, 50);
    }
}

