package com.shantom.solutions.window;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class Solution76 {
    public static void main(String[] args) {
        String s = "ADOBECODEBANC";
        String t = "ABC";
        String res = new Solution76().minWindow(s, t);
        System.out.println(res);
    }

    public String minWindow(String s, String t) {
        int left = 0;
        int right = 0;

        Map<Character, Integer> need = getNeed(t);
        Map<Character, Integer> window = new HashMap<>();
        int valid = 0;
        String res = "";
        int len = s.length()+1;
        while(right<s.length()){
            char rch = s.charAt(right);
            if(need.containsKey(rch)){
                window.put(rch, window.getOrDefault(rch, 0)+1);
                if(window.get(rch).equals(need.get(rch))) {
                    valid++;
                }
            }
            right++;
            while(valid==need.size()){
                String cur = s.substring(left, right);
                if(cur.length()<len){
                    res = cur;
                    len = cur.length();
                }
                char lch = s.charAt(left);
                if(need.containsKey(lch)){
                    if(window.get(lch).equals(need.get(lch))) {
                        valid--;
                    }
                    window.put(lch, window.get(lch)-1);
                }
                left++;
            }
        }
        return res;
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
