package com.sugar.design.strategy;

public class Cat implements Comparable<Cat> {
    int weight;

    public Cat(int weight) {
        this.weight = weight;
    }

    @Override
    public int compareTo(Cat o) {
        if (this.weight > o.weight) return -1;
        else if (this.weight < o.weight) return 1;
        else return 0;
    }

    @Override
    public String toString() {
        return "Cat{" +
                "weight=" + weight +
                '}';
    }
}
