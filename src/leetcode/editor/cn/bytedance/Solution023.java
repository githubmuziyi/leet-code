package leetcode.editor.cn.bytedance;

/**
 * 给定一个数组，它的第 i 个元素是一支给定股票第 i 天的价格。
 *
 * 设计一个算法来计算你所能获取的最大利润。你可以尽可能地完成更多的交易（多次买卖一支股票）。
 *
 * 注意：你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。
 *
 *
 *
 * 示例 1:
 *
 * 输入: [7,1,5,3,6,4]
 * 输出: 7
 * 解释: 在第 2 天（股票价格 = 1）的时候买入，在第 3 天（股票价格 = 5）的时候卖出, 这笔交易所能获得利润 = 5-1 = 4 。
 *      随后，在第 4 天（股票价格 = 3）的时候买入，在第 5 天（股票价格 = 6）的时候卖出, 这笔交易所能获得利润 = 6-3 = 3 。
 * 示例 2:
 *
 * 输入: [1,2,3,4,5]
 * 输出: 4
 * 解释: 在第 1 天（股票价格 = 1）的时候买入，在第 5 天 （股票价格 = 5）的时候卖出, 这笔交易所能获得利润 = 5-1 = 4 。
 *      注意你不能在第 1 天和第 2 天接连购买股票，之后再将它们卖出。
 *      因为这样属于同时参与了多笔交易，你必须在再次购买前出售掉之前的股票。
 * 示例 3:
 *
 * 输入: [7,6,4,3,1]
 * 输出: 0
 * 解释: 在这种情况下, 没有交易完成, 所以最大利润为 0。
 *
 *
 * 提示：
 *
 * 1 <= prices.length <= 3 * 10 ^ 4
 * 0 <= prices[i] <= 10 ^ 4
 *
 * @author ziwen
 * @since 2020-09-22 15:04
 */
public class Solution023 {

    /**
     * 动态规划的解法
     * @param prices
     * @return
     */
    public static int maxProfit(int[] prices) {
        if (prices.length <= 1) {
            return 0;
        }
        int[] cash = new int[prices.length];
        int[] hold = new int[prices.length];

        cash[0] = 0;
        hold[0] = -prices[0];

        for (int i = 1; i < prices.length; i++) {
            cash[i] = Math.max(cash[i - 1], hold[i - 1] + prices[i]);
            hold[i] = Math.max(hold[i - 1], cash[i - 1] - prices[i]);
        }
        return cash[prices.length - 1];
    }

    /**
     * 一次遍历解法
     * @param prices
     * @return
     */
    public static int maxProfitLoop(int[] prices) {
        if (prices.length <= 1) {
            return 0;
        }
        int max = 0;
        int last = 1;
        int minPrice = prices[0];
        while (last < prices.length) {
            int cur = Math.max(prices[last] - minPrice, 0);
            if (cur > 0) {
                minPrice = prices[last];
            } else {
                minPrice = Math.min(minPrice, prices[last]);
            }
            max += cur;
            last++;
        }
        return max;
    }

    public static void main(String[] args) {
        System.out.println(Solution023.maxProfit(new int[] {7,6,4,3,1}));
    }
}