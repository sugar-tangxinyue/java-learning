package com.learn.tank;

import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class TankFrame extends Frame {

    Tank myTank = new Tank(200, 200, null);

    public TankFrame() {
        //设置窗口可见
        setVisible(true);
        //设置窗口大小
        setSize(800, 600);
        //是否可以改变大小
        setResizable(false);
        setTitle("tank war");
        this.addKeyListener(new MyKeyListener());
        //关闭窗口
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
    }

    //坦克坐标变成变量，可以动起来
    @Override
    public void paint(Graphics g) {
        myTank.paint(g);

    }

    class MyKeyListener extends KeyAdapter {
        boolean bL = false;
        boolean bU = false;
        boolean bR = false;
        boolean bD = false;

        @Override
        public void keyPressed(KeyEvent e) {
            System.out.println("key pressed");
            int key = e.getKeyCode();
            System.out.println(key);
            switch (key) {
                case KeyEvent.VK_LEFT:
                    bL = true;
                    break;
                case KeyEvent.VK_UP:
                    bU = true;
                    break;
                case KeyEvent.VK_RIGHT:
                    bR = true;
                    break;
                case KeyEvent.VK_DOWN:
                    bD = true;
                    break;
                default:
                    break;
            }
            setMainTankDir();
        }

        private void setMainTankDir() {

            if (bL) {
                myTank.setDir(Dir.LEFT);
            } else if (bU) {
                myTank.setDir(Dir.UP);
            } else if (bR) {
                myTank.setDir(Dir.RIGHT);
            } else if (bD) {
                myTank.setDir(Dir.DOWN);
            } else {
                myTank.setDir(null);
            }
        }

        @Override
        public void keyReleased(KeyEvent e) {
            int key = e.getKeyCode();
            switch (key) {
                case KeyEvent.VK_LEFT:
                    bL = false;
                    break;
                case KeyEvent.VK_UP:
                    bU = false;
                    break;
                case KeyEvent.VK_RIGHT:
                    bR = false;
                    break;
                case KeyEvent.VK_DOWN:
                    bD = false;
                    break;
                default:
                    break;
            }
            setMainTankDir();
        }
    }
}
