package com.sdu.tank;

import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

/**
 * @author huaikong
 * @create 2021-01-14 9:32
 */
public class TankFrame extends Frame {
    public static final TankFrame INSTANCE = new TankFrame();

    private Tank myTank;
    private Tank enemy;
    private Bullet b;

    ArrayList<Bullet> bullets = new ArrayList<>();

    private TankFrame(){
        this.setTitle("tank war");
        this.setLocation(400,100);
        this.setSize(800,600);

        myTank = new Tank(400,100, Dir.R,this,Group.GOOD);

        this.addKeyListener(new TankKeyListener());
    }

    @Override
    public void paint(Graphics g) {
        Color c = g.getColor();
        g.setColor(Color.BLUE);
        g.drawString("bullets:" + bullets.size(),10,50);
        g.setColor(c);

        myTank.paint(g);

        for(int i = 0;i < bullets.size();i++){
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
