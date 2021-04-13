package com.shantom.solutions.backtrack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution90 {
    public static void main(String[] args) {
        int[] nums = new int[]{4,4,4,1,4};

        List<List<Integer>> res = new Solution90().subsetsWithDup(nums);
        System.out.println(res);
    }

    private int[] nums;
    List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        this.nums = nums;
        List<Integer> cur = new ArrayList<>();
        res.add(cur);
        backtrack(cur, 0);
        return res;
    }

    private void backtrack(List<Integer> cur, int i) {
        int prev = 0;
        for(int j = i; j<nums.length; j++){
            if(j!=i && nums[j] == prev){
                continue;
            }
            cur.add(nums[j]);
            res.add(new ArrayList<>(cur));
            backtrack(cur, j+1);
            cur.remove(cur.size()-1);
            prev = nums[j];
        }
    }
}
