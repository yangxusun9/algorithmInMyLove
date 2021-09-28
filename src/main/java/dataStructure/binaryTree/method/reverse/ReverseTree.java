package dataStructure.binaryTree.method.reverse;

import dataStructure.binaryTree.bean.TreeNode;

/**
 * @author yangxu
 * @version 1.0
 * @date 2021/9/28 上午11:37
 */
public class ReverseTree {

    /**
     * 反转二叉树
     * @author yangxu
     * @date 2021/3/24 上午10:56
     * @param root
     * @return  dataStructure.binaryTree.bean.TreeNode
     */
    public static TreeNode reverseAll(TreeNode root){
        //base case
        if (root == null){
            return root;
        }
        //反转
        TreeNode tmp ;
        tmp = root.left;
        root.left = root.right;
        root.right = tmp;

        reverseAll(root.left);
        reverseAll(root.right);
        return root;
    }
}
