package com.shantom.solutions.twosum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution1 {
    public static void main(String[] args) {
        int[] nums = new int[]{3,2,4,7,8,-1,-1};
        int target = 6;

        List<List<Integer>> res = new Solution1().twoSumVal(nums,0, target);
        System.out.println(res);
    }

    /**
     * 需要的是下标，所以不能排序了
     * @param nums
     * @param target
     * @return
     */
    public int[] twoSum(int[] nums, int target) {
        return new int[]{-1,-1};
    }

    /**
     * 需要值的twosum问题，使用排序和双指针
     * @param nums
     * @param target
     * @return
     */
    public List<List<Integer>> twoSumVal(int[] nums, int start, int target) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        int left = start;
        int right = nums.length-1;

        while(left<right){
            int lval = nums[left];
            int rval = nums[right];
            if(lval+rval < target){
                while(left<right && nums[left]==lval){
                    left++;
                }
            }else if(lval+rval > target){
                while(left<right && nums[right]==rval){
                    right--;
                }
            }else {
                List<Integer> item = new ArrayList<>();
                item.add(lval);
                item.add(rval);
                res.add(item);
                while(left<right && nums[left]==lval){
                    left++;
                }
                while(left<right && nums[right]==rval){
                    right--;
                }
            }
        }
        return res;
    }
}
