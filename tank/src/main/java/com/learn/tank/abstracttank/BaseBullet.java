package com.learn.tank.abstracttank;


import com.learn.tank.*;

import java.awt.*;

public abstract class BaseBullet {
    public int x;
    public int y;
    public Dir dir = Dir.DOWN;
    public Group group;
    public Rectangle rectangle = new Rectangle();

    /**
     * 画坦克
     *
     * @param g
     */
    public abstract void paint(Graphics g);

    /**
     * 子弹死亡
     */
    public abstract void die();

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
}
