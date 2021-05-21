package com.learn.tank;


//认识frame类
public class Main {

    public static void main(String[] args) {
        TankFrame tf = new TankFrame();
        int initTankCoune=Integer.parseInt(PropertyMgr.getString("initTankCount"));
        for (int i = 0; i < initTankCoune; i++) {
            tf.tankList.add(new Tank(50 + i * 80, 50, Dir.DOWN, Group.BAD, tf));
        }
        while (true) {
            try {
                Thread.sleep(10);
                tf.repaint();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
