import javax.swing.*;
import java.awt.*;

public class Player {
    private int x, y, left, right;

    private Image astroR = new ImageIcon("Images/astronautL.png").getImage().getScaledInstance(30, 60, Image.SCALE_DEFAULT);
    private Image astroL = new ImageIcon("Images/astronautR.png").getImage().getScaledInstance(30, 60, Image.SCALE_DEFAULT);

    private Image currentSprite = astroL;

    public Player(int l, int r) {
        left = l;
        right = r;
        x = 175;
        y = 250;
    }

    public void move(boolean[] keys) {
        if (keys[right]) {
            currentSprite = astroL;
        }
        else if (keys[left]) {
            currentSprite = astroR;
        }
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
        g.drawImage(currentSprite, x + 10, y - 10, null);
    }
}

