package dataStructure.binaryTree.method;

import dataStructure.binaryTree.bean.TreeNode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

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

    /**
     * 从前序与中序遍历序列构造二叉树
     * https://leetcode-cn.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal/
     * @author yangxu
     * @date 2021/3/26 下午2:35
 * @param preorder
 * @param inorder
 * @return  dataStructure.binaryTree.bean.TreeNode
     */
    public static TreeNode buildTree(int[] preorder, int[] inorder){
      return buildTreeWithPreAndIn(preorder, 0, preorder.length - 1,
                inorder, 0, inorder.length - 1);
    }

    private static TreeNode buildTreeWithPreAndIn(int[] preorder, int preStart, int preEnd,
                                                  int[] inorder, int inStart, int inEnd) {
       //base case
        if (preStart > preEnd){
            return null;
        }
        TreeNode root = new TreeNode(preorder[preStart]);
        //找到inorder的根节点下标
        int index = 0;
        for (int i = inStart; i < inorder.length; i++) {
            if (inorder[i] == root.val){
                index = i;
            }
        }
        //确定preOrder的左子树长度
        int leftSize = index - inStart;
        root.left =  buildTreeWithPreAndIn(preorder, preStart+1, preStart + leftSize,
                inorder, inStart, index-1);
        root.right = buildTreeWithPreAndIn(preorder,preStart+leftSize+1,preEnd,
                inorder,index+1,inEnd);
        return root;
    }

    /**
     * 寻找重复子树
     * https://leetcode-cn.com/problems/find-duplicate-subtrees/solution/
     * @author yangxu
     * @date 2021/3/27 上午11:06
 * @param root
 * @return  java.util.List<dataStructure.binaryTree.bean.TreeNode>
     */
    public static List<TreeNode> findDuplicateSubtrees(TreeNode root){
        HashMap<String, Integer> roots = new HashMap<>();
        List<TreeNode> duplicates = new ArrayList<>();
        buildTreeToString(root,roots,duplicates);
        return duplicates;
    }

    private static String buildTreeToString(TreeNode root, HashMap<String, Integer> roots, List<TreeNode> duplicates) {
        if (root ==null){
            return null;
        }
        String left = buildTreeToString(root.left, roots, duplicates);
        String right = buildTreeToString(root.right, roots, duplicates);
        //将根子树序列化为字符串来做比较
        String currentRoots = left+","+right+","+root.val;
        Integer nums = roots.getOrDefault(currentRoots, 0);
        if (nums ==1){
            duplicates.add(root);
        }
        roots.put(currentRoots,nums+1);
        return currentRoots;
    }

    /**
     * 二叉搜索树转化为累加树
     * @author yangxu
     * @date 2021/9/28 下午12:01
 * @param root
 * @return  dataStructure.binaryTree.bean.TreeNode
     */
    public static TreeNode convertBST(TreeNode root) {
        int sum = 0;
        traverseBST(root,sum);
        return root;
    }

    private static void traverseBST(TreeNode root,Integer sum) {
        if (root == null){
            return ;
        }
        traverseBST(root.right,sum);
        root.val = sum;
        sum += root.val;
        traverseBST(root.left,sum);

    }
    /**
     * 判断BST 的合法性
     * https://leetcode-cn.com/problems/validate-binary-search-tree/solution/yan-zheng-er-cha-sou-suo-shu-by-leetcode-solution/
     * @author yangxu
     * @date 2021/4/6 下午6:43 
 * @param root   
 * @return  boolean
     */
    public boolean isValidBST(TreeNode root) {
        return isValidBST(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    public boolean isValidBST(TreeNode node, long lower, long upper) {
        if (node == null) {
            return true;
        }
        if (node.val <= lower || node.val >= upper) {
            return false;
        }
        return isValidBST(node.left, lower, node.val) && isValidBST(node.right, node.val, upper);
    }

    /**
     * BST遍历框架
     * @author yangxu
     * @date 2021/4/7 上午9:51 
 * @param root  
 * @param target   
 * @return  boolean
     */
    public static boolean isInBST(TreeNode root,Integer target){
        if (root == null)return false;
        if (root.val == target)return true;
        if(root.val>target)return isInBST(root.left,target);
        return isInBST(root.right,target);

    }


    /**
     * 二叉搜索树中删除一个节点
     * https://leetcode-cn.com/problems/delete-node-in-a-bst/
     * @author yangxu
     * @date 2021/4/7 下午4:12
 * @param root
 * @param target
 * @return  dataStructure.binaryTree.bean.TreeNode
     */
    public static TreeNode deleteNode(TreeNode root, Integer target){
        if (root ==null){
            return null;
        }
        if (root.val == target){
        //case1 root为叶节点，无子节点，直接替换
        if (root.left == null && root.right == null){
            return null;
        }
        //case2 root 为非叶节点，但只要一个子树，需要将子树替换成当前节点
            if (root.right == null)return root.left;
            if (root.left == null) return  root.right;
            //case3 root有俩个子树，需要用左子树最大值替换root
            TreeNode max = getMax(root.left);
            root.val = max.val;
                //删除最大值，实现替换的效果
           root.left = deleteNode(root.left, max.val);
            return root;
        }else if (root.val<target){
          root.right = deleteNode(root.right,target);
        }else if (root.val > target){
            root.left =  deleteNode(root.left,target);
        }
        return root;
    }

    private static TreeNode getMax(TreeNode root) {
        while (root.right != null){
            root = root.right;
        }
        return root;
    }


}
