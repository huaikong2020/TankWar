package com.sdu.tank;

import java.awt.*;
import java.awt.event.KeyEvent;

/**
 * @author huaikong
 * @create 2021-01-14 10:45
 */
public class Tank {
    private int x, y;
    private static final int SPEED = 5;
    private Dir dir;
    private boolean bL, bU, bR, bD;
    private Group group;

    private TankFrame tf;

    public Tank(int x,int y,Dir dir,TankFrame tf,Group group){
        this.x = x;
        this.y = y;
        this.dir = dir;
        this.tf = tf;
        this.group = group;
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
                bL = true;
                break;
            case KeyEvent.VK_RIGHT :
                dir = Dir.R;
                bR = true;
                break;
            case KeyEvent.VK_UP:
                dir = Dir.U;
                bU = true;
                break;
            case KeyEvent.VK_DOWN:
                dir = Dir.D;
                bD = true;
                break;
            case KeyEvent.VK_SPACE:
                fire();
                break;
        }
    }

    public void keyReleased(KeyEvent e) {
        int key = e.getKeyCode();
        switch (key) {
            case KeyEvent.VK_LEFT:
                bL = false;
                break;
            case KeyEvent.VK_RIGHT:
                bR = false;
                break;
            case KeyEvent.VK_UP:
                bU = false;
                break;
            case KeyEvent.VK_DOWN:
                bD = false;
                break;
        }
    }

    private void move() {
        if(bL) x -= SPEED;
        if(bR) x += SPEED;
        if(bU) y -= SPEED;
        if(bD) y += SPEED;

    }

    public void fire(){
        tf.bullets.add(new Bullet(this.x,this.y,this.dir,tf));
    }
}
