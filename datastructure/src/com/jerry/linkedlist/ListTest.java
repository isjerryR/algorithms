package com.jerry.linkedlist;

import org.junit.Test;

import java.util.ArrayList;


public class ListTest {
    public ListNode creatListNode(){
        ListNode listNode = new ListNode(1);
        listNode.add(2);
        listNode.add(3);
        listNode.add(4);
        listNode.add(5);
        listNode.add(6);
        return listNode;
    }
    @Test
    public void testReversePrint(){
        ReversePrint reversePrint = new ReversePrint();
        reversePrint.reversePrintMethod1(new ListTest().creatListNode());
        ArrayList<Integer> list = reversePrint.reversePrintMethod2(new ListTest().creatListNode());
        System.out.println(list);
    }
}
