package com.learn.tank;

import java.awt.*;

public class Bullet {
    private int x;
    private int y;
    private Dir dir = Dir.DOWN;
    private Group group;
    //不能被改变，用final
    private static final int SPEED = 5;
    public static final int WIDTH = ResourceMgr.bulletD.getWidth();
    public static final int HEIGHT = ResourceMgr.bulletD.getHeight();
    private boolean living = true;
    private TankFrame tankFrame;
    private Rectangle rectangle = new Rectangle();

    public Bullet(int x, int y, Dir dir, Group group, TankFrame tankFrame) {
        this.x = x;
        this.y = y;
        this.dir = dir;
        this.group = group;
        this.tankFrame = tankFrame;
        this.rectangle.x = this.x;
        this.rectangle.y = this.y;
        this.rectangle.width = WIDTH;
        this.rectangle.height = this.HEIGHT;
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
        } else {
            rectangle.x = x;
            rectangle.y = y;
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

    public Group getGroup() {
        return group;
    }

    public void setGroup(Group group) {
        this.group = group;
    }

    public Rectangle getRectangle() {
        return rectangle;
    }

    public void setRectangle(Rectangle rectangle) {
        this.rectangle = rectangle;
    }

    /**
     * 坦克是否跟子弹相撞
     *
     * @param tank
     */
    public boolean collideWith(Tank tank) {
        if (this.group == tank.getGroup()) {
            return false;
        }
        if (this.rectangle.intersects(tank.getRectangle())) {
            tank.die();
            this.die();
            return true;
        }
        return false;
    }

    /**
     * 子弹消失
     */
    private void die() {
        this.living = false;
    }
}
