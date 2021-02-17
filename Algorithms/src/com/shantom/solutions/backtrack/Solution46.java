package com.shantom.solutions.backtrack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

class Solution46 {
    private List<List<Integer>> res = new ArrayList<>();
    private List<Integer> nums;


    public List<List<Integer>> permute(int[] nums) {
        this.nums = Arrays.stream(nums).boxed().collect(Collectors.toList());
        bt(this.nums, new ArrayList<>());

        return res;
    }

    private void bt(List<Integer> rest, List<Integer> cur){
        if(rest.isEmpty()){
            res.add(cur);
        }
        for(int num: rest){
            cur.add(num);
            List<Integer> nRest = new ArrayList<>(rest);
            nRest.remove(Integer.valueOf(num));
            bt(nRest, cur);
            cur.remove(cur.size()-1);
        }
    }
}
