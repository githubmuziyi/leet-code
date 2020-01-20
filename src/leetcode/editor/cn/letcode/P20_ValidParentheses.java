package leetcode.editor.cn.letcode;

// 标题：有效的括号
//给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串，判断字符串是否有效。 
//
// 有效字符串需满足： 
//
// 
// 左括号必须用相同类型的右括号闭合。 
// 左括号必须以正确的顺序闭合。 
// 
//
// 注意空字符串可被认为是有效字符串。 
//
// 示例 1: 
//
// 输入: "()"
//输出: true
// 
//
// 示例 2: 
//
// 输入: "()[]{}"
//输出: true
// 
//
// 示例 3: 
//
// 输入: "(]"
//输出: false
// 
//
// 示例 4: 
//
// 输入: "([)]"
//输出: false
// 
//
// 示例 5: 
//
// 输入: "{[]}"
//输出: true 
// Related Topics 栈 字符串

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class P20_ValidParentheses{
    public static void main(String[] args) {
        Solution solution = new P20_ValidParentheses().new Solution();
        // 添加测试用例
        String s = ")}{({))[{{[}";
        System.out.println(solution.isValid(s));
    }
    
    

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean isValid(String s) {
        if (s.length() == 0) {
            return true;
        }
        if (s.length() % 2 != 0) {
            return false;
        }
        Map<Character, Character> flagMap = new HashMap<Character, Character>(3) {{
            put('(', ')');
            put('[', ']');
            put('{', '}');
        }};
        if (s.length() == 2) {
            if (flagMap.containsKey(s.charAt(0))) {
                return flagMap.get(s.charAt(0)).equals(s.charAt(1));
            }
            return false;
        }
        Stack<Character> stack = new Stack<Character>();
        for (int i = 0; i < s.length(); i++) {
            Character character = s.charAt(i);
            if (flagMap.containsKey(character)) {
                stack.push(character);
            } else {
                if (stack.isEmpty()) {
                    return false;
                }
                Character top = stack.pop();
                if (!flagMap.get(top).equals(character)) {
                   return false;
                }
            }
        }
        return stack.isEmpty();
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}