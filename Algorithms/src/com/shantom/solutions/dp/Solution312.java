package com.shantom.solutions.dp;

public class Solution312 {
    public static void main(String[] args) {
        int[] nums = {3,1,5,8};
        int res = new Solution312().maxCoins(nums);
        System.out.println(res);

    }


    public int maxCoins(int[] nums) {
        int[] data = new int[nums.length+2];
        data[0] = 1;
        data[data.length-1] = 1;
        for(int i = 0;i<nums.length;i++){
            data[i+1] = nums[i];
        }
        int n = nums.length;
        int[][]dp = new int[n+1][n+2];

        for(int b = 2; b <= n+1; b++){
            for(int a = b-2; a >= 0; a--){
                for(int k = a+1; k<=b-1;k++){
                    dp[a][b] = Math.max(data[a]*data[b]*data[k]+dp[a][k]+dp[k][b], dp[a][b]);
                }
            }
        }
        return dp[0][n+1];
    }
}
