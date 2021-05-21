package com.learn.tank;

import java.awt.*;
import java.util.Random;

public class Tank {
    private int x;
    private int y;
    private Dir dir = Dir.DOWN;
    private Group group;
    private boolean moving = true;
    private boolean living = true;
    private TankFrame tankFrame;
    //不能被改变，用final
    private static final int SPEED = Integer.parseInt(PropertyMgr.getString("tankSpeed"));
    public static final int WIDTH = ResourceMgr.goodTankD.getWidth();
    public static final int HEIGHT = ResourceMgr.goodTankD.getWidth();
    private Rectangle rectangle = new Rectangle();

    private Random random = new Random();

    public Tank(int x, int y, Dir dir, Group group, TankFrame tankFrame) {
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
            tankFrame.tankList.remove(this);
            return;
        }
        randomDir();
        g.drawImage(getImage(), x, y, null);
        move();
    }

    /**
     * 获取图片
     *
     * @return
     */
    private Image getImage() {
        switch (group) {
            case BAD:
                switch (dir) {
                    case LEFT:
                        return ResourceMgr.badTankL;
                    case UP:
                        return ResourceMgr.badTankU;
                    case RIGHT:
                        return ResourceMgr.badTankR;
                    case DOWN:
                        return ResourceMgr.badTankD;
                    default:
                        return null;
                }
            case GOOD:
                switch (dir) {
                    case LEFT:
                        return ResourceMgr.goodTankL;
                    case UP:
                        return ResourceMgr.goodTankU;
                    case RIGHT:
                        return ResourceMgr.goodTankR;
                    case DOWN:
                        return ResourceMgr.goodTankD;
                    default:
                        return null;
                }
            default:
                return null;
        }
    }

    /**
     * 敌机生成随机方向,如果即将超出边界，反方向运行
     */
    private void randomDir() {
        if (this.group == Group.GOOD) {
            return;
        }
        if (random.nextInt(100) > 95) {
            this.dir = Dir.values()[random.nextInt(4)];
        }
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
        if (this.group == Group.BAD && random.nextInt(10) > 8) {
            this.fire();
        }
        //边界检测
        boundsCheck();
        rectangle.x = x;
        rectangle.y = y;
    }

    private void boundsCheck() {
        if (x < 2) x = 2;
        if (y < 28) y = 28;
        if (x > TankFrame.GAME_WIDTH - Tank.WIDTH - 2) x = TankFrame.GAME_WIDTH - Tank.WIDTH - 2;
        if (y > TankFrame.GAME_HEIGHT - Tank.HEIGHT - 2) y = TankFrame.GAME_HEIGHT - Tank.HEIGHT - 2;
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
     * 坦克打出子弹
     */
    public void fire() {
        int bX = this.x + Tank.WIDTH / 2 - Bullet.WIDTH / 2;
        int bY = this.y + Tank.HEIGHT / 2 - Bullet.HEIGHT / 2;
        tankFrame.bulletList.add(new Bullet(bX, bY, this.dir, this.group, this.tankFrame));
    }

    /**
     * 坦克消失
     */
    public void die() {
        this.living = false;
    }
}
