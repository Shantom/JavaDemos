package com.shantom.solutions.linkedlist;

import com.shantom.structures.linked.ListNode;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Solution23 {
    public static void main(String[] args) {

    }

    PriorityQueue<Integer> queue;
    ListNode[] lists;

    public ListNode mergeKLists(ListNode[] lists) {
        this.lists = lists;
        queue = new PriorityQueue<>(Comparator.comparingInt(a -> this.lists[a].val));
        for (int i = 0; i < lists.length; i++) {
            if(lists[i] != null){
                queue.add(i);
            }
        }
        return merge();
    }

    private ListNode merge(){
        if(queue.isEmpty()){
            return null;
        }
        int ihead = queue.poll();
        ListNode head = lists[ihead];
        lists[ihead] = lists[ihead].next;
        if(lists[ihead] != null){
            queue.add(ihead);
        }

        head.next = merge();
        return head;
    }
}
