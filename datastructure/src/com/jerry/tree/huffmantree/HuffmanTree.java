package com.jerry.tree.huffmantree;

import java.util.ArrayList;
import java.util.Collections;

public class HuffmanTree {


    //前序遍历
    public static void preOrder(Node root){
        if (root != null){
            root.preOrder();
        }
    }
    //将数组构建成霍夫曼树
    public static Node creatHuffmanTree(int[] arr){

        //构建节点列表
        ArrayList<Node> nodes = new ArrayList<>();
        for (int value : arr) {
            nodes.add(new Node(value));
        }
        while (nodes.size() > 1){
            //节点值进行排序
            Collections.sort(nodes);
            //分别取出权值最小的节点构建二叉树
            Node leftNode = nodes.get(0);
            Node rightNode = nodes.get(1);

            Node parent = new Node(leftNode.value+rightNode.value);
            parent.left = leftNode;
            parent.right = rightNode;
            //删除处理过的Nodes
            nodes.remove(leftNode);
            nodes.remove(rightNode);
            nodes.add(parent);
        }
        return nodes.get(0);
    }
}

//节点类
class Node implements Comparable<Node>{
    int value;
    Node left;
    Node right;

    public Node(int value) {
        this.value = value;
    }

    public void preOrder(){
        System.out.println(this);
        if (this.left != null){
            this.left.preOrder();
        }
        if (this.right != null){
            this.right.preOrder();
        }
    }

    @Override
    public String toString() {
        return "Node{" +
                "value=" + value +
                ", left=" + left +
                ", right=" + right +
                '}';
    }

    @Override
    public int compareTo(Node o) {
        return this.value - o.value;//从小到大正序排序
    }
}