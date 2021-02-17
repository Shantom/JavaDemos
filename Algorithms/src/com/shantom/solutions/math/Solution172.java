package com.shantom.solutions.math;

public class Solution172 {
    public static void main(String[] args) {
        int res = new Solution172().trailingZeroes(9114137737819426770L);
        int res1 = new Solution172().trailingZeroes1(9114137737819426770L);
        System.out.println(res);
        System.out.println(res1);
    }

    public int trailingZeroes1(long n) {
        //5的个数
        int res = 0;
        long five = n;
        while(five>0){
            res += n/five;
            five/=5;
        }

        return res;
    }

    int trailingZeroes(long n) {
        int res = 0;
        for (long d = n; d / 5 > 0; d = d / 5) {
            res += d / 5;
        }
        return res;
    }
}
