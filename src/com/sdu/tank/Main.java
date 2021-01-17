package com.sdu.tank;

/**
 * @author huaikong
 * @create 2021-01-14 9:32
 */
public class Main {
    public static void main(String[] args) {
        TankFrame.INSTANCE.setVisible(true);


        for(;;){
            try {
                Thread.sleep(25);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            TankFrame.INSTANCE.repaint();
        }
    }
}
