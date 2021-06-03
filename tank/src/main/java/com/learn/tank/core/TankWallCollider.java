package com.learn.tank.core;

import com.learn.tank.Bullet;
import com.learn.tank.GameObject;
import com.learn.tank.Tank;
import com.learn.tank.Wall;

public class TankWallCollider implements Collider {
    @Override
    public boolean collider(GameObject o1, GameObject o2) {
        if (o1 instanceof Tank && o2 instanceof Wall) {
            Wall wall = (Wall) o2;
            Tank tank = (Tank) o1;
            collideWith(tank, wall);
        } else if (o1 instanceof Wall && o2 instanceof Tank) {
            collider(o2, o1);
        }
        return false;
    }

    /**
     * 子弹是否跟墙相撞
     *
     * @param tank
     * @param wall
     * @return
     */
    public boolean collideWith(Tank tank, Wall wall) {
        if (tank.getRectangle().intersects(wall.getRectangle())) {
            tank.back();
        }
        return false;
    }
}
