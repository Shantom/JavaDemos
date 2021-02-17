package com.shantom.solutions.bisearch;

import java.util.Arrays;

public class Solution1011 {
    public static void main(String[] args) {
        int[] weights = {1,2,3,4,5,6,7,8,9,10};
        int D = 5;
        int res = new Solution1011().shipWithinDays(weights, D);
        System.out.println(res);
    }

    public int shipWithinDays(int[] weights, int D) {
        int left = Arrays.stream(weights).max().getAsInt();
        int right = Arrays.stream(weights).sum();
        while(left<=right){
            int mid = (left+right)>>>1;
            if(check(weights, D, mid)){
                right = mid-1;
            }else {
                left = mid+1;
            }
        }
        return left;
    }

    public boolean check(int[] weights, int D, int cap){
        int cur = 0;
        for (int weight : weights) {
            if(cur+weight<=cap){
                cur+=weight;
            }else{
                D--;
                cur = weight;
            }
        }
        D--;
        return D>=0;
    }
}
