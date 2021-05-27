package com.learn.tank.fire;

import com.learn.tank.Bullet;
import com.learn.tank.Dir;
import com.learn.tank.Tank;
import com.learn.tank.abstracttank.AbstractFactory;

public class TankFireFour implements Fire {

    private static final TankFireFour INSTANCE=new TankFireFour();

    private TankFireFour() {
    }

    public static TankFireFour getInstance(){
        return INSTANCE;
    }

    @Override
    public void fire(Tank tank) {
        System.out.println("四个方向，每个方向一颗子弹");
        int bX = tank.getX() + Tank.WIDTH / 2 - Bullet.WIDTH / 2;
        int bY = tank.getY() + Tank.HEIGHT / 2 - Bullet.HEIGHT / 2;
        Dir[] dirs=Dir.values();
        for(Dir dir:dirs){
            tank.getTankFrame().factory.createBullet(bX, bY, dir, tank.getGroup(), tank.getTankFrame());
        }
    }
}