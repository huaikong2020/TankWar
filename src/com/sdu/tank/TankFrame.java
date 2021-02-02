package com.sdu.tank;

import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
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
    private int GAME_WIDTH = 1000;
    private int GAME_HEIGHT = 800;

    ArrayList<Bullet> bullets = new ArrayList<>();

    private TankFrame(){
        this.setTitle("tank war");
        this.setLocation(400,100);
        this.setSize(GAME_WIDTH,GAME_HEIGHT);

        myTank = new Tank(400,100, Dir.R,this,Group.GOOD);

        this.addKeyListener(new TankKeyListener());
        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
    }


    //双缓冲
    Image offScreenImage = null;
//双缓冲
    @Override
    public void update(Graphics g) {
        if (offScreenImage == null) {
            offScreenImage = this.createImage(GAME_WIDTH, GAME_HEIGHT);
        }
        Graphics gOffScreen = offScreenImage.getGraphics();
        Color c = gOffScreen.getColor();
        gOffScreen.setColor(Color.WHITE);
        gOffScreen.fillRect(0, 0, GAME_WIDTH, GAME_HEIGHT);
        gOffScreen.setColor(c);
        paint(gOffScreen);
        g.drawImage(offScreenImage, 0, 0, null);
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
