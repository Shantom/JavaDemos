package com.shantom.solutions.bisearch;

import java.util.Arrays;

class Solution5678 {
    public static void main(String[] args) {
        int[] nums = {9};
        int maxOperations = 2;
        int res = new Solution5678().minimumSize(nums, maxOperations);
        System.out.println(res);
    }

    public int minimumSize(int[] nums, int maxOperations) {
        int m = getMax(nums);

        int left = 1;
        int right = m-1;
        while(left<=right){
            int mid = (left+right)>>>1;
            if(check(nums, mid, maxOperations)){
                right = mid-1;
            }else {
                left = mid+1;
            }
        }

        return left;
    }

    private boolean check(int[] nums, int cost, int ops){
        for(int num:nums){
            ops-=num/cost;
            if(num%cost==0){
                ops++;
            }
        }
        return ops>=0;
    }

    private int getMax(int[] nums){
        return Arrays.stream(nums).max().getAsInt();
    }
}
