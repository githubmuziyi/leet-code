package leetcode.editor.cn.letcode;

// 标题：搜索旋转排序数组
//假设按照升序排序的数组在预先未知的某个点上进行了旋转。 
//
// ( 例如，数组 [0,1,2,4,5,6,7] 可能变为 [4,5,6,7,0,1,2] )。 
//
// 搜索一个给定的目标值，如果数组中存在这个目标值，则返回它的索引，否则返回 -1 。 
//
// 你可以假设数组中不存在重复的元素。 
//
// 你的算法时间复杂度必须是 O(log n) 级别。 
//
// 示例 1: 
//
// 输入: nums = [4,5,6,7,0,1,2], target = 0
//输出: 4
// 
//
// 示例 2: 
//
// 输入: nums = [4,5,6,7,0,1,2], target = 3
//输出: -1 
// Related Topics 数组 二分查找


public class P33_SearchInRotatedSortedArray{
    public static void main(String[] args) {
        Solution solution = new P33_SearchInRotatedSortedArray().new Solution();
        // 添加测试用例
        int[] nums = {};
        int target = 3;
        System.out.println(solution.search(nums, target));
    }
    
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int search(int[] nums, int target) {
        if (nums.length <= 0) {
            return -1;
        }
        return search(nums, 0, nums.length - 1, target);
    }

    public int search(int[] nums, int start, int end, int target) {
        if (start >= end) {
            return nums[start] == target ? end : -1;
        }
        int mid = (start + end) / 2;
        int leftIndex = -1;
        int rightIndex = -1;
        if (nums[mid] > nums[start]) {
            leftIndex = midSearch(nums, start, mid, target);
            if (leftIndex >= 0) {
                return leftIndex;
            }
            rightIndex = search(nums, mid + 1, end, target);
            if (rightIndex >= 0) {
                return rightIndex;
            }
        } else {
            leftIndex = search(nums, start, mid, target);
            if (leftIndex >= 0) {
                return leftIndex;
            }
            rightIndex = midSearch(nums, mid + 1, end, target);
            if (rightIndex >= 0) {
                return rightIndex;
            }
        }
        return leftIndex >= 0 ? leftIndex : rightIndex;
    }

    public int midSearch(int[] nums, int start, int end, int target) {
        if (start >= end) {
            return nums[start] == target ? end : -1;
        }
        int mid = (start + end) / 2;
        int index = -1;
        if (target > nums[mid]) {
            index = midSearch(nums, mid + 1, end, target);
        } else if (target < nums[mid]) {
            index = midSearch(nums, start, mid - 1, target);
        } else {
            index = mid;
        }
        return index;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}