package com.sugar.design.singleton;

/**
 * 静态内部类方式
 * JVM保证单例
 * 加载外部类时不会加载内部类，可以实现懒加载
 */
public class Test06 {

    private Test06() {

    }

    private static class Test06Holder {
        private final static Test06 INSTANCE = new Test06();
    }

    public static Test06 getInstance() {
        return Test06Holder.INSTANCE;
    }

    public static void main(String[] args) {
        for (int i = 0; i < 100; i++) {
            //lambda 针对只有一个方法的
            new Thread(() -> {
                System.out.println(Test06.getInstance().hashCode());
            }).start();
        }
    }
}
