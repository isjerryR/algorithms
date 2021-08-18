package com.jerryr.utils;

public class ListNode {
    public int val;
    public ListNode next;

    public ListNode(int val) {
        this.val = val;
    }

    //添加新的节点
    public void add(int newVal){
        ListNode newListNode = new ListNode(newVal);
        if (this.next == null){
            this.next = newListNode;
        }else {
            this.next.add(newVal);
        }
    }
    //打印链表
    public void print(){
        System.out.print(this.val);
        if (this.next != null){
            System.out.print("-->");
            this.next.print();
        }
    }
}
