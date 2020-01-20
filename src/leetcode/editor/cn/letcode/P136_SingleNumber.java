package leetcode.editor.cn.letcode;

// 标题：只出现一次的数字
//给定一个非空整数数组，除了某个元素只出现一次以外，其余每个元素均出现两次。找出那个只出现了一次的元素。 
//
// 说明： 
//
// 你的算法应该具有线性时间复杂度。 你可以不使用额外空间来实现吗？ 
//
// 示例 1: 
//
// 输入: [2,2,1]
//输出: 1
// 
//
// 示例 2: 
//
// 输入: [4,1,2,1,2]
//输出: 4 
// Related Topics 位运算 哈希表

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// https://blog.csdn.net/jerry99s/article/details/46485417
public class P136_SingleNumber{
    public static void main(String[] args) {
        Solution solution = new P136_SingleNumber().new Solution();
        // 添加测试用例
        int[] nums = new int[] {2,2,1};
        System.out.println(solution.singleNumber(nums));
    }
    
    

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int singleNumber(int[] nums) {
        int a = 0;
        for (int i = 0; i < nums.length; i++) {
            a ^= nums[i];
        }
        return a;
    }

    private int first(int[] nums) {
        if (nums.length <= 0) {
            return 0;
        }
        List<Integer> list = new ArrayList<Integer>();
        for (int i = 0; i < nums.length; i++) {
            if (list.contains(nums[i])) {
                list.remove((Integer) nums[i]);
            } else {
                list.add(nums[i]);
            }
        }
        return list.get(0);
    }

    private int second(int[] nums) {
        if (nums.length <= 0) {
            return 0;
        }
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int i = 0; i < nums.length; i++) {
            if (map.put(nums[i], nums[i]) != null) {
                map.remove(nums[i]);
            }
        }
        for (Map.Entry entry : map.entrySet()) {
            return (Integer) entry.getValue();
        }
        return 0;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}