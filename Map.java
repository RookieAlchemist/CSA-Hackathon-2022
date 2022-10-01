import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class Map {
    private int x, y, left, right;
    private ArrayList<Star> stars;
    private ArrayList<Wall> walls;

    private Image spriteship = new ImageIcon("starship.png").getImage().getScaledInstance(2510, 1180, Image.SCALE_DEFAULT);
  
    public Map(int xcoord, int ycoord, int l, int r, ArrayList<Star> list_of_stars, ArrayList<Wall> list_of_walls) {
      x = xcoord;
      y = ycoord;
      left = l;
      right = r;
      stars = list_of_stars;
      walls = list_of_walls;
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
      }
      if (keys[right]) {
        for(Star star : stars){
          star.move(-5);
        }
        x -= 5;
        for(Wall wall : walls){
          wall.move(-5);
        }
      }
    }

    /*public Rectangle getRect() {
    }*/

    public void draw(Graphics g) {
      //g.drawImage(spriteship, x, y, null);
    }
}