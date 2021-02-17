package com.shantom.solutions.backtrack;

import java.util.ArrayList;
import java.util.List;

public class Solution22 {
    private List<String> res = new ArrayList<>();

    public static void main(String[] args) {
        System.out.println(new Solution22().generateParenthesis(3));
    }

    public List<String> generateParenthesis(int n) {
        bt(new StringBuilder(), 0, n);
        return res;
    }

    private void bt(StringBuilder str, int ls, int rest){
        if(ls==0 && rest==0){
            res.add(str.toString());
        }
        // 加左
        if(rest>0) {
            str.append("(");
            bt(str, ls + 1, rest - 1);
            str.deleteCharAt(str.length() - 1);
        }
        // 加右
        if(ls>0) {
            str.append(")");
            bt(str, ls - 1, rest);
            str.deleteCharAt(str.length() - 1);
        }
    }
}
