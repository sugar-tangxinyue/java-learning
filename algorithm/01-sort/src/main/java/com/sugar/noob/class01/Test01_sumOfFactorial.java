package com.sugar.noob.class01;

/**
 * 阶层相加 1!+2!+3!...+N!
 */
public class Test01_sumOfFactorial {

    public static void main(String[] args) {

        int n = 5;
        System.out.println(f1(n));
        System.out.println(f2(n));
    }

    private static long f1(int n) {
        long ans = 0;
        for (int i = 1; i <= n; i++) {
            ans += factorial(i);
        }
        return ans;
    }

    private static long factorial(int n) {
        long ans = 1;
        for (int i = 1; i <= n; i++) {
            ans *= i;
        }
        return ans;
    }

    private static long f2(int n) {
        long ans = 0;
        long lastAns = 1;
        for (int i = 1; i <= n; i++) {
            lastAns *= i;
            ans += lastAns;
        }
        return ans;
    }
}
