import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class Ship {
    private int x, y, left, right;

    private Image spriteship = new ImageIcon("stargazerbckgrnd.png").getImage();
  
    public Ship(int xcoord, int ycoord) {
      x = xcoord;
      y = ycoord;
    }

    public void move(int num) {
      x += num;
    }

    public void moveY(int num) {
      y += num;
    }

   /* public Rectangle getRect() {
    }*/

    public void draw(Graphics g) {
      g.drawImage(spriteship, x, y, null);
    }
}