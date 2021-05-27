package com.learn.tank.fire;

import com.learn.tank.Bullet;
import com.learn.tank.Tank;
import com.learn.tank.abstracttank.AbstractFactory;

public class TankFireDefalt implements Fire {

    private static final TankFireDefalt INSTANCE=new TankFireDefalt();

    private TankFireDefalt() {
    }

    public static TankFireDefalt getInstance(){
        return INSTANCE;
    }

    @Override
    public void fire(Tank tank) {
        System.out.println("一颗子弹");
        int bX = tank.getX() + Tank.WIDTH / 2 - Bullet.WIDTH / 2;
        int bY = tank.getY() + Tank.HEIGHT / 2 - Bullet.HEIGHT / 2;
        tank.getTankFrame().factory.createBullet(bX, bY, tank.getDir(), tank.getGroup(), tank.getTankFrame());
    }
}
