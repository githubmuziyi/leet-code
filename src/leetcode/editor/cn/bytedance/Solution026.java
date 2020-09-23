package leetcode.editor.cn.bytedance;

import java.util.Arrays;
import java.util.Comparator;

/**
 * 给定一些标记了宽度和高度的信封，宽度和高度以整数对形式 (w, h) 出现。
 * 当另一个信封的宽度和高度都比这个信封大的时候，这个信封就可以放进另一个信封里，如同俄罗斯套娃一样。
 *
 * 请计算最多能有多少个信封能组成一组“俄罗斯套娃”信封（即可以把一个信封放到另一个信封里面）。
 *
 * 说明:
 * 不允许旋转信封。
 *
 * 示例:
 *
 * 输入: envelopes = [[5,4],[6,4],[6,7],[2,3]]
 * 输出: 3
 * 解释: 最多信封的个数为 3, 组合为: [2,3] => [5,4] => [6,7]。
 *
 * @author ziwen
 * @since 2020-09-22 22:10
 */
public class Solution026 {

    public int maxEnvelopes(int[][] envelopes) {
        // w升序排列，相等的话的h降序排列
        Arrays.sort(envelopes, (o1, o2) -> {
            if (o1[0] == o2[0]) {
                return o2[1] - o1[1];
            } else {
                return o1[0] - o2[0];
            }
        });
        int[] arr = new int[envelopes.length];
        for (int i = 0; i < envelopes.length; i++) {
            arr[i] = envelopes[i][1];
        }
        return lengthOfLIS(arr);
    }

    /**
     * 二分查找查找最大递增子串
     * @param arr
     * @return
     */
    public int lengthOfLIS(int[] arr) {
        if (arr.length <= 0) {
            return 0;
        }
        int[] dp = new int[arr.length];
        int len = 0;
        for (int num : arr) {
            int index = Arrays.binarySearch(arr, 0, len, num);
            if (index < 0) {
                index = -(index + 1);
            }
            dp[index] = num;
            if (index == len) {
                len++;
            }
        }
        return len;
    }
}
