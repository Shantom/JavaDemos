package com.shantom.solutions.dp.backpack;

import java.util.Arrays;

public class Solution494 {
    public static void main(String[] args) {
        int[] nums = {0,0,0,0,1};
        int S = 1;
        int res = new Solution494().findTargetSumWays(nums, S);
        System.out.println(res);
    }

    public int findTargetSumWays(int[] nums, int S) {
        if(S>Arrays.stream(nums).sum()){
            return 0;
        }

        int targetD = (S+ Arrays.stream(nums).sum());
        if(targetD%2==1){
            return 0;
        }

        int target = targetD/2;
        int[] dp = new int[target+1];
        dp[0] = 1;

        for(int i = 0; i < nums.length; i++){
            for(int t = target; t >= 0; t--){
                if(t>=nums[i]){
                    dp[t] += dp[t-nums[i]];
                }
            }
        }
        return dp[target];
    }
}
