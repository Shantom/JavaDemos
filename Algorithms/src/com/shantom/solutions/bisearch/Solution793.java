package com.shantom.solutions.bisearch;

public class Solution793 {
    public static void main(String[] args) {
        int K = 1000000000;
        int res = new Solution793().preimageSizeFZF(K);
        System.out.println(res);
    }

    public int preimageSizeFZF(int K) {
        long left = 0;
        long right = Long.MAX_VALUE;
        while(left<=right){
            long mid = (left+right)>>>1;
            if(f(mid)>=K){
                right = mid-1;
            }else{
                left = mid+1;
            }
        }
        long low = left;
        left = 0;
        right = Long.MAX_VALUE;
        while(left<=right){
            long mid = (left+right)>>>1;
            if(f(mid)<=K){
                left = mid+1;
            }else{
                right = mid-1;
            }
        }
        long high = left;
        return (int) (high-low);
    }

    private int f(long x){
        int res = 0;
        long five = x;
        while(five>0){
            res+=x/five;
            five/=5;
        }
        return res;
    }
}
