package com.sdu.tank;

import java.awt.*;

/**
 * @author huaikong
 * @create 2021-01-17 8:21
 */
public class Bullet {
    private static final int SPEED = 10;
    public static final int WIDTH = ResourceMgr.bulletD.getWidth(),HEIGHT = ResourceMgr.bulletD.getHeight();
    public int x,y;
    private Dir dir;
    private Rectangle rect = new Rectangle();

    private TankFrame tf;

    public boolean living = true;

    private Group group ;

    public Bullet(int x, int y, Dir dir,TankFrame tf,Group group) {
        this.x = x;
        this.y = y;
        this.dir = dir;
        this.tf = tf;
        this.group = group;
        this.rect.y = y;
        this.rect.x = x;
        rect.width = WIDTH;
        rect.height = HEIGHT;
    }

    public void paint(Graphics g){
        if(!living){
            tf.bullets.remove(this);
            return;
        }
        switch (dir){
            case D:
                g.drawImage(ResourceMgr.bulletD,x,y,null);
                break;
            case R:
                g.drawImage(ResourceMgr.bulletR,x,y,null);
                break;
            case L:
                g.drawImage(ResourceMgr.bulletL,x,y,null);
                break;
            case U:
                g.drawImage(ResourceMgr.bulletU,x,y,null);
                break;
        }

        move();
        if(!living) tf.bullets.remove(this);
    }

    private void move(){
        switch (dir){
            case R:
                x += SPEED;
                break;
            case L:
                x -= SPEED;
                break;
            case U:
                y -= SPEED;
                break;
            case D:
                y += SPEED;
                break;
        }
        rect.y = y;
        rect.x = x;
        if(x < 0 || y < 0 || x > tf.getWidth() || y > tf.getHeight()) living = false;
    }

    public void collideWith(Tank tank) {
        if(this.group == tank.getGroup()){
            return;
        }

        if(this.rect.intersects(tank.getRect())){
            tank.die();
            this.die();
            tf.explodes.add(new Explode(tank.getX(),tank.getY(),tf));
        }
    }

    private void die() {
        living = false;
    }
}
