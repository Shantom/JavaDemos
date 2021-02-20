package com.shantom.solutions.window;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution438 {
    public static void main(String[] args) {
        String s = "baa";
        String p = "aa";
        List<Integer> res = new Solution438().findAnagrams(s, p);
        System.out.println(res);
    }

    public List<Integer> findAnagrams(String s, String p) {
        int left = 0;
        int right = 0;
        int valid = 0;

        Map<Character, Integer> need = getNeed(p);
        Map<Character, Integer> window = new HashMap<>();
        List<Integer> res = new ArrayList<>();

        while(right<s.length()){
            char rch = s.charAt(right);
            if(need.containsKey(rch)){
                window.put(rch, window.getOrDefault(rch, 0)+1);
                if(window.get(rch).equals(need.get(rch))){
                    valid++;
                }
            }
            right++;
            if(right-left == p.length()){
                if(valid==need.size()){
                    res.add(left);
                }
                char lch = s.charAt(left);
                if(need.containsKey(lch)){
                    if(window.get(lch).equals(need.get(lch))){
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
