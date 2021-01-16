import java.awt.*;
import java.awt.event.KeyEvent;

/**
 * @author huaikong
 * @create 2021-01-14 10:45
 */
public class Tank {
    private int x, y;
    public static final int SPEED = 5;
    private Dir dir;
    private boolean bL, bU, bR, bD;

    public Tank(int x,int y,Dir dir){
        this.x = x;
        this.y = y;
        this.dir = dir;
    }

    public void paint(Graphics g) {
        g.fillRect(x,y,50,50);
        move();
    }

    public void keyPressed(KeyEvent e) {
        int key = e.getKeyCode();
        switch (key){
            case KeyEvent.VK_LEFT:
                dir = Dir.L;
                break;
            case KeyEvent.VK_RIGHT :
                dir = Dir.R;
                break;
            case KeyEvent.VK_UP:
                dir = Dir.U;
                break;
            case KeyEvent.VK_DOWN:
                dir = Dir.D;
                break;
        }
//        move();
    }

    private void move() {
        switch(dir){
            case D:
                y += SPEED;
                break;
            case U:
                y -= SPEED;
                break;
            case L:
                x -= SPEED;
                break;
            case R:
                x += SPEED;
                break;
        }
    }
}
