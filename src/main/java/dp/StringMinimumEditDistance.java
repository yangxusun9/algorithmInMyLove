package dp;

/**
 * https://leetcode-cn.com/problems/edit-distance/
 * 给你两个单词 word1 和 word2，请你计算出将 word1 转换成 word2 所使用的最少操作数 。
 *
 * 你可以对一个单词进行如下三种操作：
 *
 * 插入一个字符
 * 删除一个字符
 * 替换一个字符
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/edit-distance
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author yangxu
 * @version 1.0
 * @date 2021/4/28 下午2:51
 */
public class StringMinimumEditDistance {
    public int minDistance(String word1, String word2) {
        //初始化dp table，俩个字符串的操作用二维数组
        int m = word1.length();
        int n = word2.length();
        int[][] dpTables = new int[m +1][n +1];
        //base case 如果一个String1为null，那么dp[0][j] =j 或者dp[i][0] = i，边界情况done
        for (int i = 1; i <=m; i++) {
            dpTables[i][0]=i;
        }
        for (int j = 0; j <= n; j++) {
            dpTables[0][j] = j;
        }
        //从前往后依次比较俩个字符串的末尾
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                //如果字符相等，那就跳过，不操作，所以操作数跟上一次一样
                if (word1.charAt(i-1) == word2.charAt(j -1)){
                    dpTables[i][j] = dpTables[i-1][j-1];
                }else {
                    /*如果字符不想等，有三种操作模式，
                    * 删除：
                    *插入：
                    * 替换：
                    * 选择其中最小的一个作为dp[i][j] 的值
                    * */
                    dpTables[i][j] = min(dpTables[i-1][j]+1,
                            dpTables[i][j-1]+1,
                            dpTables[i-1][j-1]+1);
                }
            }
        }
        return dpTables[m][n];
        }

    private int min(int a, int b, int c) {
        return Math.min(a,Math.min(b,c));
    }


}
