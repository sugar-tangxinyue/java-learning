package com.sugar.tank;

import com.mashibing.tank.Dir;

import java.awt.*;

public class Tank {
    private int x;
    private int y;
    private Dir dir=Dir.DOWM;
    private boolean moving=false;
    private static final int SPEED = 5;
    private TankFrame tankFrame;

    public Tank(int x, int y, Dir dir,TankFrame tankFrame) {
        this.x = x;
        this.y = y;
        this.dir = dir;
        this.tankFrame=tankFrame;
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

    public void paint(Graphics g) {
        Color color=g.getColor();
        g.setColor(Color.YELLOW);
        g.fillRect(x, y, 50, 50);
        g.setColor(color);
        move();

    }

    private void move() {
        if(!moving){
            return;
        }
        switch (dir) {
            case UP:
                y -= SPEED;
                break;
            case DOWM:
                y += SPEED;
                break;
            case LEFT:
                x -= SPEED;
                break;
            case RIGHT:
                x += SPEED;
                break;
            default:
                break;
        }
    }

    public void fire() {
        tankFrame.bullet=new Bullet(this.x,this.y,this.dir);
    }
}
