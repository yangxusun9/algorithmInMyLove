package ali;

import dataStructure.binaryTree.bean.TreeNode;
import lombok.Data;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * 2. 给你一个二叉树，请你返回其按 层序遍历 得到的节点值。 （即逐层地，从左到右访问所有节点）。
 *
 *
 *
 * 示例：
 * 二叉树：[3,9,20,null,null,15,7],
 *
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * 返回其层序遍历结果：
 *
 * [
 *   [3],
 *   [9,20],
 *   [15,7]
 * ]
 * @author yangxu
 * @version 1.0
 * @date 2021/9/28 下午9:39
 */
public class Test {

    @Data
      class Menu{
         int id; //自己的ID
          int parentId; //父菜单 Id
          private List<Menu> children; //子菜单

         }

    public List<Menu> settleMenu(List<Menu> menus) {

        for (int i = 0; i < menus.size(); i++) {
            Menu curMenu = menus.get(i);
            //没有父节点则跳过
            if (curMenu.parentId == 0){
                continue;
            }
            //找父节点
            for ( int j  = 0 ;j < menus.size();j++  ){
                //
                Menu jMenu = menus.get(j);
                if (jMenu.id == curMenu.parentId){
                    //inital
                   if (jMenu.getChildren().isEmpty()){
                       jMenu.setChildren(new ArrayList<Menu>());
                   }
                   jMenu.getChildren().add(curMenu);
                }
                menus.remove(curMenu);
            }
        }
        return menus;


    }



    public List<List<Integer>> levelOrder(TreeNode root) {
        ArrayList<List<Integer>> result = new ArrayList<>();
        //base case
        if ( root == null)
            return result;
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()){
            ArrayList<Integer> integers = new ArrayList<>();
            int curSize = queue.size();
            for (int i = 1; i <= curSize; i++) {
                TreeNode node = queue.poll();
                integers.add(node.val);
                if (node.left !=null){
                    queue.offer(node.left);
                }
                if (node.right !=null){
                    queue.offer(node.right);
                }
            }
            result.add(integers);
        }
        return result;
    }

}
