package leetcode.editor.cn.bytedance;

/**
 * 给定两个以字符串形式表示的非负整数 num1 和 num2，返回 num1 和 num2 的乘积，它们的乘积也表示为字符串形式。
 *
 * 示例 1:
 *
 * 输入: num1 = "2", num2 = "3"
 * 输出: "6"
 * 示例 2:
 *
 * 输入: num1 = "123", num2 = "456"
 * 输出: "56088"
 * 说明：
 *
 * num1 和 num2 的长度小于110。
 * num1 和 num2 只包含数字 0-9。
 * num1 和 num2 均不以零开头，除非是数字 0 本身。
 * 不能使用任何标准库的大数类型（比如 BigInteger）或直接将输入转换为整数来处理。
 *
 * @author ziwen
 * @since 2020-09-14 15:38
 */
public class Solution004 {

    public static String multiply(String num1, String num2) {
        if ("0".equals(num2) || "0".equals(num1)) {
            return "0";
        }
        int m = num1.length();
        int n = num2.length();
        int[] ansArr = new int[m + n];
        for (int i = m - 1; i >= 0 ; i--) {
            // 转化为int类型
            int x = num1.charAt(i) - '0';
            for (int j = n - 1; j >= 0; j--) {
                ansArr[i+j+1] += x * (num2.charAt(j) - '0');
            }
        }
        // 进位处理
        for (int i = m + n - 1; i > 0 ; i--) {
            int y = ansArr[i];
            ansArr[i] = y % 10;
            ansArr[i - 1] += y / 10;
        }
        StringBuilder builder = new StringBuilder();
        int startIndex = ansArr[0] == 0 ? 1 : 0;
        for (int i = startIndex; i < m + n; i++) {
            builder.append(ansArr[i]);
        }
        return builder.toString();
    }

    public static void main(String[] args) {
        System.out.println(Solution004.multiply("123", "456"));
    }
}
