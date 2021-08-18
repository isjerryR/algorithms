package com.jerryr.offer.JZ3;

import com.jerryr.utils.ListNode;

import java.util.ArrayList;
import java.util.Stack;

class PrintListFromTailToHead {
    /**
     * @description:
     * 输入一个链表的头节点，按链表从尾到头的顺序返回每个节点的值（用数组返回）。
     *
     * 如输入{1,2,3}的链表如下图:
     *
     * 返回一个数组为[3,2,1]
     *
     * 0 <= 链表长度 <= 10000
     * @param listNode
     * @return java.util.ArrayList<java.lang.Integer>
     * @author: jerryr
     * @dateTime: 2021/8/17 10:05
     */
    public static ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
        ArrayList<Integer> list = new ArrayList<>();
        Stack stack = new Stack();
        ListNode temp = listNode;
//        int index = 0;
        while (temp != null){
//            index++;
            stack.push(temp.val);
            temp = temp.next;
        }
//        while (index > 0){
//            index--;
//            Integer current = (Integer)stack.pop();
//            list.add(current);
//        }
        while (!stack.isEmpty())
            list.add((Integer) stack.pop());
        return list;
    }



    public static void main(String[] args) {
        ListNode listNode = new ListNode(1);
        listNode.next = new ListNode(2);
        listNode.next.next = new ListNode(3);
        ArrayList<Integer> list = PrintListFromTailToHead.printListFromTailToHead(listNode);
        for (Integer integer : list) {
            System.out.println(integer);
        }
    }
}
