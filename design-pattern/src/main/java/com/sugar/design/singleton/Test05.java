package com.sugar.design.singleton;

/**
 * 懒加载（lazy loading）
 * 虽然带来了按需初始化的目的，但却带来线程不安全的问题
 * synchronized解决，但是会带来效率下降
 *
 */
public class Test05 {
    private static volatile Test05 INSTANCE; //JIT 指令重排？？？

    private Test05() {

    }


    public static synchronized Test05 getInstance() {
        if (null == INSTANCE) {
            synchronized (Test05.class) {
                if (null == INSTANCE) {
                    //多线程测试，展现线程不安全的问题
                    try {
                        Thread.sleep(1);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    INSTANCE = new Test05();
                }
            }
        }
        return INSTANCE;
    }

    public static void main(String[] args) {
   /*     Test02 test01 = Test02.getInstance();
        Test02 test02 = Test02.getInstance();
        System.out.println(test01 == test02);*/
        for (int i = 0; i < 100; i++) {
            //lambda 针对只有一个方法的
            new Thread(() -> {
                System.out.println(Test05.getInstance().hashCode());
            }).start();
        }
    }
}
