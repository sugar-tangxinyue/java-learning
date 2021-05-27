package com.learn.tank.abstracttank;

import com.learn.tank.*;

public class GoodTankFactory implements AbstractFactory{
    @Override
    public BaseBullet createBullet(int x, int y, Dir dir, Group group, TankFrame tankFrame){
        return new Bullet( x,  y,  dir,  group,  tankFrame);
    }

    @Override
    public BaseTank createTank(int x, int y, Dir dir, Group group, TankFrame tankFrame)  {
        return new Tank(x, y, dir, group, tankFrame);
    }

    @Override
    public BaseExplode createExplode(int x, int y, TankFrame tankFrame) {
        return new Explode(x,y,tankFrame);
    }
}
