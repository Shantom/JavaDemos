package com.shantom.solutions.linkedlist;

import com.shantom.structures.linked.LinkedListUtils;
import com.shantom.structures.linked.ListNode;

public class Solution148 {
    public static void main(String[] args) throws LinkedListUtils.CycledLinkedException {
        ListNode head = LinkedListUtils.constructList(new Integer[]{6,3,7,9,5,4,12,8,9,5,3});
        new Solution148().sortList(head);
        LinkedListUtils.printList(head);
    }

    public ListNode sortList(ListNode head) {
        sort(head, null);
        return head;
    }

    private void sort(ListNode head, ListNode tail){
        if(head==tail || tail==head.next ){
            return ;
        }
        int s = head.val;
        ListNode m = head;
        ListNode node = head.next;
        while(node!=tail){
            if(node.val<s){
                m = m.next;
                int t = node.val;
                node.val = m.val;
                m.val = t;
            }
            node = node.next;
        }
        int t = head.val;
        head.val = m.val;
        m.val = t;
        sort(head, m);
        sort(m.next, tail);
    }
}
