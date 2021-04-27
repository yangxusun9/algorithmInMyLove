package dp;

import java.util.ArrayList;

/**
 * 给定不同面额的硬币 coins 和一个总金额 amount。编写一个函数来计算可以凑成总金额所需的最少的硬币个数。如果没有任何一种硬币组合能组成总金额，返回-1。
 *
 * 你可以认为每种硬币的数量是无限的。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/coin-change
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author yangxu
 * @version 1.0
 * @date 2021/4/18 下午2:48
 */
public class CoinsChange {
    /**
     * dp table解法
     * @author yangxu
     * @date 2021/4/18 下午2:49
 * @param coins  硬币面额
 * @param amount   金额总数
 * @return  int
     */
    public int coinChange(int[] coins, int amount) {
        //init dp table
        //dp[i] =n 代表 金额为 i 时，最小所需硬币数为n
        int[] dp = new int[amount + 1];

        //base case
        dp[0] = 0;

        for (int i = 1; i < amount+1; i++) {
            dp[i] = Integer.MAX_VALUE -1;//这里减1 主要是为了避免后续+1 操作时 越界
            for (int coin : coins) {
                //如果无解，就跳过
                if (i - coin < 0) continue;
                //状态转移方程
                dp[i] = Math.min(dp[i],1+dp[i-coin]);
            }
        }
        return dp[amount] == Integer.MAX_VALUE -1? -1:dp[amount];

    }

}
