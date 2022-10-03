//Ahmad Arain and Abdullah Mustafa
// 400 * 400
//Space Survival

import javax.swing.*;

public class SpaceShipStruggles extends JFrame{

    public SpaceShipStruggles() {
        super("Space Ship Struggles"); // this calls the calls the constructor from JFrame
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        add(new SpaceSurvivalPanel());
        pack(); // set the size to whatever is on the JFrame
        setVisible(true);
    }

    public static void main(String[] args) {
        SpaceShipStruggles frame = new SpaceShipStruggles();
    }
}