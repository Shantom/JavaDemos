package com.shantom.solutions.window;

import java.util.HashMap;
import java.util.Map;

public class Solution567 {
    public static void main(String[] args) {
        String s1 = "ab";
        String s2 = "eidboaoo";
        boolean res = new Solution567().checkInclusion(s1, s2);
        System.out.println(res);
    }

    public boolean checkInclusion(String s1, String s2) {
        Map<Character, Integer> need = getNeed(s1);
        Map<Character, Integer> window = new HashMap<>();
        int left = 0;
        int right = 0;
        int valid = 0;

        while(right<s2.length()){
            char rch = s2.charAt(right);
            if(need.containsKey(rch)){
                window.put(rch, window.getOrDefault(rch, 0)+1);
                if(window.get(rch).equals(need.get(rch))){
                    valid++;
                }
            }
            right++;
            if(right-left==s1.length()){
                if(valid==need.size()){
                    return true;
                }
                char lch = s2.charAt(left);
                if(need.containsKey(lch)){
                    if(window.get(lch).equals(need.get(lch))){
                        valid--;
                    }
                    window.put(lch, window.get(lch)-1);
                }
                left++;
            }
        }
        return false;
    }

    private Map<Character, Integer> getNeed(String p){
        Map<Character, Integer> res = new HashMap<>();
        for (int i = 0; i < p.length(); i++) {
            char ch = p.charAt(i);
            res.put(ch, res.getOrDefault(ch, 0)+1);
        }
        return res;
    }

}
