package com.jerry.linkedlist;

import java.util.ArrayList;
import java.util.Stack;

/**
 * 反向打印链表
 * */
public class ReversePrint {
    //利用栈结构，先顺序遍历链表，将每一个节点压入栈，然后出栈，顺序打印节点信息。（利用栈先进后出的特性）
    public void reversePrintMethod1(ListNode listNode){
        if (listNode.next == null){
            return;
        }
        Stack<ListNode> stack = new Stack<>();
        ListNode cur = listNode;
        while (cur != null){
            stack.push(cur);
            cur = cur.next;
        }
        while (stack.size() >0){
            System.out.println(stack.pop());
        }
    }
    //要求使用数组返回
    public ArrayList<Integer> reversePrintMethod2(ListNode listNode){
        ArrayList<Integer> list  = new ArrayList<>();
        ListNode tmp = listNode;
        while (tmp != null){
            list.add(0,tmp.val);
            tmp = tmp.next;
        }
        return list;
    }

}
