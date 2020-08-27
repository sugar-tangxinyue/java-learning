package com.sugar.tank;

import com.mashibing.tank.Dir;

import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/**
 * 继承Frame,重写paint方法，在画布上画出黑色方块
 */
public class TankFrame extends Frame {

    Tank tank = new Tank(200, 200, Dir.DOWM);


    public TankFrame() {

        setSize(800, 600);
        //是否能改变大小
        setResizable(false);
        setTitle("tank war");
        setVisible(true);
        this.addKeyListener(new MykeyListener());
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
    }

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

    @Override
    public void paint(Graphics g) {
        tank.paint(g);
    }

    class MykeyListener extends KeyAdapter {
        boolean bL = false;
        boolean bU = false;
        boolean bR = false;
        boolean bD = false;

        @Override
        public void keyReleased(KeyEvent e) {
            int key = e.getKeyCode();
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
            if (bL) tank.setDir(Dir.LEFT);
            if (bU) tank.setDir(Dir.UP);
            if (bR) tank.setDir(Dir.RIGHT);
            if (bD) tank.setDir(Dir.DOWM);
        }

        @Override
        public void keyPressed(KeyEvent e) {
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
