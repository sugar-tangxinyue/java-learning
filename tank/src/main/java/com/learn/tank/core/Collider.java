package com.learn.tank.core;

import com.learn.tank.GameObject;

public interface Collider {
    /**
     * 两个物体是否相撞，相撞返回true，否则返回false
     *
     * @param o1
     * @param o2
     * @return
     */
    boolean collider(GameObject o1, GameObject o2);
}
