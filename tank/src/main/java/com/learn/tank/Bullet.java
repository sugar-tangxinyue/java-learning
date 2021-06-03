package com.learn.tank;

import java.awt.*;

public class Bullet extends GameObject {
    private int x;
    private int y;
    private Dir dir = Dir.DOWN;
    private Group group;
    //不能被改变，用final
    private static final int SPEED = Integer.parseInt(PropertyMgr.getString("bulletSpeed"));
    public static final int WIDTH = ResourceMgr.bulletD.getWidth();
    public static final int HEIGHT = ResourceMgr.bulletD.getHeight();
    private boolean living = true;
    private Rectangle rectangle = new Rectangle();

    public Bullet(int x, int y, Dir dir, Group group) {
        this.x = x;
        this.y = y;
        this.dir = dir;
        this.group = group;
        this.rectangle.x = x;
        this.rectangle.y = y;
        this.rectangle.width = WIDTH;
        this.rectangle.height = this.HEIGHT;
        GameModel.gameObjectList.add(this);
    }

    public void paint(Graphics g) {
        if (!living) {
            GameModel.gameObjectList.remove(this);
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
     * 子弹消失
     */
    public void die() {
        this.living = false;
    }
}
