package com.sdu.tank;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.util.Random;

/**
 * @author huaikong
 * @create 2021-01-14 10:45
 */
public class Tank {
    public static final int WIDTH = ResourceMgr.tankD.getWidth(),HEIGHT = ResourceMgr.tankD.getHeight();
    private int x, y;
    private static final int SPEED = 5;
    private Dir dir;
    private boolean bL, bU, bR, bD;
    private boolean living = true;
    private Random random = new Random();
    private Group group;
    private Rectangle rect = new Rectangle();

    private TankFrame tf;

    public Group getGroup() {
        return group;
    }

    public void setGroup(Group group) {
        this.group = group;
    }


    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }


    public Rectangle getRect() {
        return rect;
    }

    public void setRect(Rectangle rect) {
        this.rect = rect;
    }

    public Tank(int x, int y, Dir dir, TankFrame tf, Group group){
        this.x = x;
        this.y = y;
        this.dir = dir;
        this.tf = tf;
        this.group = group;
        this.rect.x = x;
        this.rect.y = y;
        rect.width = WIDTH;
        rect.height = HEIGHT;
    }

    public void paint(Graphics g) {
        if(!living){
            tf.enemy.remove(this);
            return;
        }
        switch (dir){
            case D:
                g.drawImage(ResourceMgr.tankD,x,y,null);
                break;
            case R:
                g.drawImage(ResourceMgr.tankR,x,y,null);
                break;
            case L:
                g.drawImage(ResourceMgr.tankL,x,y,null);
                break;
            case U:
                g.drawImage(ResourceMgr.tankU,x,y,null);
                break;
        }
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
        if(this.group == Group.GOOD) {
            if (bL) x -= SPEED;
            if (bR) x += SPEED;
            if (bU) y -= SPEED;
            if (bD) y += SPEED;
        }else {
            if(random.nextInt(100) > 95) {
                this.fire();
            }
                if(random.nextInt(100000) < 1000 ) {
                    this.dir = Dir.values()[random.nextInt(4)];
                }

                boundsCheck();

                switch (dir) {
                    case U:
                        y -= SPEED / 2;
                        break;
                    case D:
                        y += SPEED / 2;
                        break;
                    case L:
                        x -= SPEED / 2;
                        break;
                    case R:
                        x += SPEED / 2;
                        break;
                }
                rect.y = y;
                rect.x = x;


        }

    }

    private void boundsCheck() {
        if(this.x < 0) x = 0;
        if(this.y < 0) y = 0;
        if(this.x > tf.getWidth()) x = tf.getWidth();
        if(this.y > tf.getHeight()) y = tf.getHeight();
    }

    public void fire(){
        int dx = this.x + Tank.WIDTH / 2 - Bullet.WIDTH / 2;
        int dy = this.y + Tank.HEIGHT / 2- Bullet.HEIGHT  / 2;
        tf.bullets.add(new Bullet(dx,dy,this.dir,tf,this.group));
    }

    public void die() {
        living = false;
    }
}
