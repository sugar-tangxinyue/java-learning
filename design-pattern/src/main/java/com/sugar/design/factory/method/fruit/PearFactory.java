package com.sugar.design.factory.method.fruit;

public class PearFactory {
    public Fruit create(){
        return new Pear();
    }
}
