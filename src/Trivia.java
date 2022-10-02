import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class Trivia {
    private int x, y, A, B, C, D, open;
    private Player player;
    private boolean opendoc = false;
    private ArrayList<Question> questions = new ArrayList<Question>();
    private Image currentpic;
    private int cooldown = 0;

    public Trivia(int X, int Y, int h, int j, int k, int l, int e, Player character, ArrayList<Question> Qs) {
        A = h;
        B = j;
        C = k;
        D = l;
        x = X;
        y = Y;
        open = e;
        player = character;
        questions = Qs;
    }

    public void move(boolean[] keys) {
        cooldown++;
        if (keys[open] && player.getRect().intersects(getRect())) {
            opendoc = true;
        }
        if (opendoc){
            for(Question question : questions){
                while(!keys[question.getAns()]){
                    currentpic = question.getImage();
                }
            }
            currentpic = null;
            opendoc = false;
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
        return new Rectangle(x, y, 80, 40);
    }

    public void draw(Graphics g) {
        if(opendoc){
            g.fillRect(x, y, 80, 40);
        }
        if(currentpic != null){
            g.drawImage(currentpic, 0, 0, null);
        }
    }
}
