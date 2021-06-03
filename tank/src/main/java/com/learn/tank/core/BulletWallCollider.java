package com.learn.tank.core;

import com.learn.tank.*;

public class BulletWallCollider implements Collider {
    @Override
    public boolean collider(GameObject o1, GameObject o2) {
        if (o1 instanceof Wall && o2 instanceof Bullet) {
            Wall wall = (Wall) o1;
            Bullet bullet = (Bullet) o2;
            collideWith(bullet, wall);
            return false;
        } else if (o1 instanceof Bullet && o2 instanceof Wall) {
            return collider(o2, o1);
        }
        return false;
    }

    /**
     * 子弹是否跟墙相撞
     *
     * @param bullet
     * @param wall
     * @return
     */
    public boolean collideWith(Bullet bullet, Wall wall) {
        if (bullet.getRectangle().intersects(wall.getRectangle())) {
            bullet.die();
            return true;
        }
        return false;
    }
}
