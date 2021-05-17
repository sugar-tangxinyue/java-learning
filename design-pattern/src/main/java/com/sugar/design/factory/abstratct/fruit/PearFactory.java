package com.sugar.design.factory.abstratct.fruit;

public class PearFactory {
    public Fruit create(){
        return new Pear();
    }
}
