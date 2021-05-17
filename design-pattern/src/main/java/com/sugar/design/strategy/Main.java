package com.sugar.design.strategy;

public class Main {
    public static void main(String[] args) {

        Cat[] catList = {new Cat(1), new Cat(5), new Cat(2),};
        Sorter.sort(catList);
        for (int i = 0; i < catList.length; i++) {
            System.out.print(catList[i]);
        }
        System.out.println("===================");
        Cat[] catList2 = {new Cat(1), new Cat(5), new Cat(2),};
        Sorter2 sorter2=new Sorter2();
        sorter2.sort(catList2,new CatComparator());
        for (int i = 0; i < catList2.length; i++) {
            System.out.print(catList[i]);
        }
        System.out.println("===================");

        Dog[] dogList = {new Dog(1), new Dog(5), new Dog(2),};
        Sorter.sort(dogList);
        for (int i = 0; i < dogList.length; i++) {
            System.out.print(dogList[i]);
        }
        System.out.println("");
    }
}
