package com.shantom.sort;

import java.util.Arrays;

public class QuickSort {

    public static void main(String[] args) {
        int[] nums = new int[]{6,3,7,9,5,4,12,8,9,5,3};
        System.out.println(Arrays.toString(nums));
        new QuickSort().sort(nums, 0, nums.length);
        System.out.println("=====排序后=====");
        System.out.println(Arrays.toString(nums));
    }

    public void sort(int[] nums, int l, int r){
        if(l>=r){
            return;
        }
        int m = l;
        int s = nums[l]; // 锚点

        for (int i = l+1; i < r; i++) {
            if(nums[i] < s){
                m+=1;
                swap(nums, m, i);
            }
        }
        swap(nums, m, l);
        sort(nums, l, m);
        sort(nums, m+1, r);
    }

    private void swap(int[] nums, int x, int y){
        int t = nums[x];
        nums[x] = nums[y];
        nums[y] = t;
    }
}
