//Ahmad Arain and Abdullah 
// 400 * 400
//Space Survival

import javax.swing.*;

public class Main extends JFrame{

    public Main() {
        super("Basic Frame"); // this calls the calls the constructor from JFrame
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        add(new SpaceSurvivalPanel());
        pack(); // set the size to whatever is on the JFrame
        setVisible(true);
    }

    public static void main(String[] args) {
        Main frame = new Main();
    }
}