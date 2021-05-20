package com.learn.tank;

import java.awt.*;

public class Bullet {
    private int x;
    private int y;
    private Dir dir = Dir.DOWN;
    //不能被改变，用final
    private static final int SPEED = 5;
    public static final int WIDTH = ResourceMgr.bulletD.getWidth();
    public static final int HEIGHT = ResourceMgr.bulletD.getHeight();
    private boolean living = true;
    private TankFrame tankFrame;

    public Bullet(int x, int y, Dir dir, TankFrame tankFrame) {
        this.x = x;
        this.y = y;
        this.dir = dir;
        this.tankFrame = tankFrame;
    }

    public void paint(Graphics g) {
        if (!living) {
            tankFrame.bulletList.remove(this);
        }
        Image image = null;
        switch (dir) {
            case LEFT:
                image = ResourceMgr.bulletL;
                break;
            case UP:
                image = ResourceMgr.bulletU;
                break;
            case RIGHT:
                image = ResourceMgr.bulletR;
                break;
            case DOWN:
                image = ResourceMgr.bulletD;
                break;
            default:
                break;
        }
        g.drawImage(image, x, y, null);
        move();
    }

    private void move() {
        switch (dir) {
            case LEFT:
                x -= SPEED;
                break;
            case UP:
                y -= SPEED;
                break;
            case RIGHT:
                x += SPEED;
                break;
            case DOWN:
                y += SPEED;
                break;
            default:
                break;
        }
        if (x < 0 || y < 0 || x > TankFrame.GAME_WIDTH || y > TankFrame.GAME_HEIGHT) {
            this.living = false;
        }
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public Dir getDir() {
        return dir;
    }

    public void setDir(Dir dir) {
        this.dir = dir;
    }

    /**
     * 坦克是否跟子弹相撞
     *
     * @param tank
     */
    public void collideWith(Tank tank) {
        Rectangle rectBuellet = new Rectangle(this.x, this.y, WIDTH, HEIGHT);
        Rectangle rectTank = new Rectangle(tank.getX(), tank.getX(), Tank.WIDTH, Tank.HEIGHT);
        if (rectBuellet.intersects(rectTank)) {
            tank.die();
            this.die();
        }
    }

    /**
     * 子弹消失
     */
    private void die() {
        this.living = false;
    }
}
