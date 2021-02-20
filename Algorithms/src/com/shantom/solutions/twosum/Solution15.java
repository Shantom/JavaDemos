package com.shantom.solutions.twosum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution15 {
    public static void main(String[] args) {
        int[] nums = new int[]{-2,0,0,2,2};
        List<List<Integer>> res = new Solution15().threeSum(nums);
        System.out.println(res);
    }

    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        for(int i = 0; i<nums.length; i++){
            List<List<Integer>> ints = new Solution1().twoSumVal(nums, i+1, -nums[i]);
            for (List<Integer> list : ints) {
                list.add(nums[i]);
            }
            res.addAll(ints);
            while(i<nums.length-1 && nums[i]==nums[i+1]){
                i++;
            }
        }

        return res;
    }
}
