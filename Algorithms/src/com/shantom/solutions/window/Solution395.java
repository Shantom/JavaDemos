package com.shantom.solutions.window;

import java.util.HashMap;
import java.util.Map;

/**
 * 思路有些错误
 */
public class Solution395 {
    public static void main(String[] args) {
        String s = "ababbc";
        int k = 2;
        int res = new Solution395().longestSubstring(s, k);
        System.out.println(res);
    }

    public int longestSubstring(String s, int k) {
        Map<Character, Integer> need = getNeed(s);
        int res = 0;
        int m = need.size();
        for(int j = 1; j<=m; j++){
            Map<Character, Integer> window = new HashMap<>();
            int left = 0;
            int right = 0;
            int valid = 0;
            while(right<s.length()){
                char ch = s.charAt(right);
                window.put(ch, window.getOrDefault(ch, 0)+1);
                if(window.get(ch)==k){
                    valid++;
                }
                right++;
                while(valid == j){
                    res = Math.max(res, right-left);
                    char c = s.charAt(left);
                    left++;
                    if(window.get(c)==k){
                        valid--;
                    }
                    window.put(c, window.get(c)-1);
                }
            }
        }
        return res;
    }

    private Map<Character, Integer> getNeed(String s){
        Map<Character, Integer> need = new HashMap<>();
        for(int i = 0; i<s.length(); i++){
            char ch = s.charAt(i);
            need.put(ch, need.getOrDefault(ch, 0)+1);
        }
        return need;
    }

}
