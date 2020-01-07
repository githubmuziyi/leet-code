package leetcode.editor.cn;

// 标题：报数
//「外观数列」是一个整数序列，从数字 1 开始，序列中的每一项都是对前一项的描述。前五项如下： 
//
// 1.     1
//2.     11
//3.     21
//4.     1211
//5.     111221
// 
//
// 1 被读作 "one 1" ("一个一") , 即 11。 
//11 被读作 "two 1s" ("两个一"）, 即 21。 
//21 被读作 "one 2", "one 1" （"一个二" , "一个一") , 即 1211。 
//
// 给定一个正整数 n（1 ≤ n ≤ 30），输出外观数列的第 n 项。 
//
// 注意：整数序列中的每一项将表示为一个字符串。 
//
// 
//
// 示例 1: 
//
// 输入: 1
//输出: "1"
// 
//
// 示例 2: 
//
// 输入: 4
//输出: "1211"
// 
// Related Topics 字符串

import java.util.ArrayList;
import java.util.List;

public class P38_CountAndSay{
    public static void main(String[] args) {
        Solution solution = new P38_CountAndSay().new Solution();
        // 添加测试用例
        System.out.println(solution.countAndSay(4));
    }
    
    

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public String countAndSay(int n) {
        if (n == 1) {
            return "1";
        }
        return transfo(countAndSay(n-1));
    }

    private String transfo(String s) {
        List<Character> sameCount = new ArrayList<Character>(3);
        sameCount.add(s.charAt(0));
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == sameCount.get(0)) {
                sameCount.add(s.charAt(i));
            } else {
                stringBuilder.append(sameCount.size()).append(sameCount.get(0));
                sameCount.clear();
                sameCount.add(s.charAt(i));
            }
        }
        if (sameCount.size() > 0) {
            return stringBuilder.append(sameCount.size()).append(sameCount.get(0)).toString();
        }
        return stringBuilder.toString();
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}