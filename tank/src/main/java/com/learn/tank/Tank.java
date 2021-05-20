package com.learn.tank;

import java.awt.*;

public class Tank {
    private int x;
    private int y;
    private Dir dir = Dir.DOWN;
    private boolean moving = false;
    private boolean living = true;
    private TankFrame tankFrame;
    //不能被改变，用final
    private static final int SPEED = 5;
    public static final int WIDTH = ResourceMgr.tankD.getWidth();
    public static final int HEIGHT = ResourceMgr.tankD.getWidth();

    public Tank(int x, int y, Dir dir, TankFrame tankFrame) {
        this.x = x;
        this.y = y;
        this.dir = dir;
        this.tankFrame = tankFrame;
    }

    public void paint(Graphics g) {
        if (!living) {
            tankFrame.tankList.remove(this);
        }
        Image image = null;
        switch (dir) {
            case LEFT:
                image = ResourceMgr.tankL;
                break;
            case UP:
                image = ResourceMgr.tankU;
                break;
            case RIGHT:
                image = ResourceMgr.tankR;
                break;
            case DOWN:
                image = ResourceMgr.tankD;
                break;
            default:
                break;
        }
        g.drawImage(image, x, y, null);
        move();
    }

    /**
     * 子弹移动
     */
    private void move() {
        if (!moving) {
            return;
        }
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

    public boolean isMoving() {
        return moving;
    }

    public void setMoving(boolean moving) {
        this.moving = moving;
    }

    /**
     * 坦克打出子弹
     */
    public void fire() {
        int bX = this.x + Tank.WIDTH / 2 - Bullet.WIDTH / 2;
        int bY = this.y + Tank.HEIGHT / 2 - Bullet.HEIGHT / 2;
        tankFrame.bulletList.add(new Bullet(bX, bY, this.dir, this.tankFrame));
    }

    /**
     * 坦克消失
     */
    public void die() {
        this.living = false;
    }
}
