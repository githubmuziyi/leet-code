package leetcode.editor.cn.bytedance;

/**
 * 编写一个函数来查找字符串数组中的最长公共前缀。
 *
 * 如果不存在公共前缀，返回空字符串 ""。
 *
 * 示例 1:
 *
 * 输入: ["flower","flow","flight"]
 * 输出: "fl"
 * 示例 2:
 *
 * 输入: ["dog","racecar","car"]
 * 输出: ""
 * 解释: 输入不存在公共前缀。
 * 说明:
 *
 * 所有输入只包含小写字母 a-z
 *
 * @author ziwen
 * @since 2020-09-12 14:08
 */
public class Solution002 {
    public static String longestCommonPrefix(String[] strs) {
        if (strs.length <= 0) {
            return "";
        }
        String commonPre = strs[0];
        for (int i = 1; i < strs.length; i++) {
            while (strs[i].indexOf(commonPre) != 0) {
                commonPre = commonPre.substring(0, commonPre.length() - 1);
                if (commonPre.length() <= 0) {
                    return "";
                }
            }
        }
        return commonPre;
    }

    public static void main(String[] args) {
        String[] strs = {"flower","flow","flight"};
        System.out.println(Solution002.longestCommonPrefix(strs));
    }
}
