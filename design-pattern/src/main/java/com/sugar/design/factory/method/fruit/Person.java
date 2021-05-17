package com.sugar.design.factory.method.fruit;


public class Person {

    public static void main(String[] args) {
        AppleFactory fruitFactory = new AppleFactory();
        Fruit fruit = fruitFactory.create();
        PearFactory pearFactory = new PearFactory();
        Fruit fruit2 = pearFactory.create();
        fruit.eat();
        fruit2.eat();
    }
}
