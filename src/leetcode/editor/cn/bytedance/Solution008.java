package leetcode.editor.cn.bytedance;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 给你一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，
 * 使得 a + b + c = 0 ？请你找出所有满足条件且不重复的三元组。
 *
 * 注意：答案中不可以包含重复的三元组。
 *
 *
 *
 * 示例：
 *
 * 给定数组 nums = [-1, 0, 1, 2, -1, -4]，
 *
 * 满足要求的三元组集合为：
 * [
 *   [-1, 0, 1],
 *   [-1, -1, 2]
 * ]
 *
 * @author ziwen
 * @since 2020-09-15 16:25
 */
public class Solution008 {

    public static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> resList = new ArrayList<>();
        if (nums.length < 3) {
            return resList;
        }
        Arrays.sort(nums);
        int length = nums.length;
        for (int first = 0; first < length; first++) {
            if (first > 0 && nums[first] == nums[first - 1]) {
                continue;
            }
            int target = -nums[first];
            int third = length - 1;
            for (int second = first + 1; second < length; second++) {
                if (second == third) {
                    break;
                }
                if (second > first + 1 && nums[second] == nums[second - 1]) {
                    continue;
                }
                while (third > second + 1 && nums[second] + nums[third] > target) {
                    third--;
                }
                if (nums[second] + nums[third] == target) {
                    List<Integer> current = new ArrayList<>();
                    current.add(nums[first]);
                    current.add(nums[second]);
                    current.add(nums[third]);
                    resList.add(current);
                }
            }
        }
        return resList;
    }

    // 超时的解法
    public static List<List<Integer>> threeSumTimeOut(int[] nums) {
        List<List<Integer>> resList = new ArrayList<>();
        if (nums.length < 3) {
            return resList;
        }
        Arrays.sort(nums);
        int first = 0;
        int second = 1;
        while (first < nums.length - 2) {
            int currentSecend = second;
            while (currentSecend < nums.length - 1) {
                List<Integer> current = new ArrayList<>();
                current.add(nums[first]);
                current.add(nums[currentSecend]);
                for (int i = currentSecend + 1; i < nums.length; i++) {
                    if (nums[first] + nums[currentSecend] + nums[i] == 0) {
                        current.add(nums[i]);
                        if (!resList.contains(current)) {
                            resList.add(current);
                        }
                        break;
                    }
                }
                currentSecend++;
            }
            first++;
            second++;
        }
        return resList;
    }

    public static void main(String[] args) {
        int[] nums = {3,0,-2,-1,1,2};
        System.out.println(Solution008.threeSum(nums));
    }
}
