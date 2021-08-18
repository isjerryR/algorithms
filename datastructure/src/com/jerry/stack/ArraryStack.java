package com.jerry.stack;
/**
 * 用数组模拟栈，出栈，入栈，操作
 * */
public class ArraryStack {
    private int maxSize;//栈的大小
    private int[] stack;//数组模拟栈，数据存储在数组中
    private int top = -1;//top表示栈顶，初始化为-1

    //构造器
    public ArraryStack(int maxSize){
        this.maxSize = maxSize;
        this.stack = new int[this.maxSize];
    }

    //判断栈满
    public boolean isFull(){
        return top == maxSize-1;
    }

    //判断栈空
    public boolean isEmpty(){
        return top == -1;
    }

    //入栈-push
    public void push(int value){
        if (isFull()){
            return;
        }
        top++;
        stack[top] = value;
    }

    //出栈-pop
    public int pop(){
        if (isEmpty()){
            return -1;//表示栈空，没有数据
        }
        int value = stack[top];
        top--;
        return value;
    }

    //遍历栈。遍历时会从栈顶开始显示数据
    public void list(){
        if (isEmpty()){
            return;
        }
        for (int i = top; i >= 0; i++) {
            System.out.println(stack[i]);
        }
    }
}
