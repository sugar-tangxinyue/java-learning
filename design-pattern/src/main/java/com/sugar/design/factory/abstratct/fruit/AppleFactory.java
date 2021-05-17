package com.sugar.design.factory.abstratct.fruit;

public class AppleFactory {

    public Fruit create(){
        return new Apple();
    }
}
