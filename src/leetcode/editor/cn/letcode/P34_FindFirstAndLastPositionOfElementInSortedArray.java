package leetcode.editor.cn.letcode;

// 标题：在排序数组中查找元素的第一个和最后一个位置
//给定一个按照升序排列的整数数组 nums，和一个目标值 target。找出给定目标值在数组中的开始位置和结束位置。 
//
// 你的算法时间复杂度必须是 O(log n) 级别。 
//
// 如果数组中不存在目标值，返回 [-1, -1]。 
//
// 示例 1: 
//
// 输入: nums = [5,7,7,8,8,10], target = 8
//输出: [3,4] 
//
// 示例 2: 
//
// 输入: nums = [5,7,7,8,8,10], target = 6
//输出: [-1,-1] 
// Related Topics 数组 二分查找


public class P34_FindFirstAndLastPositionOfElementInSortedArray{
    public static void main(String[] args) {
        Solution solution = new P34_FindFirstAndLastPositionOfElementInSortedArray().new Solution();
        // 添加测试用例
    }
    
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[] searchRange(int[] nums, int target) {
        int[] res = {-1, -1};
        if (nums.length < 1) {
            return res;
        }
        int midIndex = midSearch(nums, 0 , nums.length - 1, target);
        if (midIndex < 0) {
            return res;
        }
        res[0] = firstIndex(nums, midIndex);
        res[1] = lastIndex(nums, midIndex);
        return res;
    }

    public int firstIndex(int[] nums, int midIndex) {
        int first = midIndex;
        for (int i = midIndex; i >= 0 ; i--) {
            if (nums[i] == nums[midIndex]) {
                first = i;
            } else {
                break;
            }
        }
        return first;
    }

    public int lastIndex(int[] nums, int midIndex) {
        int last = midIndex;
        for (int i = midIndex; i < nums.length ; i++) {
            if (nums[i] == nums[midIndex]) {
                last = i;
            } else {
                break;
            }
        }
        return last;
    }

    public int midSearch(int[] nums, int start, int end, int target) {
        if (start >= end) {
            return nums[start] == target ? start : -1;
        }
        int mid = (start + end) / 2;
        if (target > nums[mid]) {
            return midSearch(nums, mid + 1, end, target);
        } else if (target < nums[mid]) {
            return midSearch(nums, start, mid - 1, target);
        } else if (nums[mid] == target){
            return mid;
        }
        return -1;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}