package dp;

/**
 * 给定一个整数数组 nums ，找到一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
 * https://leetcode-cn.com/problems/maximum-subarray/
 * @author yangxu
 * @version 1.0
 * @date 2021/6/28 上午11:02
 */
public class MaximumSubarray {


    public int maxSubArray(int[] nums) {
        //定义一个dp[],定义为 dp【i】 = 下标为i时，最大的和
        int[] dp = new int[nums.length];
        //base case
        dp[0] = nums[0];
       int maxAgg = nums[0];
        for (int i = 1; i < nums.length; i++) {
            //状态转移方程
            //如果 前一个下标的最大和+当前值 < 当前值，取当前值为dp[i] 的值
            dp[i] = Math.max(nums[i],dp[i-1]+nums[i]);
            maxAgg = Math.max(maxAgg,dp[i]);
        }
        return maxAgg;


    }
}
