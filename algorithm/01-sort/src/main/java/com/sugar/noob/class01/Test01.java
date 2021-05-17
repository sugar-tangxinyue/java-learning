package com.sugar.noob.class01;

/**
 * 打印整数类型的32位源码
 * 原码：计算机中一种对数字的二进制定点表示方法。
 * 原码表示法在数值前面前面有一位符号位（即最高位为符号位），正数该位为0，负数该位为1（0有两种表示：+0和-0），其余位表示数值的大小。
 * <p>
 * 反码：正数的反码与其原码相同；负数的反码是对其原码逐位取反，但符号位除外。
 * <p>
 * 补码：正数和+0的补码是其原码；负数则先计算其反码，然后反码加上1
 * <p>
 * 正数的原码，补码，反码 相同，  正数用原码表示，负数用补码表示
 * <p>
 * 计算机储存数据使用补码而不是用原码
 */
public class Test01 {
    public static void main(String[] args) {
        //32位
//        int num = 83928328;
//        print(num);
//
//        print(-1);
//        int a = 1024;
//        print(a);
//        print(a >> 1);
//        print(a >>> 1);
//        System.out.println("+++++++++++++++++++++");
//        a=Integer.MIN_VALUE;
//        //带符号右移
//        print(a >> 1);
//        //不带符号右移
//        print(a >>> 1);

//        int c=5;
//        int d=-5;
//        print(c);
//        print(d);
//        d=~c+1;
//        print(d);

        //系统最小值的取反+1是他本身
        int c = Integer.MIN_VALUE;
        int d = -c;
        print(c);
        print(d);
    }

    //实现整数的32位打印
    private static void print(int num) {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 31; i >= 0; i--) {
            //左移不存在带符号移动；右移存在带符号移动
            stringBuilder.append((num & (1 << i)) == 0 ? "0" : "1");
        }
        System.out.println(stringBuilder.toString());
    }
}
