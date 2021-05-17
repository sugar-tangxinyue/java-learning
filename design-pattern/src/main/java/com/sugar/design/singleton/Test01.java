package com.sugar.design.singleton;

/**
 * 饿汉模式
 * 类加载到内存后，就实例化一个单例，JVM保证现场安全
 * 简单实用
 * 缺点：不管用与不用，类装载时就完成实例化
 * JVM保证每个类只会load到内存一次
 */
public class Test01 {
    private static final Test01 INSTANCE=new Test01();
    private Test01(){

    }
    public static Test01 getInstance(){
        return INSTANCE;
    }

    public static void main(String[] args) {
        Test01 test01=Test01.getInstance();
        Test01 test02=Test01.getInstance();
        System.out.println(test01==test02);
    }
}
