import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class Map {
    private int x, y, left, right;
    private ArrayList<Star> stars;
    private ArrayList<Wall> walls;
    private Ship ship;

    //private Image spriteship = new ImageIcon("stargazerbckgrnd.png").getImage();
    
  
    public Map(int xcoord, int ycoord, int l, int r, ArrayList<Star> list_of_stars, ArrayList<Wall> list_of_walls, Ship shipy) {
      x = xcoord;
      y = ycoord;
      left = l;
      right = r;
      stars = list_of_stars;
      walls = list_of_walls;
      ship = shipy;
    }

    public void move(boolean[] keys) {
      if (keys[left]) {
        for(Star star : stars){
          star.move(5);
        }
        x += 5;
        for(Wall wall : walls){
          wall.move(5);
        }
        ship.move(5);
      }
      if (keys[right]) {
        for(Star star : stars){
          star.move(-5);
        }
        x -= 5;
        for(Wall wall : walls){
          wall.move(-5);
        }
        ship.move(-5);
      }
    }

    /*public Rectangle getRect() {
    }*/

    public void draw(Graphics g) {
    }
}