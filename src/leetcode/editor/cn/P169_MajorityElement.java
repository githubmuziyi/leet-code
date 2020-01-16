package leetcode.editor.cn;

// 标题：多数元素
//给定一个大小为 n 的数组，找到其中的多数元素。多数元素是指在数组中出现次数大于 ⌊ n/2 ⌋ 的元素。 
//
// 你可以假设数组是非空的，并且给定的数组总是存在多数元素。 
//
// 示例 1: 
//
// 输入: [3,2,3]
//输出: 3 
//
// 示例 2: 
//
// 输入: [2,2,1,1,1,2,2]
//输出: 2
// 
// Related Topics 位运算 数组 分治算法

public class P169_MajorityElement{
    public static void main(String[] args) {
        Solution solution = new P169_MajorityElement().new Solution();
        // 添加测试用例
        int[] s = new int[] {6,5,5};
        System.out.println(solution.majorityElement(s));
    }
    
    

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int majorityElement(int[] nums) {
        // 分治算法
        // return majorityElement(nums, 0, nums.length - 1);

        // boyer-moore投票算法
        int count = 0;
        Integer point = null;
        for (int num : nums) {
            if (count == 0) {
                point = num;
            }
            count += point == num ? 1 : -1;
        }
        return point;
    }

    private int majorityElement(int[] nums, int start, int end) {
        if (start >= end) {
            return nums[start];
        }

        int middle = (start + end) >>> 1;
        int right = majorityElement(nums, middle + 1, end);
        int left = majorityElement(nums, start, middle);
        if (left == right) {
            return left;
        }

        int rightCount = count(nums, right, start, end);
        int leftCount = count(nums, left, start, end);

        if (leftCount > rightCount) {
            return left;
        }
        return right;
    }

    private int count(int[] nums, int num, int start, int end) {
        int count = 0;
        for (int i = start; i <= end; i++) {
            if (nums[i] == num) {
                count++;
            }
        }
        return count;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}