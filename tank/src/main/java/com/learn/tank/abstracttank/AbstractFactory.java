package com.learn.tank.abstracttank;

import com.learn.tank.Dir;
import com.learn.tank.Group;
import com.learn.tank.TankFrame;

public abstract interface AbstractFactory {

    BaseBullet createBullet(int x, int y, Dir dir, Group group, TankFrame tankFrame);

    BaseTank createTank(int x, int y, Dir dir, Group group, TankFrame tankFrame) ;

    BaseExplode createExplode(int x, int y, TankFrame tankFrame) ;
}
