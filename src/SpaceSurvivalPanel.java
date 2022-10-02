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
    private Map map;
    private Ship ship;

    private ArrayList<Star> stars = new ArrayList<Star>();
    private ArrayList<Wall> walls = new ArrayList<Wall>();
    private ArrayList<Teleporter> teleporters = new ArrayList<Teleporter>();
//2510, 1100
    private Image spriteship = new ImageIcon("stargazerbckgrnd.png").getImage().getScaledInstance(2510, 1100, Image.SCALE_DEFAULT);
    private Image teleprterpic = new ImageIcon("teleport.png").getImage().getScaledInstance(80, 120, Image.SCALE_DEFAULT);

    public SpaceSurvivalPanel() {
        setPreferredSize(new Dimension(400, 400));
        keys = new boolean[2000];
        setFocusable(true);
        requestFocus();
        addMouseListener(this);
        addKeyListener(this);
        timer = new Timer(20, this);
        timer.start();

        //Initializing all objects at start of game
        player = new Player(KeyEvent.VK_A, KeyEvent.VK_D);
        for(int i = 0; i < 50; i++){
          Star star = new Star();
          stars.add(star);
        }

        walls.add(new Wall(599 - 2200, 633 - 800));
        walls.add(new Wall(1933 - 2200, 633 - 800));
        walls.add(new Wall(633 - 2200, 807 - 800));
        walls.add(new Wall(1900 - 2200, 807 - 800));
        walls.add(new Wall(218 - 2200, 998 - 800));
        walls.add(new Wall(2476 - 2200, 998 - 800));
        walls.add(new Wall(536 - 2200, 1192 - 800));
        walls.add(new Wall(1998 - 2200, 1192 - 800));
        walls.add(new Wall(1032 - 2200, 457 - 800));
        walls.add(new Wall(1497 - 2200, 457 - 800));

        teleporters.add(new Teleporter(2276 - 2250 - 1955, 998 - 800 + 73, 733 - 2200 - 80, 807 - 800 + 73));
        teleporters.add(new Teleporter(2276 - 2250 - 1955 + 1380 + 150, 807 - 800 + 73, 2276 - 2250 - 1955 + 1380 + 160, 633 - 800 + 73));
        teleporters.add(new Teleporter(2276 - 2250 - 1955 + 1380 - 420, 633 - 800 + 73, 2276 - 2250 - 1955 + 1380 - 800 + 200, 357 - 700 + 73));
        teleporters.add(new Teleporter(2276 - 2250 - 1955 + 1380 - 245, 357 - 700 + 73, 733 - 2200, 1192 - 730));

        ship = new Ship(-2200, -600);
      
        map = new Map(0, 0, KeyEvent.VK_A, KeyEvent.VK_D, KeyEvent.VK_W, stars, walls, ship, player, teleporters);
    }

    private void move() {
      
        player.move(keys);
        
        for(Star star : stars){
          star.move();
        }
      
        map.move(keys);

        controls(keys);
        repeat(keys);

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


      
      
      for(Star star : stars){
        star.draw(g);
      }
      ship.draw(g);
      for(Teleporter teleporter : teleporters){
        teleporter.draw(g);
      }
      
      player.draw(g);
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
