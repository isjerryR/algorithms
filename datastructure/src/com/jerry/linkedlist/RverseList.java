package com.jerry.linkedlist;

import java.util.ArrayList;

/**
 *
 * 描述
 * 输入一个链表的头节点，按链表从尾到头的顺序返回每个节点的值（用数组返回）。
 *
 * 如输入{1,2,3}的链表如下图:
 *
 * 返回一个数组为[3,2,1]
 *
 * 0 <= 链表长度 <= 1000
 * */
public class RverseList {
    public ArrayList<Integer> printListFromTailToHead(ListNode listNode){
        ArrayList<Integer> list = new ArrayList<>();
        ListNode tmp = listNode;
        while (tmp != null){
            list.add(0,tmp.val);
            tmp = tmp.next;
        }
        return list;
    }
}

