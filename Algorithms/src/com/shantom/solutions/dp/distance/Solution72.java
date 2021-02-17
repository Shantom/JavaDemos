package com.shantom.solutions.dp.distance;

import java.util.Arrays;

public class Solution72 {
    public static void main(String[] args) {
        String word1 = "a";
        String word2 = "";
        int res = new Solution72().minDistance(word1, word2);
        System.out.println(res);

    }

    public int minDistance(String word1, String word2) {
        int I = word1.length();
        int J = word2.length();

        int[][] dp = new int[J+1][I+1];
        for (int i = 0; i < I+1; i++) {
            dp[0][i] = i;
        }
        for (int j = 0; j < J+1; j++) {
            dp[j][0] = j;
        }
        for (int i = 0; i < I; i++) {
            for (int j = 0; j < J; j++) {
                if (word1.charAt(i) == word2.charAt(j)) {
                    dp[j + 1][i + 1] = dp[j][i];
                } else {
                    dp[j + 1][i + 1] = 1 + Arrays.stream(new int[]{dp[j][i], dp[j][i + 1], dp[j + 1][i]}).min().getAsInt();
                }
            }
        }
        return dp[J][I];
    }
}
