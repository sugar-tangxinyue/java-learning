package com.learn.tank;


//认识frame类
public class Main {

    public static void main(String[] args) {
        TankFrame tf = new TankFrame();
        int initTankCoune=Integer.parseInt(PropertyMgr.getString("initTankCount"));
        for (int i = 0; i < initTankCoune; i++) {
            tf.tankList.add(tf.factory.createTank(50 + i * 80, 50, Dir.DOWN, Group.BAD, tf));
        }
        while (true) {
            try {
                Thread.sleep(3);
                tf.repaint();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
