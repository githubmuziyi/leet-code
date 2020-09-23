package leetcode.editor.cn.bytedance;

/**
 * 给定一个数组，它的第 i 个元素是一支给定股票第 i 天的价格。
 *
 * 如果你最多只允许完成一笔交易（即买入和卖出一支股票一次），设计一个算法来计算你所能获取的最大利润。
 *
 * 注意：你不能在买入股票前卖出股票。
 *
 *
 *
 * 示例 1:
 *
 * 输入: [7,1,5,3,6,4]
 * 输出: 5
 * 解释: 在第 2 天（股票价格 = 1）的时候买入，在第 5 天（股票价格 = 6）的时候卖出，最大利润 = 6-1 = 5 。
 *      注意利润不能是 7-1 = 6, 因为卖出价格需要大于买入价格；同时，你不能在买入前卖出股票。
 * 示例 2:
 *
 * 输入: [7,6,4,3,1]
 * 输出: 0
 * 解释: 在这种情况下, 没有交易完成, 所以最大利润为 0。
 *
 * @author ziwen
 * @since 2020-09-22 14:35
 */
public class Solution022 {

    /**
     * 动态规划解法
     * 方法三：动态规划
     *
     * 本题要求的其实是卖出时与买入时的最大差值。我们不妨假设f(i)表示以第i天为结尾时卖出股票获得的最大收入（差值），那么最后要求的是：
     *
     * f(i) = max{f(i)| 1 <= i <= n>>};
     *
     * 而f(i)其实还与f(i-1)有关，f(i-1) = p[i-1] - minValue, 其中minValue表示以i-1结尾的前排数组的最小值，
     * 故 minValue = p[i-1] - f(i-1)。
     *
     * 那么我们可以得到如下关系： f(i) = max (p[i] - (p[i-1] - f(i-1), 0)) = max (f(i-1) + p[i] - p[i-1], 0);
     * （显然，每次可以当天买进，当天卖出，所以最大收益不应该低于0。）
     *
     * 时间复杂度：O(N)； 空间复杂度：O(1)；
     * @param prices
     * @return
     */
    public static int maxProfit(int[] prices) {
        if (prices.length <= 1) {
            return 0;
        }
        int max = 0;
        int finit = 0;
        for (int i = 1; i < prices.length; i++) {
            int fcur = Math.max(finit + prices[i] - prices[i - 1], 0);
            max = Math.max(max, fcur);
            finit = fcur;
        }
        return max;
    }

    /**
     * n^2时间复杂度
     * @param prices
     * @return
     */
    public static int maxProfitTimeOut(int[] prices) {
        if (prices.length <= 1) {
            return 0;
        }
        int max = 0;
        for (int i = 0; i < prices.length; i++) {
            for (int j = i + 1; j < prices.length; j++) {
                max = Math.max(max, prices[j] - prices[i]);
            }
        }
        return max;
    }

    public static void main(String[] args) {
        System.out.println(Solution022.maxProfit(new int[] {7,1,5,3,6,4}));
    }
}
