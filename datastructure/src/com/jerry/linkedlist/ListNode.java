package com.jerry.linkedlist;
/**
 * 链表结构
 * */
public class ListNode {
    public int val;

    public ListNode next = null;

    public ListNode(int val) {
        this.val = val;
    }

    public ListNode() {
    }

    @Override
    public String toString() {
        return "ListNode{" +
                "val=" + val +
                ", next=" + next +
                '}';
    }

    //添加新的节点
    public void add(int newVal){
        ListNode newListNode = new ListNode(newVal);
//        if (this.next == null){
//            this.next = newListNode;
//        }else {
//            this.next.add(newVal);
//        }
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
