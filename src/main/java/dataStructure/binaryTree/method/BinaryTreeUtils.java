package dataStructure.binaryTree.method;

import dataStructure.binaryTree.bean.TreeNode;

import java.awt.print.Printable;

/**
 * @author yangxu
 * @version 1.0
 * @date 2021/3/24 上午10:39
 */
public class BinaryTreeUtils {
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

    public static void show(TreeNode treeNode){
        if (treeNode ==null){
            return;
        }
        System.out.println(treeNode.val);
        show(treeNode.left);
        show(treeNode.right);
    }

}
