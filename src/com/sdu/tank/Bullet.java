package com.sdu.tank;

import java.awt.*;

/**
 * @author huaikong
 * @create 2021-01-17 8:21
 */
public class Bullet {
    private static final int SPEED = 8;
    private static final int WIDTH = 10,HEIGHT = 10;
    public int x,y;
    private Dir dir;

    private TankFrame tf;

    public boolean live = true;

    public Bullet(int x, int y, Dir dir,TankFrame tf) {
        this.x = x;
        this.y = y;
        this.dir = dir;
        this.tf = tf;
    }

    public void paint(Graphics g){
        Color c = g.getColor();
        g.setColor(Color.red);
        g.fillOval(x,y,WIDTH,HEIGHT);
        g.setColor(c);

        move();
        if(!live) tf.bullets.remove(this);
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
        if(x < 0 || y < 0 || x > tf.getWidth() || y > tf.getHeight()) live = false;
    }
}
