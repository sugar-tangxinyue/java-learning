package com.learn.tank.core;

import com.learn.tank.*;

public class BulletTankCollider implements Collider {
    @Override
    public boolean collider(GameObject o1, GameObject o2) {
        if (o1 instanceof Tank && o2 instanceof Bullet) {
            Tank tank = (Tank) o1;
            Bullet bullet = (Bullet) o2;
            return collideWith(bullet, tank);
        } else if (o1 instanceof Bullet && o2 instanceof Tank) {
            return collider(o2, o1);
        }
        return false;
    }

    /**
     * 坦克是否跟子弹相撞
     *
     * @param tank
     */
    public boolean collideWith(Bullet bullet, Tank tank) {
        if (bullet.getGroup() == tank.getGroup()) {
            return false;
        }
        if (bullet.getRectangle().intersects(tank.getRectangle())) {
            tank.die();
            bullet.die();
            new Explode(tank.getX() + Tank.WIDTH / 2 - Explode.WIDTH / 2, tank.getY() + Tank.HEIGHT / 2 - Explode.HEIGHT / 2);
            return true;
        }
        return false;
    }
}
