package com.learn.tank;

import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class TankFrame extends Frame {
    public static final int GAME_WIDTH = 1000;
    public static final int GAME_HEIGHT = 750;

    public TankFrame() {
        //设置窗口可见
        setVisible(true);
        //设置窗口大小
        setSize(GAME_WIDTH, GAME_HEIGHT);
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
        GameModel.getInstance().paint(g);
    }

    /**
     * 双缓冲解决画面闪烁的问题
     * 首先把画出来的东西，画在内存中的图片中，图片大小和页面大小一致
     */
    Image offScreenImage = null;

    @Override
    public void update(Graphics g) {
        if (offScreenImage == null) {
            offScreenImage = this.createImage(GAME_WIDTH, GAME_HEIGHT);
        }
        Graphics gOffSceen = offScreenImage.getGraphics();
        Color c = gOffSceen.getColor();
        gOffSceen.setColor(Color.BLACK);
        gOffSceen.fillRect(0, 0, GAME_WIDTH, GAME_HEIGHT);
        gOffSceen.setColor(c);
        paint(gOffSceen);
        g.drawImage(offScreenImage, 0, 0, null);
    }

    class MyKeyListener extends KeyAdapter {
        boolean bL = false;
        boolean bU = false;
        boolean bR = false;
        boolean bD = false;

        @Override
        public void keyPressed(KeyEvent e) {
            int key = e.getKeyCode();
//            System.out.println("key pressed,the key is " + key);
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

        @Override
        public void keyReleased(KeyEvent e) {
            int key = e.getKeyCode();
//            System.out.println("key released,the key is " + key);
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
                case 157:
                    GameModel.getInstance().myTank.fire();
                    break;
                default:
                    break;
            }
            setMainTankDir();
        }

        private void setMainTankDir() {
            if (!bL && !bR && !bD && !bU) {
                GameModel.getInstance().myTank.setMoving(false);
            } else {
                GameModel.getInstance().myTank.setMoving(true);
                if (bL) {
                    GameModel.getInstance().myTank.setDir(Dir.LEFT);
                }
                if (bU) {
                    GameModel.getInstance().myTank.setDir(Dir.UP);
                }
                if (bR) {
                    GameModel.getInstance().myTank.setDir(Dir.RIGHT);
                }
                if (bD) {
                    GameModel.getInstance().myTank.setDir(Dir.DOWN);
                }
            }
        }
    }
}
