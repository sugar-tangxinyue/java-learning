package com.sugar.design.strategy;

public class Dog implements Comparable<Dog> {
    private int weight;

    public Dog(int weight) {
        this.weight = weight;
    }

    @Override
    public int compareTo(Dog o) {
        if (this.weight > o.weight) return -1;
        else if (this.weight < o.weight) return 1;
        else return 0;
    }

    @Override
    public String toString() {
        return "Dog{" +
                "weight=" + weight +
                '}';
    }
}
