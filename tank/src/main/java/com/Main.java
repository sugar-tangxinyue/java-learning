package com;

import com.sugar.tank.TankFrame;

public class Main {
    public static void main(String[] args) {
        test01();
    }

    //隔5秒刷新一下窗口中方块的位置
    //repaint自动调用刷新窗口
    public static void test01() {
        TankFrame f = new TankFrame();
        while (true) {
            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                System.out.println(e.getCause());
            }
            f.repaint();
        }
    }
}
