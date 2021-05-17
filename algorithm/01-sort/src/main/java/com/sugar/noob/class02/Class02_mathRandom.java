package com.sugar.noob.class02;

public class Class02_mathRandom {
    public static void main(String[] args) {
        //Math.random()->double->[0,1) 等概率出现
        double random = Math.random();
        System.out.println(random);

        int testTimes = 10000;
        int K = 10;
        int[] counts = new int[10];
        for (int i = 0; i < testTimes; i++) {
            int ans = (int) (Math.random() * K);
            counts[ans]++;
        }
        for (int i = 0; i < K; i++) {
            System.out.println(i + " 这个数，出现了" + counts[i] + " 次 ");
        }
        System.out.println("================");

        int count=0;
        double x=0.3;
        for (int i = 0; i < testTimes; i++) {
            if(xToXPower2()<x){
                count++;
            }
        }
        System.out.println(((double) count / (double) testTimes));
        System.out.println(Math.pow(x,2));
    }

    /**
     * math.random()数据呈现指数型分布
     * 返回[0,1)的一个小数
     * 在任意的x,x属于[0,1)，[0,x)范围上的数出现概率由原来的x调整为x的平方
     * @return
     */
    public static double xToXPower2() {
        return Math.max(Math.random(), Math.random());
    }
}
