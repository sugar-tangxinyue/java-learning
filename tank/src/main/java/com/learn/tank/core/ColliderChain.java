package com.learn.tank.core;

import com.learn.tank.GameObject;

import java.util.LinkedList;
import java.util.List;

public class ColliderChain implements Collider {

    public List<Collider> colliderList = new LinkedList<>();

    public ColliderChain() {
        colliderList.add(new BulletTankCollider());
        colliderList.add(new TankTankCollider());
        colliderList.add(new BulletWallCollider());
        colliderList.add(new TankWallCollider());
    }

    @Override
    public boolean collider(GameObject o1, GameObject o2) {
        for (Collider c : colliderList) {
            if (c.collider(o1, o2)) {
                return true;
            }
        }
        return false;
    }
}
