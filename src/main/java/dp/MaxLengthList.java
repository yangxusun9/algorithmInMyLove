package dp;

import java.util.Arrays;

/**
 *https://leetcode-cn.com/problems/longest-increasing-subsequence/
 * 给你一个整数数组 nums ，找到其中最长严格递增子序列的长度。
 * //
 * // 子序列是由数组派生而来的序列，删除（或不删除）数组中的元素而不改变其余元素的顺序。例如，[3,6,2,7] 是数组 [0,3,1,6,2,2,7] 的子序
 * //列。
 * @author yangxu
 * @version 1.0
 * @date 2021/4/27 下午3:19
 */
public class MaxLengthList {
    public int lengthOfLIS(int[] nums) {
        //定义dp数组并初始化
        //定义：dp[i] = 当前节点之前（包含）的最长严格递增子序列 长度
        int[] dp = new int[nums.length];
        Arrays.fill(dp,1);
        //
        for (int i = 0; i < nums.length; i++) {
            for(int j = 0;j< i ;j++){
                //当前节点大于之前的节点时，（之前的dp数组+1）中的最大值就是dp[i]
                if (nums[j] < nums[i]){
                dp[i] = Math.max(dp[j]+1,dp[i]) ;
                }
            }
        }
      return   Arrays.stream(dp).max().getAsInt();
    }
}
