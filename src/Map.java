import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class Map {
    private int x, y, left, right ,teleport;
    private ArrayList<Star> stars;
    private ArrayList<Wall> walls;
    private ArrayList<Teleporter> teleporters;
    private ArrayList<Document> documents;
    private ArrayList<Trivia> trivias;
    private Ship ship;
    private Player player;
    private int cooldown;
    private Starting start;
    
    public Map(int xcoord, int ycoord, int l, int r, int w, ArrayList<Star> list_of_stars, ArrayList<Wall> list_of_walls, Ship starship, Player P, ArrayList<Teleporter> portals, ArrayList<Document> docs, ArrayList<Trivia> Ts, Starting sT) {
      x = xcoord;
      y = ycoord;
      left = l;
      right = r;
      teleport = w;
      stars = list_of_stars;
      walls = list_of_walls;
      ship = starship;
      player = P;
      teleporters = portals;
      documents = docs;
      trivias = Ts;
      start = sT;
    }

    public void move(boolean[] keys) {
      if (keys[left]) {
        move(5);
      }
      if (keys[right]) {
        move(-5);
      }
      for(Wall wall: walls){
        if (wall.getRect().intersects(player.getRect())){
          if (wall.getX() < player.getX()){
            move(-5);
          } else {
            move(5);
          }
        }
      }
      cooldown++;
      for(Teleporter teleporter : teleporters){
        if (keys[teleport] && player.getRect().intersects(teleporter.getRect1()) && cooldown > 10){
          move(teleporter.getX() - teleporter.getX2());
          moveY(teleporter.getY() - teleporter.getY2());
          cooldown = 0;
        } else if (keys[teleport] && player.getRect().intersects(teleporter.getRect2()) && cooldown > 10){
          move(teleporter.getX2() - teleporter.getX());
          moveY(teleporter.getY2() - teleporter.getY());
          cooldown = 0;
        }
      }
      if (keys[teleport] && cooldown > 10){
        System.out.println("" + x + ", " + y);
        cooldown = 0;
      }
    }

    private void move(int num){
      x += 5;
      for(Wall wall : walls){
        wall.move(num);
      }
      for(Teleporter teleporter : teleporters){
        teleporter.move(num);
      }
      for(Document document : documents){
        document.move(num);
      }
      for(Trivia trivia : trivias){
        trivia.move(num);
      }
      ship.move(num);
      start.move(num);
    }

    private void moveY(int num){
      x += 5;
      for(Wall wall : walls){
        wall.moveY(num);
      }
      for(Teleporter teleporter : teleporters){
        teleporter.moveY(num);
      }
      for(Document document : documents){
        document.moveY(num);
      }
      for(Trivia trivia : trivias){
        trivia.moveY(num);
      }
      ship.moveY(num);
      start.moveY(num);
    }

    public void draw(Graphics g) {
    }
}