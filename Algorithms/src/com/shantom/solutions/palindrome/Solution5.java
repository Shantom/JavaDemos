package com.shantom.solutions.palindrome;

public class Solution5 {

    public static void main(String[] args) {
        String res = new Solution5().longestPalindrome("babad");
        System.out.println(res);
    }

    /**
     * Manacher
     * @param s
     * @return
     */
    public String longestPalindrome(String s) {
        String str = preProcess(s);
        int[] p = new int[str.length()];
        int right = 1;
        int centre = 1;
        String res = "";
        for (int i = 1; i < str.length()-1; i++) {
            if(i<right){
                int mirror = 2*centre - i;
                if(i+p[mirror] < right){
                    p[i] = p[mirror];
                    continue;
                }else {
                    p[i] = right - i;
                }
            }

            int left = i - p[i];
            while (str.charAt(left-1) == str.charAt(right+1)){
                left--;
                right++;
                p[i]++;
                centre = i;
            }
            if(res.length()< right-left+1){
                res = str.substring(left, right+1);
            }
        }
        res = res.replace("#", "");
        return res;
    }

    private String preProcess(String s){
        StringBuilder sb = new StringBuilder();
        sb.append("^#");
        for (int i = 0; i < s.length(); i++) {
            sb.append(s.charAt(i));
            sb.append("#");
        }
        sb.append("$");
        return sb.toString();
    }
}
