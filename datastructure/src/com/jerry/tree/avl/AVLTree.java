package com.jerry.tree.avl;

public class AVLTree {
    private Node root;
    //添加
    public void add(Node node){
        if (root == null)
            root = node;
        else root.add(node);
    }
    //查找删除的结点、
    public Node search(int value){
        if (root == null)
            return null;
        else
            return root.search(value);
    }

    //查找删除父结点
    public Node searchParent(int value){
        if (root == null)
            return null;
        else
            return root.searchParent(value);
    }

    //找到当前结点左子树的最小结点并删除
    public int delRightTreeMin(Node node){
        Node target = node;
        while (target.left != null){
            target = target.left;
        }
        delNode(target.value);
        return target.value;
    }
    //找到当前结点的右子树的最大值并删除
    public int delLeftTreeMax(Node node){
        Node target = node;
        while (target.right != null)
            target = target.right;
        delNode(target.value);
        return target.value;
    }

    //删除结点
    public void delNode(int value){
        if (root == null)
            return;
        else {
            Node targetNode = search(value);
            if (targetNode == null)
                return;
            if (root.left == null && root.left == null){
                root = null;
                return;
            }
            Node parent = searchParent(value);
            //删除结点是叶子结点
            if (targetNode.left == null && targetNode.right == null){
                if (parent.left != null && parent.left.value == value)
                    parent.left = null;
                else if (parent.right != null && parent.right.value == value)
                    parent.right = null;
            }else if (targetNode.left != null && targetNode.right != null){
                //删除两颗子树的节点
                //找到右子树的最小值，建议从左子树找最大值
//                int minVal = delRightTreeMin(targetNode.right);
//                targetNode.value = minVal;
                int maxVal = delLeftTreeMax(targetNode.left);
                targetNode.value = maxVal;
            }else {
                //删除只有一颗子树的结点
                if (targetNode.left != null){
                    if (parent.left.value == value)
                        parent.left = targetNode.left;
                    else
                        parent.right = targetNode.left;
                }else {
                    if (parent.left.value == value)
                        parent.left = targetNode.right;
                    else
                        parent.right = targetNode.right;
                }
            }
        }
    }


    //中序遍历
    public void infixOrder(){
        if (root != null)
            root.infixOrder();

    }
}

//创建节点
class Node {
    int value;
    Node left;
    Node right;

    public Node(int value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "Node{" +
                "value=" + value +
                '}';
    }
    //返回左子树的高度
    public int leftHeight(){
        if (left == null)
            return 0;
        return left.height();
    }
    //返回右子树的高度
    public int rightHeight(){
        if (right == null)
            return 0;
        return right.height();
    }

    //返回当前结点的高度，以该节点为根结点的树的高度
    public int height(){
        return Math.max(left == null ? 0: left.height(),right == null ? 0:right.height())+1;
    }

    //左旋转方法
    private void leftRotate(){
        Node newNode = new Node(value);
        newNode.left = left;
        newNode.right = right.left;
        value = right.value;
        right = right.right;
        left = newNode;
    }
    //右旋转方法
    private void rightRotate(){
        Node newNode = new Node(value);
        newNode.right = right;
        newNode.left = left.right;
        value = left.value;
        left = left.left;
        right = newNode;
    }

    //添加节点
    public void add(Node node){
        if (node == null){
            return;
        }
        if (node.value < this.value){
            if (this.left == null)
                this.left = node;
            else
                this.left.add(node);
        }else {
            if (this.right == null)
                this.right = node;
            else
                this.right.add(node);
        }

        if (rightHeight() - leftHeight() > 1){
            if (right != null && right.rightHeight() < right.leftHeight()){
                right.rightRotate();
                leftRotate();
            }else
                leftRotate();
            return;
        }

        if (leftHeight() - rightHeight() > 1){
            if (left != null && left.leftHeight() < left.rightHeight()){
                left.leftRotate();
                rightRotate();
            }
            else
                rightRotate();
        }
    }

    //查找要删除的结点
    public Node search(int value){
        if (value == this.value)
            return this;
        else if (value < this.value){
            if (this.left == null)
                return null;
            return this.left.search(value);
        }else {
            if (this.right == null)
                return null;
            return this.right.search(value);
        }

    }
    //查找要删除结点的父结点
    public Node searchParent(int value){
        if ((this.left != null && this.left.value == value) || (this.right != null && this.right.value == value))
            return this;
        else {
            if (value < this.value && this.left != null)
                return this.left.searchParent(value);
            else if (value >= this.value && this.right != null)
                return this.right.searchParent(value);
            else
                return null;//没有父结点
        }
    }

    //中序遍历
    public void infixOrder(){
        if (this.left != null)
            this.left.infixOrder();
        System.out.println(this);
        if (this.right != null)
            this.right.infixOrder();
    }
}
