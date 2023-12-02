import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

public class Game extends JFrame implements KeyListener {
    public static ArrayList<Integer>keys = new ArrayList<>();
    public static Game frame = new Game();
    private Painter painter;
    public Game() {
        this.painter = new Painter();
        addKeyListener(this);
        setFocusable(true);
        setFocusTraversalKeysEnabled(false);
    }
    public static void main (String [] args) throws InterruptedException {
        frame.setTitle("VIDEO GAME");
        frame.setExtendedState(MAXIMIZED_BOTH);
        frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
        frame.getContentPane().add(frame.painter);
        frame.setVisible(true);
        BufferedImage cursorImg = new BufferedImage(16, 16, BufferedImage.TYPE_INT_ARGB);
        Cursor blankCursor = Toolkit.getDefaultToolkit().createCustomCursor(cursorImg, new Point(0, 0), "blank cursor");
        frame.getContentPane().setCursor(blankCursor);
        while(true) {
            for(int i = 0; i < keys.size(); i++) {
                try{
                    if(keys.get(i)==37) {
                        frame.painter.left();
                        frame.painter.draw();
                    }
                    if(keys.get(i)==38) {
                        frame.painter.jump();
                        frame.painter.draw();
                    }
                    if(keys.get(i)==39) {
                        frame.painter.right();
                        frame.painter.draw();
                    }
                }
                catch (Exception IndexOutOfBoundsException) {
                    System.out.println("It worked");
                }
            }
            frame.painter.gravity();
            frame.painter.draw();
            Thread.sleep(10);
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (!keys.contains(e.getKeyCode())) {
            keys.add(e.getKeyCode());
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        keys.remove((Integer) e.getKeyCode());
    }
}
