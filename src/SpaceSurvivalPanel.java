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
    private boolean missionscomplete = false;
    private boolean gameover = false;
    private Starting start;

    private ArrayList<Star> stars = new ArrayList<Star>();
    private ArrayList<Wall> walls = new ArrayList<Wall>();
    private ArrayList<Teleporter> teleporters = new ArrayList<Teleporter>();
    private ArrayList<Document> documents = new ArrayList<Document>();
    private ArrayList<Trivia> trivias = new ArrayList<Trivia>();
//2510, 1100
    private Image spriteship = new ImageIcon("Images/stargazerbckgrnd.png").getImage().getScaledInstance(2510, 1100, Image.SCALE_DEFAULT);
    private Image teleprterpic = new ImageIcon("teleport.png").getImage().getScaledInstance(80, 120, Image.SCALE_DEFAULT);
    private Image scrollicon = new ImageIcon("Images/scrollicon.png").getImage().getScaledInstance(40, 50, Image.SCALE_DEFAULT);
    private Image scroll1 = new ImageIcon("Images/scroll1.png").getImage();
    private Image scroll2 = new ImageIcon("Images/scroll2.png").getImage();
    private Image scroll3 = new ImageIcon("Images/scroll3.png").getImage();
    private Image end = new ImageIcon("Images/victoryscreen.png").getImage();
    private Image Q1 = new ImageIcon("Images/questions/q1.png").getImage();
    private Image Q2 = new ImageIcon("Images/questions/q2.png").getImage();
    private Image Q3 = new ImageIcon("Images/questions/q3.png").getImage();
    private Image Q4 = new ImageIcon("Images/questions/q4.png").getImage();
    private Image Q5 = new ImageIcon("Images/questions/q5.png").getImage();
    private Image Q6 = new ImageIcon("Images/questions/q6.png").getImage();
    private Image Q7 = new ImageIcon("Images/questions/q7.png").getImage();
    private Image Q8 = new ImageIcon("Images/questions/q8.png").getImage();
    private Image astroR = new ImageIcon("Images/astronautL.png").getImage().getScaledInstance(40, 50, Image.SCALE_DEFAULT);
    private Image astrol = new ImageIcon("Images/astronautR.png").getImage().getScaledInstance(40, 50, Image.SCALE_DEFAULT);

    private ArrayList<Question> set1 = new ArrayList<Question>();
    private ArrayList<Question> set2 = new ArrayList<Question>();
    private ArrayList<Question> set3 = new ArrayList<Question>();

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

        documents.add(new Document(1312 - 2260, 635 - 610, KeyEvent.VK_E, KeyEvent.VK_Q, KeyEvent.VK_W, KeyEvent.VK_S, scroll1, player));
        documents.add(new Document(641 - 2260 + 50, 506 - 610 - 20, KeyEvent.VK_E, KeyEvent.VK_Q, KeyEvent.VK_W, KeyEvent.VK_S, scroll2, player));
        documents.add(new Document(1971 - 2260, 1070 - 635, KeyEvent.VK_E, KeyEvent.VK_Q, KeyEvent.VK_W, KeyEvent.VK_S, scroll3, player));

        set1.add(new Question(Q1, KeyEvent.VK_H));
        set1.add(new Question(Q2, KeyEvent.VK_L));
        set1.add(new Question(Q2, KeyEvent.VK_L));

        set2.add(new Question(Q3, KeyEvent.VK_J));
        set2.add(new Question(Q4, KeyEvent.VK_K));
        set2.add(new Question(Q5, KeyEvent.VK_H));
        set2.add(new Question(Q5, KeyEvent.VK_H));

        set3.add(new Question(Q6, KeyEvent.VK_H));
        set3.add(new Question(Q7, KeyEvent.VK_L));
        set3.add(new Question(Q8, KeyEvent.VK_K));
        set3.add(new Question(Q8, KeyEvent.VK_K));

        trivias.add(new Trivia(1645 - 2220, 1013 - 580, KeyEvent.VK_H, KeyEvent.VK_J, KeyEvent.VK_K, KeyEvent.VK_L, KeyEvent.VK_E, player, set1));
        trivias.add(new Trivia(1483 - 2220, 472 - 600, KeyEvent.VK_H, KeyEvent.VK_J, KeyEvent.VK_K, KeyEvent.VK_L, KeyEvent.VK_E, player, set2));
        trivias.add(new Trivia(1642 - 2200, 648 - 600, KeyEvent.VK_H, KeyEvent.VK_J, KeyEvent.VK_K, KeyEvent.VK_L, KeyEvent.VK_E, player, set3));

        ship = new Ship(-2200, -600);

        start = new Starting(2476 - 2200 - 150, 998 - 800);
      
        map = new Map(0, 0, KeyEvent.VK_A, KeyEvent.VK_D, KeyEvent.VK_W, stars, walls, ship, player, teleporters, documents, trivias, start);
    }

    private void move() {
      
        player.move(keys);
        
        for(Star star : stars){
          star.move();
        }
        for(Document document: documents){
          document.move(keys);
        }
        for(Trivia trivia: trivias){
          trivia.move(keys);
        }
        if(trivias.get(0).complete() && trivias.get(1).complete() && trivias.get(2).complete()){
          missionscomplete = true;
        }

        if(player.getRect().intersects(start.getRect()) && missionscomplete && keys[KeyEvent.VK_E]){
          gameover = true;
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

    @Override
    public void paint(Graphics g) {
      g.setColor(Color.BLACK);
      g.fillRect(0, 0, getWidth(), getHeight());
      g.setColor(Color.WHITE);

      for(Star star : stars){
        star.draw(g);
      }
      ship.draw(g);
      for(Document document: documents){
        document.drawicon(g);
      }
      player.draw(g);
      for(Teleporter teleporter : teleporters){
        teleporter.draw(g);
      }
      for(Document document: documents){
        document.draw(g);
      }
      for(Trivia trivia: trivias){
        trivia.draw(g);
      }
      if(missionscomplete){
        g.setFont(new Font("Agency FB", Font.BOLD, 20));
        g.drawString("Missions Complete: Navigate to the start and press E.", 30, 370);
      } 
      if(gameover){
        g.drawImage(end, 0, 0, null);
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
