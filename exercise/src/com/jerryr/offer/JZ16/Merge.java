package com.jerryr.offer.JZ16;

import com.jerryr.utils.ListNode;

public class Merge {
    /**
     * @description:
     * 输入两个单调递增的链表，输出两个链表合成后的链表，当然我们需要合成后的链表满足单调不减规则。
     *
     * @param list1
	 * @param list2
     * @return com.jerryr.utils.ListNode
     * @author: jerryr
     * @dateTime: 2021/8/18 11:45
     */
    public static ListNode Merge(ListNode list1, ListNode list2) {
        if (list1 == null)
            return list2;
        if (list2 == null)
            return list1;
        ListNode newList = null;
        if (list1.val <= list2.val) {
            newList = list1;
            list1 = list1.next;
        }
        else{
            newList = list2;
            list2 = list2.next;
        }
        ListNode newHead = newList;
        while (list1 != null || list2 != null){
            if (list1 == null){
                newList.next = list2;
                break;
            }
            if (list2 == null){
                newList.next = list1;
                break;
            }
            if (list1.val <= list2.val){
                newList.next = list1;
                newList = newList.next;
                list1 = list1.next;
            }else {
                newList.next = list2;
                newList = newList.next;
                list2 = list2.next;
            }
        }
        return newHead;
    }

    public static void main(String[] args) {
        ListNode listNode1 = new ListNode(1);
        listNode1.add(2);
        listNode1.add(7);
        listNode1.print();
        System.out.println();
        ListNode listNode2 = new ListNode(2);
        listNode2.add(3);
        listNode2.add(6);
        listNode2.print();
        System.out.println();
        ListNode merge = Merge(listNode1, listNode2);
        merge.print();
    }
}
