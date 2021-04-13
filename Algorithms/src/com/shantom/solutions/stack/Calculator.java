package com.shantom.solutions.stack;

import java.util.Deque;
import java.util.LinkedList;

public class Calculator {
    public static void main(String[] args) {
        String s = "(1+(4+5+2)-3)+(6+8)";
        System.out.println(new Calculator().calculate(s));
    }

    private int iter = 0;
    private String s;
    public int calculate(String s){
        this.s = s;
        return calSimple();
    }

    private int calSimple() {
        Deque<Integer> stack = new LinkedList<>();
        char sign = '+';
        int num = 0;
        while (iter < s.length()) {
            char ch = s.charAt(iter);
            if (Character.isDigit(ch)) {
                num = num * 10 + (ch - '0');
            }
            if(ch=='('){
                iter++;
                num = calSimple();
            }
            // 结束点
            if ((ch!=' ' && !Character.isDigit(ch)) || iter == s.length() - 1) {
                if (sign == '+') {
                    stack.push(num);
                } else if (sign == '-') {
                    stack.push(-num);
                } else if (sign == '*') {
                    int top = stack.pop();
                    stack.push(num * top);
                } else if (sign == '/') {
                    int top = stack.pop();
                    stack.push(top / num);
                }
                sign = ch;
                num = 0;
                if(ch==')'){
                    break;
                }
            }
            iter++;
        }
        return stack.stream().mapToInt(Integer::intValue).sum();
    }
}
