import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

/**
 * @author huaikong
 * @create 2021-01-14 9:32
 */
public class TankFrame extends Frame {

    private Tank myTank;
    private Tank enemy;

    public TankFrame(){
        this.setTitle("tank war");
        this.setLocation(400,100);
        this.setSize(800,600);

        myTank = new Tank(400,100, Dir.R);
        enemy = new Tank(400,300, Dir.R);
        this.addKeyListener(new TankKeyListener());
    }

    @Override
    public void paint(Graphics g) {
        myTank.paint(g);
        enemy.paint(g);
    }


    private class TankKeyListener extends KeyAdapter {

        @Override
        public void keyPressed(KeyEvent e) {

            myTank.keyPressed(e);

        }

        @Override
        public void keyReleased(KeyEvent keyEvent) {
            System.out.println();
        }
    }
}
