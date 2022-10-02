import javax.swing.*;
import java.awt.*;

public class Teleporter {
    private int x, y, x2, y2;

    private Image teleprterpic = new ImageIcon("teleport.png").getImage().getScaledInstance(120, 70, Image.SCALE_DEFAULT);

    public Teleporter(int xcoord, int ycoord, int xcoord2, int ycoord2) {
        x = xcoord;
        y = ycoord;
        x2 = xcoord2;
        y2 = ycoord2;
    }

    public void move(int num) {
        x += num;
        x2 += num;
    }

    public void moveY(int num) {
        y += num;
        y2 += num;
    }

    public int getX() {
        return x;
    }
    public int getY() {
        return y;
    }
    public int getX2() {
        return x2;
    }
    public int getY2() {
        return y2;
    }

    public Rectangle getRect1() {
        return new Rectangle(x, y, 80, 30);
    }

    public Rectangle getRect2() {
        return new Rectangle(x2, y2, 80, 30);
    }

    public void draw(Graphics g) {
        g.drawImage(teleprterpic, x-10, y-35, null);
        g.drawImage(teleprterpic, x2-20, y2-35, null);
    }
}
