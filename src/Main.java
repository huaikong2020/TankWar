/**
 * @author huaikong
 * @create 2021-01-14 9:32
 */
public class Main {
    public static void main(String[] args) {
        TankFrame tf = new TankFrame();
        tf.setVisible(true);


        for(;;){
            try {
                Thread.sleep(25);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            tf.repaint();
        }
    }
}
