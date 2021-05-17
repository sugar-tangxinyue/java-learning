package com.sugar.design.strategy.exercise;

public class TankFireFour implements Fire {
    @Override
    public void fire() {
        System.out.println("四个方向，每个方向一颗子弹");
    }
}