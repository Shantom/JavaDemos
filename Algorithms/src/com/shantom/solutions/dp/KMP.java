package com.shantom.solutions.dp;

import java.util.*;

public class KMP {
    public static void main(String[] args) {
        String text = "CABAABABAC";
        String pattern = "ABAB";

        int res = new KMP().setPattern(pattern).search(text);
        System.out.println(res);

        List<Integer> list = new ArrayList<>();
        Set<Integer> set = new HashSet<>(list);
        ArrayList<Integer> integers = new ArrayList<>(set);
    }


    private int[][] dp;
    private String pattern;

    public KMP setPattern(String pattern){
        this.pattern = pattern;
        dp = new int[pattern.length()][256];
        int X = 0;
        dp[0][pattern.charAt(0)] = 1;
        for (int j = 1; j < pattern.length(); j++) {
            for (int c = 0; c < 256; c++) {
                dp[j][c] = dp[X][c];
            }
            dp[j][pattern.charAt(j)] = j+1;
            X = dp[X][pattern.charAt(j)];
        }
        return this;
    }

    public int search(String text){
        int j = 0;
        for (int i = 0; i < text.length(); i++) {
            j = dp[j][text.charAt(i)];
            if(j==pattern.length()){
                return i-pattern.length()+1;
            }
        }
        return -1;
    }
}
