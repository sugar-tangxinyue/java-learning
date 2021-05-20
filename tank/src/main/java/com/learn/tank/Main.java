package com.learn.tank;


//认识frame类
public class Main {

    public static void main(String[] args) {
        TankFrame tf=new TankFrame();
        for (int i = 0; i < 5; i++) {
            tf.tankList.add(new Tank(50+i*80,50,Dir.DOWN,Group.BAD,tf));
        }
        while (true){
            try {
                Thread.sleep(20);
                tf.repaint();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
