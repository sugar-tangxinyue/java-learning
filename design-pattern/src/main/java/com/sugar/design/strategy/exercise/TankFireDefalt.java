package com.sugar.design.strategy.exercise;

public class TankFireDefalt implements Fire {
    @Override
    public void fire() {
        System.out.println("一颗子弹");
    }
}
