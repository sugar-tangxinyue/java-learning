package com.learn.tank.fire;

import com.learn.tank.Tank;
import com.learn.tank.abstracttank.AbstractFactory;

public class TankFireNbomb implements Fire {
    @Override
    public void fire(Tank tank) {
        System.out.println("打出核弹");
    }
}