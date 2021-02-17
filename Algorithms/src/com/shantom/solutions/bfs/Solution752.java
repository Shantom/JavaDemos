package com.shantom.solutions.bfs;

import java.util.*;

public class Solution752 {
    public static void main(String[] args) {
        String[] deadends = {"0000"};
        String target = "0009";
        int res = new Solution752().openLock(deadends, target);
        System.out.println(res);
    }

    public int openLock(String[] deadends, String target) {
        if(new ArrayList<>(Arrays.asList(deadends)).contains("0000")){
            return -1;
        }
        if("0000".equals(target)){
            return 0;
        }

        Set<String> visited = new HashSet<>(Arrays.asList(deadends));
        StringBuilder start = new StringBuilder("0000");
        Queue<String> queue = new LinkedList<>();
        queue.add(start.toString());
        int res = 1;
        while(!queue.isEmpty()){
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                StringBuilder cur = new StringBuilder(queue.poll());
                for (int j = 0; j < 4; j++) {
                    char c = cur.charAt(j);
                    cur.setCharAt(j, minus(c));
                    if(cur.toString().equals(target)){
                        return res;
                    }
                    if(!visited.contains(cur.toString())) {
                        queue.offer(cur.toString());
                        visited.add(cur.toString());
                    }
                    cur.setCharAt(j, plus(c));
                    if(cur.toString().equals(target)){
                        return res;
                    }
                    if(!visited.contains(cur.toString())) {
                        queue.offer(cur.toString());
                        visited.add(cur.toString());
                    }
                    cur.setCharAt(j, c);
                }
            }
            res++;
        }
        return -1;
    }

    private char minus(char ch){
        int num = ch-'0';
        return (char) ('0'+(num+9)%10);
    }

    private char plus(char ch){
        int num = ch-'0';
        return (char) ('0'+(num+11)%10);
    }
}
