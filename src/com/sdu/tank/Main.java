package com.sdu.tank;

/**
 * @author huaikong
 * @create 2021-01-14 9:32
 */
public class Main {
    public static void main(String[] args) {
        TankFrame.INSTANCE.setVisible(true);
        int count = Integer.parseInt((String)PropertyMgr.get("count"));

        for(int i = 0;i < count;i++){
            TankFrame.INSTANCE.enemy.add(new Tank(50 + i * 60,200,Dir.D,TankFrame.INSTANCE,Group.BAD));
        }


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
