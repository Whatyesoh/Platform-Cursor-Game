import javax.swing.*;
import java.awt.*;

public class Painter extends JComponent {
    public int x = 500;
    public int y = 100;
    private double velocity;
    int floor1 = 600;
    int floor = 600;
    double gravity = 1;
    public void paintComponent(Graphics g) {
        Point a = MouseInfo.getPointerInfo().getLocation();
        super.paintComponent(g);
        g.setColor(new Color(75,107,40));
        g.fillRect(0,floor1+10,10000,10);
        g.setColor(new Color(75,56,40)) ;
        g.fillRect(0,floor1+20,10000,300);
        g.setColor(new Color(75,56,239));
        g.fillRect(x,y,10,10);
        g.setColor(Color.black);
        g.drawRect((int)a.getX()-10,(int)a.getY()-23,40,20);
    }
    public void gravity() {
        Point a = MouseInfo.getPointerInfo().getLocation();
        if (a.getX()-x<20&&x<a.getX()+30) {
            if(a.getY()>y+20) {
                floor = (int)a.getY()-33;
            }
            else {
                floor = floor1;
                if (y <= a.getY()) {
                    velocity = 0-gravity;
                    y = (int) a.getY();
                }
            }
        }
        else {
            floor = floor1;
        }
        if (floor > floor1) {
            floor = floor1;
        }
        if (y < floor || velocity > 1) {
            y-=velocity;
            velocity-=gravity;
        }
        if (y > floor && velocity < 0) {
            y = floor;
            velocity = 0;
        }
    }
    public void left() {
        x-=10;
    }
    public void right() {
        x+=10;
    }
    public void jump() {
        if (y == floor) {
            velocity += 20;
        }
    }
    public void draw() {
        repaint();
    }
}
