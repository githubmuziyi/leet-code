package leetcode.editor.cn;

// 标题：整数反转
//给出一个 32 位的有符号整数，你需要将这个整数中每位上的数字进行反转。 
//
// 示例 1: 
//
// 输入: 123
//输出: 321
// 
//
// 示例 2: 
//
// 输入: -123
//输出: -321
// 
//
// 示例 3: 
//
// 输入: 120
//输出: 21
// 
//
// 注意: 
//
// 假设我们的环境只能存储得下 32 位的有符号整数，则其数值范围为 [−231, 231 − 1]。请根据这个假设，如果反转后整数溢出那么就返回 0。 
// Related Topics 数学

import java.util.Stack;

public class P7_ReverseInteger{
    public static void main(String[] args) {
        Solution solution = new P7_ReverseInteger().new Solution();
        // 添加测试用例
        int test = -2147483648;
        int res = solution.reverse(test);
        System.out.println(res);
    }
    
    

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int reverse(int x) {
        // 个位数直接返回
        if (-9 <= x && x <= 9) {
            return x;
        }

        // 反转
        char[] chars = String.valueOf(x).toCharArray();
        Stack<Character> stack = new Stack();
        boolean flag = x < 0;
        for (int i = flag ? 1 : 0; i < chars.length; i++) {
            stack.push(chars[i]);
        }
        int size = stack.size();
        char[] resChar = new char[size];
        for (int i = 0; i < size; i++) {
            resChar[i] = stack.pop();
        }
        String resStr = String.valueOf(resChar);
        Long res = Long.valueOf(resStr);
        if (flag) {
            res = (-res);
        }

        // 越界返回
        int min = -1 << 31;
        int max = -(min) - 1;
        if (res > max || res < min) {
            return 0;
        }

        return res.intValue();
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}