package com.shantom.solutions.palindrome;

import com.shantom.structures.linked.LinkedListUtils;
import com.shantom.structures.linked.ListNode;

public class Solution234 {
    public static void main(String[] args) {
        ListNode head = LinkedListUtils.constructList(new Integer[]{});
        boolean res = new Solution234().isPalindrome(head);
        System.out.println(res);
    }

    private ListNode rev;
    public boolean isPalindrome(ListNode head) {
        rev = head;
        return traverse(head);
    }

    private boolean traverse(ListNode node){
        if(node==null){
            return true;
        }

        boolean res = traverse(node.next);
        if(res && rev.val==node.val){
            rev = rev.next;
            return true;
        }else {
            return false;
        }
    }
}
