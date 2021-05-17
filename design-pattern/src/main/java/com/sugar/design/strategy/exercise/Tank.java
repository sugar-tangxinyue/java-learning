package com.sugar.design.strategy.exercise;

public class Tank {

    public static void main(String[] args) {
        Tank tank = new Tank();
        tank.fire(new TankFireDefalt());
    }

    public void fire(Fire fire) {
        fire.fire();
    }
}
