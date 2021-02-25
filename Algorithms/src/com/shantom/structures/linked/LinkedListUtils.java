package com.shantom.structures.linked;

public class LinkedListUtils {

    public static ListNode constructList(Integer[] nums) {
        if (nums.length == 0) {
            return null;
        }
        ListNode head = new ListNode();
        ListNode prev = head;
        for (Integer num : nums) {
            ListNode node = new ListNode(num);
            prev.next = node;
            prev = node;
        }
        return head.next;
    }

    public static void printList(ListNode node) throws CycledLinkedException {
        if (isCycled(node)) {
            throw new CycledLinkedException();
        }
        while (node != null) {
            System.out.print(node.val + "->");
            node = node.next;
        }
        System.out.println("null");
    }

    public static boolean isCycled(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next!=null && fast.next.next!=null) {
            slow = slow.next;
            fast = fast.next.next;
            if (fast == slow) {
                return true;
            }
        }
        return false;
    }

    public static class CycledLinkedException extends Exception {
    }
}
