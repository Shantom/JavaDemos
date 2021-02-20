package com.shantom.solutions.linkedlist;

import com.shantom.structures.linked.LinkedListUtils;
import com.shantom.structures.linked.ListNode;

public class Solution92 {

    public static void main(String[] args) throws LinkedListUtils.CycledLinkedException {
        Integer[] nums = {1,2,3,4,5};
        ListNode head = LinkedListUtils.constructList(nums);
        int k = 4;
        int m = 2;
        int n = 4;
        ListNode node = new Solution92().reverseBetween(head, m, n);
        LinkedListUtils.printList(node);
    }

    /**
     *
     * @param head
     * @param m
     * @param n
     * @return 返回反转后的head
     */
    public ListNode reverseBetween(ListNode head, int m, int n){
        if(m==1){
            return reverseUntil(head, n);
        }
        head.next = reverseBetween(head.next, m - 1, n - 1);
        return head;
    }

    /**
     * @param head
     * @param k 反转前k
     * @return 返回反转后的head
     */
    public ListNode reverseUntil(ListNode head, int k){
        if(k==1){
            return head;
        }
        ListNode last = reverseUntil(head.next, k-1);
        ListNode successor = head.next.next;
        head.next.next = head;
        head.next = successor;
        return last;
    }
}
