package top.algorithms.learn.code;

import java.util.Arrays;
import java.util.Hashtable;

class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();

        ListNode d = new ListNode(1, null);
        ListNode c = new ListNode(2, d);
        ListNode b = new ListNode(2, c);
        ListNode a = new ListNode(1, b);

        // ListNode c2 = new ListNode(4, null);
        // ListNode b2 = new ListNode(3, c2);
        // ListNode a2 = new ListNode(2, b2);
        System.out.println(solution.isPalindrome(a));
    }

    public static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    public boolean isPalindrome(ListNode head) {
        if (head == null) {
            return true;
        }
        ListNode tail = head;
        int n = 1;
        while (tail.next != null) {
            tail = tail.next;
            n++;
        }
        n = n / 2;
        tail = head;
        while (n > 0) {
            tail = tail.next;
            n--;
        }
        ListNode p = null;
        while (tail != null) {
            ListNode tmp = tail.next;
            tail.next = p;
            p = tail;
            tail = tmp;
        }
        tail = p;
        while (head.next != null) {
            if (head.val == tail.val) {
                head = head.next;
                tail = tail.next;
            } else {
                return false;
            }
        }
        return true;
    }


}