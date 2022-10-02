import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class Trivia {
    private int x, y, A, B, C, D, open;
    private Player player;
    private boolean opendoc = false;
    private ArrayList<Question> questions = new ArrayList<Question>();
    private Question currentQuestion;
    private int questionnum = 0;
    private int cooldown = 0;
    private boolean complete = false;

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
        currentQuestion = questions.get(questionnum);
        if (keys[open] && player.getRect().intersects(getRect())) {
            opendoc = true;
        }
        if (opendoc){
            if(keys[currentQuestion.getAns()] && cooldown > 20){
                cooldown = 0;
                if(questions.size() > questionnum)
                    questionnum++;
            } 
        }
        if(questionnum + 1 == questions.size()){
            opendoc = false;
            complete = true;
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

    public boolean complete(){
        return complete;
    }

    public Rectangle getRect() {
        return new Rectangle(x, y, 80, 40);
    }

    public void draw(Graphics g) {
        if(opendoc){
            g.drawImage(currentQuestion.getImage(), 0, 0, null);
        }
    }
}
