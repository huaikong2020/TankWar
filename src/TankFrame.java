import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

/**
 * @author huaikong
 * @create 2021-01-14 9:32
 */
public class TankFrame extends Frame {

    private Tank myTank;
    private Tank enemy;
    public Bullet b;
    ArrayList<Bullet> bullets = new ArrayList<>();

    public TankFrame(){
        this.setTitle("tank war");
        this.setLocation(400,100);
        this.setSize(800,600);
//        b = new Bullet(100,100,Dir.D);
        myTank = new Tank(400,100, Dir.R,this);
//        enemy = new Tank(400,300, Dir.R);
//        b = new Bullet()
        this.addKeyListener(new TankKeyListener());
    }

    @Override
    public void paint(Graphics g) {
        myTank.paint(g);
//        enemy.paint(g);
        for(int i = 0;i < bullets.size();i++){
//            b.paint(g);
            bullets.get(i).paint(g);
        }
    }


    private class TankKeyListener extends KeyAdapter {

        @Override
        public void keyPressed(KeyEvent e) {

            myTank.keyPressed(e);

        }

        @Override
        public void keyReleased(KeyEvent e) {
            myTank.keyReleased(e);
        }
    }
}
