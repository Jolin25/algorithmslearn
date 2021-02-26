package top.algorithms.learn.link;

import java.util.LinkedList;

/**
 * @Author:jrl
 * @Date:Create in 11:19 2021-2-26
 * @Description: 学习链表，练习判断回文
 */
public class Palindrome {
    /**
     * 单向链表
     */
    class Node {
        Character c;
        Node next;

        public Node(Character c, Node next) {
            this.c = c;
            this.next = next;
        }
    }

    /**
     * 快慢两个指针，慢指针用于翻转前半段，快指针用于控制流程
     */
    boolean checkIsPalindrome(LinkedList<Node> linkedList) {
        if (linkedList.size() < 1) {
            return false;
        }
        Node slow = linkedList.get(0);
        Node fast = linkedList.get(0);
        Node pre = null;
        /*翻转*/
        while (fast != null && fast.next != null && fast.next.next != null) {
            fast = fast.next.next;
            Node now = slow;
            Node next = slow.next;
            now.next = pre;
            slow = next;
            pre = now;
        }
        /*判断*/
        fast = pre;
        if (linkedList.size() % 2 != 0) {
            slow = slow.next;
        }
        while (slow != null) {
            if (!slow.c.equals(fast.c)) {
                return false;
            }
            slow = slow.next;
            fast = fast.next;
        }
        return true;
    }

    /**
     * 需要更改：
     * 1.我给判断方法的时候就不应该给LinkedList，应该给一个头指针
     */
    public static void main(String[] args) {
        Palindrome palindrome = new Palindrome();
        LinkedList<Node> linkedList = new LinkedList<>();
        Node a = palindrome.create('a', linkedList);
        linkedList.add(a);
        Node b = palindrome.create('b', linkedList);
        linkedList.add(b);
        Node c = palindrome.create('c', linkedList);
        linkedList.add(c);
        Node d = palindrome.create('b', linkedList);
        linkedList.add(d);
        Node e = palindrome.create('a', linkedList);
        linkedList.add(e);
        boolean b1 = palindrome.checkIsPalindrome(linkedList);
        System.out.println(b1);
    }

    Node create(Character c, LinkedList<Node> linkedList) {
        Node node = new Node(c, null);
        if (linkedList.size() > 0) {
            linkedList.get(linkedList.size() - 1).next = node;
        }
        return node;
    }
}
