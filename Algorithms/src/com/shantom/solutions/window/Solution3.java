package com.shantom.solutions.window;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Solution3 {
    public static void main(String[] args) {
        String s = "";
        int res = new Solution3().lengthOfLongestSubstring(s);
        System.out.println(res);
    }


    public int lengthOfLongestSubstring(String s) {
        int left = 0;
        int right = 0;
        Map<Character, Integer> chars = new HashMap<>();
        int res = 0;
        int valid = 0;
        while(right<s.length()){
            // 增加右一次
            char ch = s.charAt(right);
            chars.put(ch, chars.getOrDefault(ch, 0)+1);
            right++;
            valid++;
            // 增加左直到重复的不重复，重复的只可能是窗口最右端的
            while(chars.get(ch)>1){
                char lch = s.charAt(left);
                chars.put(lch, chars.get(lch)-1);
                left++;
                valid--;
            }
            res = Math.max(valid, res);
        }
        return res;
    }
}
