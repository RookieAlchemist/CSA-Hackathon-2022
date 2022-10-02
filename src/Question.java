import javax.swing.*;
import java.awt.*;

public class Question {
    private Image picture; 
    private int answer;

    public Question(Image pic, int ans){
        picture = pic;
        answer = ans;
    }

    public Image getImage(){
        return picture;
    }

    public int getAns(){
        return answer;
    }
}
