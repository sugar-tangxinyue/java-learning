package com.learn.tank;


//认识frame类
public class Main {

    public static void main(String[] args) {
        TankFrame tf = new TankFrame();
        while (true) {
            try {
                Thread.sleep(2);
                tf.repaint();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
