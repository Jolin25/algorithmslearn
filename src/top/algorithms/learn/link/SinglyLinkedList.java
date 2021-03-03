package top.algorithms.learn.link;


import sun.rmi.runtime.NewThreadAction;

import java.util.LinkedList;

/**
 * 单链表：增、删、查找 设定数据类型为int
 * 增：insertTail；insertHead;insertAfter;insertBefore;
 * 删：deleteByNode；deleteByValue
 * 查：findByValue;findByIndex
 * <p>
 * head是第一个节点，不是头结点
 *
 * @author jrl
 * @date Create in 14:41 2021-3-1
 */
public class SinglyLinkedList {


    /**
     * 属性：头结点
     *
     * @date 2021-3-1
     **/
    private Node head = null;

    @Override
    public String toString() {
        StringBuffer sb = new StringBuffer("");
        Node p = head;
        while (p != null) {
            sb.append(p.data + ",");
            p = p.next;
        }
        return sb.toString();
    }

    /**
     * 节点Node
     *
     * @date 2021-3-1
     **/
    private static class Node {
        private int data;
        private Node next;

        public Node(int data) {
            this.data = data;
        }

        public Node(int data, Node next) {
            this.data = data;
            this.next = next;
        }

        public Node() {

        }
    }

    /**
     * Returns the element at the specified position in this list.
     *
     * @param index index of the element to return
     * @return the element at the specified position in this list
     * @date 2021-3-1
     */
    public Node findByIndex(int index) {
        Node p = head;
        int pos = 0;
        while (p != null && pos != index) {
            p = p.next;
            ++pos;
        }
        return p;
    }

    /**
     * Returns the element has the specified value in this list.
     *
     * @param value value of the element to return
     * @return the element has the specified value in this list
     * @date 2021-3-3
     */
    public Node findByValue(int value) {
        Node p = head;
        while (p != null && p.data != value) {
            p = p.next;
        }
        return p;
    }

    /**
     * 在单链表上插入一个节点：尾插
     *
     * @param value the element's value to be inserted
     * @date 2021-3-1
     **/
    public void insertTail(int value) {
        Node newNode = new Node(value);
        if (head == null) {
            head = new Node(value);
            return;
        }
        Node q = head;
        while (q.next != null) {
            q = q.next;
        }
        newNode.next = q.next;
        q.next = newNode;
    }

    /**
     * 在单链表上插入一个节点：头插
     *
     * @param value the value of element which to be inserted
     * @date 2021-3-3
     */
    public void insertToHead(int value) {
        Node newNode = new Node(value);
        this.insertToHead(newNode);
    }

    /**
     * @param newNode the element to be inserted
     * @date 2021-3-3
     */
    public void insertToHead(Node newNode) {
        if (head == null) {
            head = newNode;
            return;
        }
        newNode.next = head.next;
        head = newNode;
    }

    /**
     * 在指定节点前插入新节点
     *
     * @param value element's value to be inserted
     * @param node  the element which the element to be inserted before
     * @date 2021-3-1
     */
    public void insertBefore(Node node, int value) {
        Node newNode = new Node(value);
        this.insertBefore(node, newNode);
    }

    /**
     * 在指定节点前插入新节点
     *
     * @param node    the element which the element to be inserted before
     * @param newNode element to be inserted
     * @date 2021-3-1
     */
    public void insertBefore(Node node, Node newNode) {
        if (node == null) {
            return;
        }
        Node p = head;
        if (node == head) {
            newNode.next = head.next;
            head = newNode;
            return;
        }
        while (p != null && p.next != node) {
            p = p.next;
        }
        if (p == null) {
            return;
        }
        newNode.next = p.next;
        p.next = newNode;
    }

    /**
     * 在指定节点后插入新的节点
     *
     * @param node    the element which the element to be inserted after
     * @param newNode element to be inserted
     * @date 2021-3-3
     */
    public void insertAfter(Node node, Node newNode) {
        if (node == null) {
            return;
        }
        newNode.next = node;
        node.next = newNode;
    }

    /**
     * @param node  the element which to be inserted after
     * @param value the value of element to be inserted
     * @date 2021-3-3
     */
    public void insertAfter(Node node, int value) {
        Node newNode = new Node(value);
        this.insertAfter(node, newNode);
    }

    /**
     * 删除指定节点
     *
     * @param node the element to be deleted
     * @date 2021-3-3
     */
    public void deleteByNode(Node node) {
        if (node == null || head == null) {
            return;
        }
        if (node == head) {
            head = head.next;
        }
        Node p = head;
        while (p != null && p.next != node) {
            p = p.next;
        }
        if (p == null) {
            return;
        }
        p.next = p.next.next;
    }

    /**
     * 删除指定value的节点
     *
     * @param value the value of element to be deleted
     * @date 2021-3-3
     */
    public void deleteNode(int value) {
        Node node = new Node(value);
        this.deleteByNode(node);
    }

    public void isPalindrome(String s) {
        SinglyLinkedList singlyLinkedList = new SinglyLinkedList();
        singlyLinkedList.head = null;
        if (s == null || s.trim().equals("")) {
            return;
        }
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            char c = chars[i];
            boolean isNumOrLetter = (c >= 48 && c <= 57) || (c >= 65 && c <= 90) || (c >= 97 && c <= 122);
            if (isNumOrLetter) {
                if (singlyLinkedList.head == null) {
                    singlyLinkedList.head = new Node(c);
                } else {
                    singlyLinkedList.insertTail(c);
                }
            }
        }
        System.out.println(singlyLinkedList);
        Node head = singlyLinkedList.head;
        if (head != null) {
            Node dummy = new Node(0, head);
            Node slow = dummy;
            Node fast = dummy;
            Node nextRealNext = head;
            while (fast.next != null && fast.next.next != null) {


            }
            System.out.println(singlyLinkedList);
        }
    }

    public static void main(String[] args) {
        SinglyLinkedList singlyLinkedList = new SinglyLinkedList();
        singlyLinkedList.isPalindrome("123456");
    }
}
