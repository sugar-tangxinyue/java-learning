package com.learn.tank.core;

import com.learn.tank.GameObject;
import com.learn.tank.Tank;

public class TankTankCollider implements Collider {
    @Override
    public boolean collider(GameObject o1, GameObject o2) {
        if (o1 instanceof Tank && o2 instanceof Tank) {
            Tank tank1 = (Tank) o1;
            Tank tank2 = (Tank) o2;
            return collideWith(tank1, tank2);
        }
        return false;
    }

    /**
     * 两个坦克是否相撞
     *
     * @param tank1
     * @param tank2
     * @return
     */
    public boolean collideWith(Tank tank1, Tank tank2) {
        if (tank1.getRectangle().intersects(tank2.getRectangle())) {
            tank1.back();
            tank2.back();
        }
        return false;
    }
}
