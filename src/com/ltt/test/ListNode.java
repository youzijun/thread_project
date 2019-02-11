package com.ltt.test;

/**
 * Created by ZJX-BJ-01-00057 on 2019/1/21.
 */
public class ListNode {
      int val;
      ListNode next;
      ListNode(int x) { val = x; }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        ListNode head1 = new ListNode(2);
        ListNode head2 = new ListNode(3);
        ListNode head3 = new ListNode(4);
        ListNode head4 = new ListNode(5);
//        ListNode head5 = new ListNode(6);

        head.next = head1;
        head1.next = head2;
        head2.next = head3;
        head3.next = head4;
//        head4.next = head5;

//        Solution.reverseList(head);
        Solution1.reverseList(head);
    }
}

class Solution {
    public static ListNode reverseList(ListNode head) {
        ListNode cur = head;
        ListNode prev = null;
        while(cur != null){
            ListNode next = cur.next;
            cur.next = prev;
            prev = cur;
            cur = next;
        }
        return prev;
    }
}

class Solution1 {
    public static ListNode reverseList(ListNode head) {
        ListNode result = new ListNode(0);
        result.next = head;
        ListNode prev = result;
        while(prev.next != null && prev.next.next != null){
            ListNode node1 = prev.next;
            ListNode node2 = prev.next.next;
            prev.next = node2;
            node1.next = node2.next;
            node2.next = node1;
            prev = prev.next.next;
        }
        return result.next;
    }
}


