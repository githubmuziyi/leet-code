package leetcode.editor.cn.bytedance;

import java.util.LinkedList;

/**
 * 给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。
 *
 * 示例 1:
 *
 * 输入: "abcabcbb"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
 * 示例 2:
 *
 * 输入: "bbbbb"
 * 输出: 1
 * 解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
 * 示例 3:
 *
 * 输入: "pwwkew"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
 *      请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
 * @author ziwen
 * @since 2020-09-06 21:19
 */
public class Solution001 {

    public static int lengthOfLongestSubstring(String s) {
        LinkedList<Character> list = new LinkedList<>();
        int max = 0;
        for (int i = 0; i < s.length(); i++) {
            if (list.contains(s.charAt(i))) {
                String ss = s.substring(s.indexOf(s.charAt(i)) + 1);
                return Math.max(lengthOfLongestSubstring(ss), max);
            } else {
                list.add(s.charAt(i));
                max++;
            }
        }
        return max;
    }

    public static void main(String[] args) {
        System.out.println(Solution001.lengthOfLongestSubstring("dvdf"));
    }
}
