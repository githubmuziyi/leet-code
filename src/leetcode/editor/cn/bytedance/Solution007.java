package leetcode.editor.cn.bytedance;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个只包含数字的字符串，复原它并返回所有可能的 IP 地址格式。
 *
 * 有效的 IP 地址 正好由四个整数（每个整数位于 0 到 255 之间组成，且不能含有前导 0），整数之间用 '.' 分隔。
 *
 * 例如："0.1.2.201" 和 "192.168.1.1" 是 有效的 IP 地址，
 * 但是 "0.011.255.245"、"192.168.1.312" 和 "192.168@1.1" 是 无效的 IP 地址。
 *
 *
 *
 * 示例 1：
 *
 * 输入：s = "25525511135"
 * 输出：["255.255.11.135","255.255.111.35"]
 * 示例 2：
 *
 * 输入：s = "0000"
 * 输出：["0.0.0.0"]
 * 示例 3：
 *
 * 输入：s = "1111"
 * 输出：["1.1.1.1"]
 * 示例 4：
 *
 * 输入：s = "010010"
 * 输出：["0.10.0.10","0.100.1.0"]
 * 示例 5：
 *
 * 输入：s = "101023"
 * 输出：["1.0.10.23","1.0.102.3","10.1.0.23","10.10.2.3","101.0.2.3"]
 *
 *
 * 提示：
 *
 * 0 <= s.length <= 3000
 * s 仅由数字组成
 *
 * @author ziwen
 * @since 2020-09-14 18:01
 */
public class Solution007 {

    static int count = 4;
    static int[] ipArr = new int[count];
    static List<String> ipList = new ArrayList<>();

    public static List<String> restoreIpAddresses(String s) {
        if (s == null || s.length() < 4 || s.length() > 12) {
            return ipList;
        }
        dfs(s, 0, 0);
        return ipList;
    }

    public static void dfs(String s, int level, int start) {
        // 填充到最后一段ip
        if (level == count) {
            // 字符串刚好使用完成，则代表可以恢复为一个ip地址
            if (start == s.length()) {
                StringBuffer buffer= new StringBuffer();
                for (int i = 0; i < count; ++i) {
                    buffer.append(ipArr[i]);
                    if (i != count - 1) {
                        buffer.append(".");
                    }
                }
                ipList.add(buffer.toString());
            }
            return;
        }
        // 还没到最后一段ip，但是字符串已经使用完了，则代表无法恢复为一个ip
        if (start == s.length()) {
            return;
        }
        // 当字符串的其实字符为0时，则这个字符只能作为一段ip
        if (s.charAt(start) == '0') {
            ipArr[level] = 0;
            dfs(s, level + 1, start + 1);
        }
        // 常规情况
        int address = 0;
        for (int i = start; i < s.length(); i++) {
            address = address * 10 + (s.charAt(i) - '0');
            if (address > 0 && address <= 255) {
                ipArr[level] = address;
                dfs(s, level + 1, i + 1);
            } else {
                break;
            }
        }
    }

    public static void main(String[] args) {
        System.out.println(Solution007.restoreIpAddresses("0000"));
    }
}
