package leetcode.editor.cn.bytedance;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定两个字符串 s1 和 s2，写一个函数来判断 s2 是否包含 s1 的排列。
 *
 * 换句话说，第一个字符串的排列之一是第二个字符串的子串。
 *
 * 示例1:
 *
 * 输入: s1 = "ab" s2 = "eidbaooo"
 * 输出: True
 * 解释: s2 包含 s1 的排列之一 ("ba").
 *
 *
 * 示例2:
 *
 * 输入: s1= "ab" s2 = "eidboaoo"
 * 输出: False
 *
 *
 * 注意：
 *
 * 输入的字符串只包含小写字母
 * 两个字符串的长度都在 [1, 10,000] 之间
 *
 * @author ziwen
 * @since 2020-09-12 22:58
 */
public class Solution003 {

    /**
     * 只有当两个字符串包含具有相同频率的相同字符时，一个字符串才是另一个字符串的排列。
     * 我们可以考虑与 s1 长度相同的长字符串 s2 中的每个可能的子字符串，并检查出现在两者中的字符出现的频率。
     * 如果每个字母的频率完全匹配，则只有 s1 的排列可以是 s2 的子字符串
     * @param s1
     * @param s2
     * @return
     */
    public static boolean checkInclusion(String s1, String s2) {
        if (s1.length() > s2.length()) {
            return false;
        }
        int[] s1map = new int[26];
        int[] s2map = new int[26];
        for (int i = 0; i < s1.length(); i++) {
            s1map[s1.charAt(i) - 'a']++;
            s2map[s2.charAt(i) - 'a']++;
        }
        for (int i = 0; i < s2.length() - s1.length(); i++) {
            if (match(s1map, s2map)) {
                return true;
            }
            s2map[s2.charAt(i) - 'a']--;
            s2map[s2.charAt(i + s1.length()) - 'a']++;
        }
        return match(s1map, s2map);
    }

    /**
     * 超时的解法
     * @param s1
     * @param s2
     * @return
     */
    public static boolean checkInclusionTimeOut(String s1, String s2) {
        if (s2.length() <= 0) {
            return false;
        }
        List<Character> characters = new ArrayList<>();
        for (int i = 0; i < s1.length(); i++) {
            characters.add(s1.charAt(i));
        }
        for (int i = 0; i < s2.length(); i++) {
            if (characters.contains(s2.charAt(i))) {
                characters.remove((Character) s2.charAt(i));
                if (characters.size() <= 0) {
                    return true;
                }
            } else {
                return checkInclusion(s1, s2.substring(1));
            }
        }
        return false;
    }

    public static boolean match(int[] s1map, int[] s2map) {
        for (int i = 0; i < 26; i++) {
            if (s1map[i] != s2map[i]) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        String s1 = "adc";
        String s2 = "dcda";
        System.out.println(Solution003.checkInclusion(s1, s2));
    }
}
