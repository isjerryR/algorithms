package com.jerryr.offer.JZ17;

import com.jerryr.utils.TreeNode;

public class HashSubTree {
    /**
     * @description:
     * 输入两棵二叉树A，B，判断B是不是A的子结构。（ps：我们约定空树不是任意一个树的子结构）
     *
     * @param root1
	 * @param root2
     * @return boolean
     * @author: jerryr
     * @dateTime: 2021/8/18 12:21
     */
    public static boolean hasSubtree(TreeNode root1, TreeNode root2) {
//        if (root2 == null)
//            return false;
//        if (root1 == null && root2 != null)
//            return false;
//        if (root1.val == root2.val)
//            return isEquals(root1,root2);
//        else if(hasSubtree(root1.left,root2))
//            return true;
//        else if(hasSubtree(root1.right,root2))
//            return true;
//        return false;
        boolean flag = false;
        if (root1.val == root2.val)
            flag = isEquals(root1,root2);
        if (!flag){
            flag = hasSubtree(root1.left,root2);
            if (!flag)
                flag = hasSubtree(root1.right,root2);
        }
        return flag;
    }
    public static boolean isEquals(TreeNode root1, TreeNode root2){
        if (root2 == null)
            return false;
        if (root1 == null && root2 != null)
            return false;
        if (root1.val == root2.val){
            return isEquals(root1.left,root2.left) && isEquals(root1.right,root2.right);
        }else
            return false;
    }

    public static void main(String[] args) {
        TreeNode root1 = new TreeNode(1);
        root1.left = new TreeNode(2);
        root1.right = new TreeNode(3);
        root1.left.left = new TreeNode(4);
        root1.left.right = new TreeNode(5);
        TreeNode root2 = new TreeNode(2);
        root2.left = new TreeNode(4);
        root2.right = new TreeNode(5);
        boolean b = hasSubtree(root1, root2);
        System.out.println(b);

    }
}
