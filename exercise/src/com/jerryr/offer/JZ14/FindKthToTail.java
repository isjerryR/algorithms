package com.jerryr.offer.JZ14;


import com.jerryr.utils.ListNode;

public class FindKthToTail {
    /**
     * @description:
     * 输入一个链表，输出一个链表，该输出链表包含原链表中从倒数第k个结点至尾节点的全部节点。
     * 如果该链表长度小于k，请返回一个长度为 0 的链表。
     * @param pHead
	 * @param k
     * @return pers.jerryr.primaryalgorithm.linkedlist.ListNode
     * @author: jerryr
     * @dateTime: 2021/8/17 16:42
     */
    public static ListNode findKthToTail (ListNode pHead, int k) {
        if (pHead == null)
            return pHead;
        ListNode fast = pHead;
        int i = 0;
        while (i <k){
            if (fast == null)
                return fast;
            fast = fast.next;
            i++;
        }
        ListNode slow = pHead;
        while (fast !=null){
            fast = fast.next;
            slow = slow.next;
        }
        return slow;
    }

    public static void main(String[] args) {
        ListNode listNode = new ListNode(1);
        listNode.add(2);
        listNode.add(3);
        listNode.add(4);
        listNode.add(5);
        listNode.print();
        ListNode kthToTail = findKthToTail(listNode, 2);
        System.out.println();
        kthToTail.print();
    }


}

