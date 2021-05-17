package com.sugar.design.singleton;

/**
 * 不仅可以解决线程同步，还可以防止反序列化
 * 为什么不能被反序列化：因为枚举类没有构造方法
 */
public enum  Test07 {

    INSTANCE;

    public static void main(String[] args) {
        for (int i = 0; i < 100; i++) {
            //lambda 针对只有一个方法的
            new Thread(() -> {
                System.out.println(Test07.INSTANCE.hashCode());
            }).start();
        }
    }
}
