package leetcode.editor.cn.bytedance;

import java.util.HashSet;

/**
 * 给定一个未排序的整数数组，找出最长连续序列的长度。
 *
 * 要求算法的时间复杂度为 O(n)。
 *
 * 示例:
 *
 * 输入: [100, 4, 200, 1, 3, 2]
 * 输出: 4
 * 解释: 最长连续序列是 [1, 2, 3, 4]。它的长度为 4。
 *
 * @author ziwen
 * @since 2020-09-17 10:58
 */
public class Solution013 {

    public static int longestConsecutive(int[] nums) {
        if (nums.length <= 0) {
            return 0;
        }
        HashSet<Integer> hashSet = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            hashSet.add(nums[i]);
        }
        int max = 0;
        for (int i = 0; i < nums.length; i++) {
            int current = nums[i];
            if (hashSet.contains(current + 1)) {
                continue;
            }
            int currentMax = 0;
            while (hashSet.contains(current)) {
                currentMax++;
                current--;
            }
            max = Math.max(max, currentMax);
        }
        return max;
    }

    public static void main(String[] args) {
        int[] nums = {100, 4, 200, 1, 3, 2};
        System.out.println(Solution013.longestConsecutive(nums));
    }
}
