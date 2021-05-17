package com.sugar.design.strategy.exercise;

public class TankFireNbomb implements Fire {
    @Override
    public void fire() {
        System.out.println("打出核弹");
    }
}