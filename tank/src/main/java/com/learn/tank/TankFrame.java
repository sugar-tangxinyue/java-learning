package com.learn.tank;

import com.learn.tank.abstracttank.*;
import com.learn.tank.fire.TankFireDefalt;

import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import java.util.List;

public class TankFrame extends Frame {
    public static final int GAME_WIDTH = 1000;
    public static final int GAME_HEIGHT = 750;

    public AbstractFactory factory=new GoodTankFactory();
    public BaseTank myTank = factory.createTank(200, 400, Dir.DOWN, Group.GOOD, this);
    public List<BaseBullet> bulletList = new ArrayList<>();
    public List<BaseTank> tankList = new ArrayList<>();
    public List<BaseExplode> explodeList = new ArrayList<>();

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
        Color c = g.getColor();
        g.setColor(Color.WHITE);
        g.drawString("bullets:" + bulletList.size(), 10, 60);
        g.drawString("tanks:" + tankList.size(), 10, 80);
        g.drawString("explodes" + explodeList.size(), 10, 100);
        g.setColor(c);
        //画坦克
        myTank.paint(g);
        //画出子弹
        for (int i = 0; i < bulletList.size(); i++) {
            bulletList.get(i).paint(g);
        }
        //画出敌方坦克
        for (int i = 0; i < tankList.size(); i++) {
            tankList.get(i).paint(g);
        }
        //碰撞
        for (int i = 0; i < bulletList.size(); i++) {
            for (int j = 0; j < tankList.size(); j++) {
                BaseTank tankJ = tankList.get(j);
                boolean isHit = collideWith(tankJ, bulletList.get(i));
                if (isHit) {
                    explodeList.add(factory.createExplode(tankJ.getX() + Tank.WIDTH / 2 - Explode.WIDTH / 2, tankJ.getY() + Tank.HEIGHT / 2 - Explode.HEIGHT / 2, this));
                }
            }
        }
        //画出爆炸
        for (int i = 0; i < explodeList.size(); i++) {
            explodeList.get(i).paint(g);
        }
    }

    /**
     * 坦克是否跟子弹相撞
     *
     * @param tank
     */
    public boolean collideWith(BaseTank tank, BaseBullet bullet) {
        if (bullet.getGroup() == tank.getGroup()) {
            return false;
        }
        if (bullet.getRectangle().intersects(tank.getRectangle())) {
            tank.die();
            bullet.die();
            return true;
        }
        return false;
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
                case KeyEvent.VK_CONTROL:
                    myTank.fire(TankFireDefalt.getInstance());
                    break;
                default:
                    break;
            }
            setMainTankDir();
        }

        private void setMainTankDir() {
            if (!bL && !bR && !bD && !bU) {
                myTank.setMoving(false);
            } else {
                myTank.setMoving(true);

                if (bL) {
                    myTank.setDir(Dir.LEFT);
                }
                if (bU) {
                    myTank.setDir(Dir.UP);
                }
                if (bR) {
                    myTank.setDir(Dir.RIGHT);
                }
                if (bD) {
                    myTank.setDir(Dir.DOWN);
                }
            }
        }
    }

}
