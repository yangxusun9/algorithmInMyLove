package dataStructure.binaryTree.method;

import dataStructure.binaryTree.bean.TreeNode;
import org.junit.Test;


/**
 * @author yangxu
 * @version 1.0
 * @date 2021/3/24 上午11:06
 */
public  class BinaryTreeUtilsTest {

    @Test
   public void reverseAll() {
        TreeNode root = new TreeNode(4);
        TreeNode node5 = new TreeNode(5,new TreeNode(6),new TreeNode(7));
        TreeNode node3 = new TreeNode(3,new TreeNode(1),new TreeNode(2));
        root.left = node3;
        root.right = node5;
//        BinaryTreeUtils.reverseAll(root);
        BinaryTreeUtils.show(root);
        BinaryTreeUtils.flattenToList(root);
        System.out.println("....................");
        BinaryTreeUtils.show(root);
    }

    @Test
    public void constructMaximumBinaryTree(){
        int[] nums = new int[]{1,2,7,4,5};
//        System.out.println("....................");
        TreeNode root = BinaryTreeUtils.constructMaximumBinaryTree(nums);
        BinaryTreeUtils.show(root);

    }
}