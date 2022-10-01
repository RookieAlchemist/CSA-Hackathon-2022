import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.Random;

//Space Invaders Game Panel

public class SpaceSurvivalPanel extends JPanel implements ActionListener, MouseListener, KeyListener {
    private Timer timer;
    private boolean[] keys;
    private Player player;

    private ArrayList<Star> stars = new ArrayList<Star>();

    public SpaceSurvivalPanel() {
        setPreferredSize(new Dimension(800, 600));
        keys = new boolean[2000];
        setFocusable(true);
        requestFocus();
        addMouseListener(this);
        addKeyListener(this);
        timer = new Timer(20, this);
        timer.start();

        //Initializing all objects at start of game
        player = new Player(KeyEvent.VK_A, KeyEvent.VK_D);

        for(int i = 0; i < 100; i++){
          Star star = new Star();
          stars.add(star);
        }
    }

    private void move() {
        player.move(keys);
        controls(keys);
        repeat(keys);
        for(Star star : stars){
          star.move();
        }
    }

    //Initializes everything again in the case that a user decides to replay a certain level
    private void repeat(boolean[] keys){
    }

    //Allows user to view keyboard controls in the intro screen
    private void controls(boolean[] keys){
    }

    //draws all in game elements
    private void drawGame(Graphics g) {
    }

    @Override
    public void paint(Graphics g) {
      g.setColor(Color.BLACK);
      g.fillRect(0, 0, getWidth(), getHeight());
      g.setColor(Color.WHITE);
      player.draw(g);
      for(Star star : stars){
        star.draw(g);
      }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        move();
        repaint();
    }

    @Override
    public void mouseClicked(MouseEvent e) {
    }

    @Override
    public void mouseEntered(MouseEvent e) {
    }

    @Override
    public void mouseExited(MouseEvent e) {
    }

    @Override
    public void mousePressed(MouseEvent e) {
    }

    @Override
    public void mouseReleased(MouseEvent e) {
    }

    @Override
    public void keyPressed(KeyEvent e) {
        int code = e.getKeyCode();
        keys[code] = true;
    }

    @Override
    public void keyReleased(KeyEvent e) {
        int code = e.getKeyCode();
        keys[code] = false;
    }

    @Override
    public void keyTyped(KeyEvent e) {
    }
}
