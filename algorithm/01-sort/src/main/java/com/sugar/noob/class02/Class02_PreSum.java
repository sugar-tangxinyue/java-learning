package com.sugar.noob.class02;

public class Class02_PreSum {
    private static int[] arrH;
    private static int[][] arrHh;

    public static void main(String[] args) {
        int[] arr = {4,5,6,7,1,2,4,5};
        setHarry(arr);
        setHarry2(arr);
        System.out.println(rangeSum(1, 6));
        System.out.println(rangeSum2(1, 6));
    }

    private static int rangeSum(int L, int R) {
        return L == 0 ? arrH[R] : arrH[R] - arrH[L - 1];
    }

    private static int rangeSum2(int L, int R) {
        return arrHh[L][R];

    }

    private static void setHarry(int[] arr) {
        int length = arr.length;
        arrH = new int[length];
        int ans = 0;
        for (int i = 0; i < length; i++) {
            ans += arr[i];
            arrH[i] = ans;
        }
    }


    private static void setHarry2(int[] arr) {
        int length = arr.length;
        arrHh = new int[length][length];
        for (int i = 0; i < length; i++) {
            arrHh[i][i] = arr[i];
            int ans = arr[i];
            for (int f = i + 1; f < length; f++) {
                ans += arr[f];
                arrHh[i][f] = ans;
            }
        }
    }
}
