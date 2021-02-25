package com.shantom.sort;

import java.util.Arrays;
import java.util.Stack;

public class MergeSort {
    public static void main(String[] args) {
        int[] nums = new int[]{6,3,7,9,5,4,12,8,9,5,3};
        MergeSort.sort(nums, 0 , nums.length-1);
        System.out.println(Arrays.toString(nums));
    }

    /**
     * 右闭
     * @param nums
     * @param left
     * @param right
     */
    public static void sort(int[] nums, int left, int right){
        if(right-left != 0){
            int mid = (left + right) >>> 1;
            sort(nums, left, mid);
            sort(nums, mid+1, right);
            merge(nums, left, mid, mid+1, right);
        }
    }

    private static void merge(int[] nums, int left, int leftEnd, int right, int rightEnd){
        int l = left;
        int length = rightEnd - left + 1;
        int[] temp = new int[length];
        int i = 0;
        while(left<=leftEnd && right<=rightEnd){
            if(nums[left]<=nums[right]){
                temp[i++] = nums[left++];
            }else {
                temp[i++] = nums[right++];
            }
        }
        while(left<=leftEnd){
            temp[i++] = nums[left++];
        }
        while(right<=rightEnd){
            temp[i++] = nums[right++];
        }
        for (int j = 0; j < temp.length; j++) {
            nums[l+j] = temp[j];
        }
    }
}
