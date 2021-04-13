package com.shantom.solutions.subset;

import java.util.ArrayList;
import java.util.List;

public class Solution78 {
    public static void main(String[] args) {
        int[] nums = new int[]{1,2,2};
        List<List<Integer>> res = new Solution78().subsets(nums);
        System.out.println(res);
    }

    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        res.add(new ArrayList<>());

        for(int num: nums){
            int size = res.size();
            for (int i = 0; i < size; i++) {
                List<Integer> ele = new ArrayList<>(res.get(i));
                ele.add(num);
                res.add(ele);
            }
        }
        return res;
    }
}
