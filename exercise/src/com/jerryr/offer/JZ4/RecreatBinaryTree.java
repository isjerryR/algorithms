package com.jerryr.offer.JZ4;


import java.util.Arrays;

public class RecreatBinaryTree {
    public static void main(String[] args) {
        int[] pre = new int[]{1,2,4,7,3,5,6,8};
        int[] vin = new int[]{4,7,2,1,5,3,8,6};
        RecreatBinaryTree recreatBinaryTree = new RecreatBinaryTree();
        TreeNode treeNode = recreatBinaryTree.reConstructBinaryTree(pre, vin);
        System.out.println(treeNode);
    }

    /**
     * @description:
     * 给定某二叉树的前序遍历和中序遍历，请重建出该二叉树并返回它的头结点。
     * 例如输入前序遍历序列{1,2,4,7,3,5,6,8}和中序遍历序列{4,7,2,1,5,3,8,6}，则重建出如下图所示。
     *
     *
     * 提示:
     * 1.0 <= pre.length <= 2000
     * 2.vin.length == pre.length
     * 3.-10000 <= pre[i], vin[i] <= 10000
     * 4.pre 和 vin 均无重复元素
     * 5.vin出现的元素均出现在 pre里
     * 6.只需要返回根结点，系统会自动输出整颗树做答案对比
     * @param pre
	 * @param vin
     * @return pers.jerryr.exercise.offer.JZ4.TreeNode
     * @author: jerryr
     * @dateTime: 2021/8/17 10:51
     */
    public TreeNode reConstructBinaryTree(int [] pre, int [] vin) {
        if (pre.length == 0) {
            return null;
        }
        int rootVal = pre[0];
        if (pre.length == 1) {
            return new TreeNode(rootVal);
        }
        TreeNode treeNode = new TreeNode(rootVal);
        int rootIndex = 0;
        while (rootVal != vin[rootIndex]) {
            rootIndex++;
        }
        treeNode.left = reConstructBinaryTree(Arrays.copyOfRange(pre,1,rootIndex+1),Arrays.copyOfRange(vin,0,rootIndex));
        treeNode.right = reConstructBinaryTree(Arrays.copyOfRange(pre,rootIndex+1,pre.length),Arrays.copyOfRange(vin,rootIndex+1,vin.length));
        return treeNode;
    }
//    public TreeNode recbt(int rootVal,int leftVal,int rightVal){
//        TreeNode treeNode = new TreeNode(rootVal);
//        treeNode.left.val = leftVal;
//        treeNode.right.val = rightVal;
//        return treeNode;
//    }
}

class TreeNode{
    int val;
    TreeNode left;
    TreeNode right;

    public TreeNode(int val) {
        this.val = val;
    }

}