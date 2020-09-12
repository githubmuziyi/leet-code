package leetcode.editor.cn.letcode;

// 标题：最长公共前缀
//编写一个函数来查找字符串数组中的最长公共前缀。 
//
// 如果不存在公共前缀，返回空字符串 ""。 
//
// 示例 1: 
//
// 输入: ["flower","flow","flight"]
//输出: "fl"
// 
//
// 示例 2: 
//
// 输入: ["dog","racecar","car"]
//输出: ""
//解释: 输入不存在公共前缀。
// 
//
// 说明: 
//
// 所有输入只包含小写字母 a-z 。 
// Related Topics 字符串

public class P14_LongestCommonPrefix{
    public static void main(String[] args) {
        Solution solution = new P14_LongestCommonPrefix().new Solution();
        // 添加测试用例
        String[] strs = new String[] {"flower","flight","flow"};
        String common = solution.longestCommonPrefix(strs);
        System.out.println(common);
    }
    
    

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public String longestCommonPrefix(String[] strs) {
        if (strs.length == 0) {
            return "";
        }
        String prefix = strs[0];
        for (int i = 1; i < strs.length; i++) {
            while (strs[i].indexOf(prefix) != 0) {
                prefix = prefix.substring(0, prefix.length() - 1);
                if (prefix.length() <= 0) {
                    return "";
                }
            }
        }
        return prefix;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}