package leetcode.editor.cn.letcode;

// 标题：存在重复元素
//给定一个整数数组，判断是否存在重复元素。 
//
// 如果任何值在数组中出现至少两次，函数返回 true。如果数组中每个元素都不相同，则返回 false。 
//
// 示例 1: 
//
// 输入: [1,2,3,1]
//输出: true 
//
// 示例 2: 
//
// 输入: [1,2,3,4]
//输出: false 
//
// 示例 3: 
//
// 输入: [1,1,1,3,3,4,3,2,4,2]
//输出: true 
// Related Topics 数组 哈希表

import java.util.HashSet;

public class P217_ContainsDuplicate{
    public static void main(String[] args) {
        Solution solution = new P217_ContainsDuplicate().new Solution();
        // 添加测试用例
    }
    
    

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean containsDuplicate(int[] nums) {
        HashSet<Integer> set = new HashSet<Integer>();
        for (int i : nums) {
            set.add(i);
        }
        return !(nums.length == set.size());
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}