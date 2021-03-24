package dataStructure.binaryTree.bean;

/**
 * @author yangxu
 * @version 1.0
 * @date 2021/3/24 上午10:36
 */
public class TreeNode {
    public int val;
    public TreeNode left;
    public TreeNode right;

   public TreeNode() {
    }

    public TreeNode(int val) {
        this.val = val;
    }

   public TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
