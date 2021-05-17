package com.sugar.design.factory.simple;

public class FruitFactory {

    public Fruit create(String type){
        switch(type){
            case "apple":
                //省略复杂步骤....
                return new Apple();
            case "pear": return new Pear();
            default:throw new IllegalArgumentException("暂时没有这种水果");
        }
    }
}
