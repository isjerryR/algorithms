package com.jerryr.offer.JZ15;


import com.jerryr.utils.ListNode;

import java.util.Stack;

public class ReverseList {
    /**
     * @description:
     * 输入一个链表，反转链表后，输出新链表的表头。
     * 利用栈后进先出的特点进行链表反转
     * @param head
     * @return com.jerryr.utils.ListNode
     * @author: jerryr
     * @dateTime: 2021/8/18 11:02
     */
    public static ListNode ReverseList(ListNode head) {
        if (head == null || head.next == null)
            return head;
        Stack<ListNode> stack = new Stack<>();
        ListNode index = head;
        while (index != null){
            stack.push(index);
            index = index.next;
        }
        ListNode current = stack.pop();
        ListNode  headIndex = current;
        while (!stack.isEmpty()){
            ListNode temp = stack.pop();
            current.next = temp;
            current = current.next;
        }
        current.next = null;
        return headIndex;
    }
    /**
     * @description: 遍历链表的时候，将每一个节点反转，作为新链表的头节点
     * @param head
     * @return com.jerryr.utils.ListNode
     * @author: jerryr
     * @dateTime: 2021/8/18 11:06
     */
    public static ListNode ReverseList1(ListNode head) {
       ListNode newHead = null;
       while (head != null){
            ListNode temp = head.next;
            head.next = newHead;
            newHead = head;
            head = temp;
       }
       return newHead;
    }

    public static void main(String[] args) {
        ListNode listNode = new ListNode(1);
        listNode.add(2);
        listNode.add(3);
        listNode.print();
        ListNode listNode1 = ReverseList(listNode);
        System.out.println();
        listNode1.print();
    }
}
