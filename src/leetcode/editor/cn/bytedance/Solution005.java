package leetcode.editor.cn.bytedance;

import java.util.Stack;

/**
 * 给定一个字符串，逐个翻转字符串中的每个单词。
 *
 * 示例 1：
 *
 * 输入: "the sky is blue"
 * 输出: "blue is sky the"
 * 示例 2：
 *
 * 输入: "  hello world!  "
 * 输出: "world! hello"
 * 解释: 输入字符串可以在前面或者后面包含多余的空格，但是反转后的字符不能包括。
 * 示例 3：
 *
 * 输入: "a good   example"
 * 输出: "example good a"
 * 解释: 如果两个单词间有多余的空格，将反转后单词间的空格减少到只含一个。
 *
 *
 * 说明：
 *
 * 无空格字符构成一个单词。
 * 输入字符串可以在前面或者后面包含多余的空格，但是反转后的字符不能包括。
 * 如果两个单词间有多余的空格，将反转后单词间的空格减少到只含一个。
 *
 *
 * 进阶：
 *
 * 请选用 C 语言的用户尝试使用 O(1) 额外空间复杂度的原地解法。
 *
 * @author ziwen
 * @since 2020-09-14 16:57
 */
public class Solution005 {

    public static String reverseWords(String s) {
        if (s == null || s.length() <= 0) {
            return "";
        }
        String[] wordsArr = s.split(" ");
        Stack<String> wordStack = new Stack<>();
        for (int i = 0; i < wordsArr.length; i++) {
            String s1 = wordsArr[i].replace(" ", "");
            if (!s1.equals("")) {
                wordStack.push(s1);
            }
        }
        if (wordStack.size() <= 0) {
            return "";
        }
        StringBuilder builder = new StringBuilder();
        while (!wordStack.empty()) {
            builder.append(wordStack.pop());
            builder.append(" ");
        }
        return builder.toString().trim();
    }

    public static void main(String[] args) {
        System.out.println(Solution005.reverseWords("a good   example"));
    }
}
