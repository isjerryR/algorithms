package com.jerryr.offer.JZ15;


import com.jerryr.utils.ListNode;

import java.util.Stack;

public class ReverseList {
    public ListNode ReverseList(ListNode head) {
        Stack stack = new Stack();
        ListNode temp = head;
        while (temp != null){
            stack.push(temp);
            temp = temp.next;
        }
        ListNode pre =null ;
        ListNode suf =null;
        while (!stack.isEmpty()){

            pre = (ListNode) stack.pop();
            suf = pre.next;
        }
        return pre;
    }
}
