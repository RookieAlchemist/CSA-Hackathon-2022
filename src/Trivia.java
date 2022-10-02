import javax.swing.*;
import java.awt.*;

public class Trivia {
    private int x, y, open, close, scrollup, scrolldown;
    private int scrolly = 0;
    private Player player;
    private boolean opendoc = false;

    private Image scrollicon = new ImageIcon("Images/scrollicon.png").getImage().getScaledInstance(40, 50, Image.SCALE_DEFAULT);
    private Image scroll;

    public Trivia(int X, int Y, int e, int q, int w, int s, Image pic, Player character) {
        open = e;
        close = q;
        scrollup = w;
        scrolldown = s;
        x = X;
        y = Y;
        player = character;
        scroll = pic;
    }

    public void move(boolean[] keys) {
        if (keys[open] && player.getRect().intersects(getRect())) {
            opendoc = true;
        }
        if (keys[close]) {
            opendoc = false;
            scrolly = 0;
        }
        if (keys[scrolldown]){
            scrolly -= 2;
        }
        if (keys[scrollup]){
            scrolly += 2;
        }
        if (scrolly > 0){
            scrolly -= 2;
        }
        if (scrolly + scroll.getHeight(null) < 400){
            scrolly += 2;
        }
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
        return new Rectangle(x, y, 50, 50);
    }

    public void drawicon(Graphics g){
        g.drawImage(scrollicon, x, y, null);
    }

    public void draw(Graphics g) {
        if(opendoc){
            g.drawImage(scroll, 0, scrolly, null);
        }
    }
}
