package com.sugar.design.factory.simple;

public class Person {

    public static void main(String[] args) {
        FruitFactory fruitFactory=new FruitFactory();
        Fruit fruit = fruitFactory.create("apple");
        Fruit fruit2 = fruitFactory.create("pear");
        fruit.eat();
        fruit2.eat();
    }
}
