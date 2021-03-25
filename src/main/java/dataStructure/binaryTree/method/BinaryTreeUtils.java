package dataStructure.binaryTree.method;

import com.sun.tools.javac.util.ArrayUtils;
import dataStructure.binaryTree.bean.TreeNode;

import javax.swing.plaf.ListUI;
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

    /**
     * 填充二叉树节点的右侧指针
     * https://leetcode-cn.com/problems/populating-next-right-pointers-in-each-node/
     * @author yangxu
     * @date 2021/3/25 上午11:05
 * @param root   
 * @return  dataStructure.binaryTree.bean.TreeNode
     */
    public static TreeNode linkNextNode(TreeNode root){
        if (root == null){
            return root;
        }
        connectTwoNode(root.left,root.right);
        return root;
    }

    private static void connectTwoNode(TreeNode node1, TreeNode node2) {
        //base case
        if (node1 ==null || node2 == null){
            return;
        }
        node1.next=node2;
        connectTwoNode(node1.left,node1.right);
        connectTwoNode(node1.right,node2.left);
        connectTwoNode(node2.left,node2.right);
    }

    /**
     * 遍历打印
     * @author yangxu
     * @date 2021/3/25 上午10:46
 * @param treeNode
     */
    public static void show(TreeNode treeNode){
        if (treeNode ==null){
            return;
        }
        System.out.println(treeNode.val);
        show(treeNode.left);
        show(treeNode.right);
    }

    /**
     * 将二叉树打平为链表
     *
     *  https://leetcode-cn.com/problems/flatten-binary-tree-to-linked-list/
     * @author yangxu
     * @date 2021/3/25 上午11:19
 * @param root
 * @return  dataStructure.binaryTree.bean.TreeNode
     */
    public static TreeNode flattenToList(TreeNode root){
        if (root == null){
            return root;
        }
        TreeNode leftNode = flattenToList(root.left);
        TreeNode rightNode = flattenToList(root.right);
        //当前节点处理逻辑
        root.left = null;
        if (leftNode == null){
            return root;
        }
        root.right = leftNode;
        //把右链表接到左链表尾端
        TreeNode p = root;
        while (p.right !=null ){
            p = p.right;
        }
        p.right = rightNode;
        return root;
    }

   /**
    * 根据数组构造最大二叉树
    * https://leetcode-cn.com/problems/maximum-binary-tree/
    * @author yangxu
    * @date 2021/3/25 下午2:24
 * @param nums
 * @return  dataStructure.binaryTree.bean.TreeNode
    */
   public  static  TreeNode constructMaximumBinaryTree(int[] nums){
       return buildMaxTreeNode(nums, 0, nums.length - 1);
   }

    private static TreeNode buildMaxTreeNode(int[] nums, int start, int end) {
       //base case
        if (start > end){
            return null;
        }
        int index  = 0;
        int maxValue = Integer.MIN_VALUE;
        for (int i = start; i <= end; i++) {
            if (nums[i] > maxValue){
                maxValue = nums[i];
                index = i;
            }
        }
        TreeNode treeNode = new TreeNode(nums[index]);
        treeNode.left = buildMaxTreeNode(nums,start,index-1);
        treeNode.right = buildMaxTreeNode(nums,index+1,end);
        return treeNode;
    }


}
