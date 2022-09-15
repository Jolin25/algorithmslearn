package top.algorithms.learn.structure.basic.link;

class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();

        ListNode k = new ListNode(11, null);
        ListNode j = new ListNode(10, k);
        ListNode i = new ListNode(9, j);
        ListNode h = new ListNode(8, i);
        ListNode g = new ListNode(7, h);
        ListNode f = new ListNode(6, g);
        ListNode e = new ListNode(5, f);
        ListNode d = new ListNode(4, e);
        ListNode c = new ListNode(3, d);
        ListNode b = new ListNode(2, c);
        ListNode a = new ListNode(1, b);
        solution.reverseKGroup(a, 11);
        // ListNode c2 = new ListNode(4, null);
        // ListNode b2 = new ListNode(3, c2);
        // ListNode a2 = new ListNode(2, b2);
        System.out.println();
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

    public void reverseKGroup(ListNode head, int k) {
        Integer f1 = 100,f2 = 100,f3 = 150,f4 = 150;
        System.out.println(f1==f2);
        System.out.println(f3==f4);
    }

}