package bfs;

import java.util.LinkedList;
import java.util.List;

/**
 *
 * 给定一个不含重复数字的数组 nums ，返回其 所有可能的全排列 。你可以 按任意顺序 返回答案。
 *https://leetcode-cn.com/problems/permutations/
 * @author yangxu
 * @version 1.0
 * @date 2021/7/5 上午11:12
 */
public class FullPermutations {
    public static void main(String[] args) {
        int[] nums = new int[]{1,2,3};
        System.out.println(new FullPermutations().permute(nums));
    }

    public List<List<Integer>>  permute (int[] nums){
        //记录结果
        List<List<Integer>> result = new LinkedList<>();
        //记录路径
        LinkedList<Integer> track = new LinkedList<>();
        backTrack(nums,track,result);
       return result;
    }

    private void backTrack(int[] nums, LinkedList<Integer> track, List<List<Integer>> result) {
        //触发结束时间
        if (track.size() == nums.length){
            //这里要新建一个链表，要不然一直引用的是地址值
            result.add(new LinkedList<>(track));
            return;
        }
        //暴力穷举找出所有路径
        for (int i = 0; i < nums.length; i++) {
            //排除不合法的选择
            if (track.contains(nums[i])){
                continue;
            }
            //做选择
            track.add(nums[i]);
            //进行下一次选择
            backTrack(nums,track,result);
            //撤销选择
            track.removeLast();
        }

    }
}
