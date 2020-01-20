package leetcode.editor.cn.letcode;

// 标题：罗马数字转整数
//罗马数字包含以下七种字符: I， V， X， L，C，D 和 M。 
//
// 字符          数值
//I             1
//V             5
//X             10
//L             50
//C             100
//D             500
//M             1000 
//
// 例如， 罗马数字 2 写做 II ，即为两个并列的 1。12 写做 XII ，即为 X + II 。 27 写做 XXVII, 即为 XX + V + II 。 
//
// 通常情况下，罗马数字中小的数字在大的数字的右边。但也存在特例，例如 4 不写做 IIII，而是 IV。数字 1 在数字 5 的左边，所表示的数等于大数 5 减小数 1 得到的数值 4 。同样地，数字 9 表示为 IX。这个特殊的规则只适用于以下六种情况： 
//
// 
// I 可以放在 V (5) 和 X (10) 的左边，来表示 4 和 9。 
// X 可以放在 L (50) 和 C (100) 的左边，来表示 40 和 90。 
// C 可以放在 D (500) 和 M (1000) 的左边，来表示 400 和 900。 
// 
//
// 给定一个罗马数字，将其转换成整数。输入确保在 1 到 3999 的范围内。 
//
// 示例 1: 
//
// 输入: "III"
//输出: 3 
//
// 示例 2: 
//
// 输入: "IV"
//输出: 4 
//
// 示例 3: 
//
// 输入: "IX"
//输出: 9 
//
// 示例 4: 
//
// 输入: "LVIII"
//输出: 58
//解释: L = 50, V= 5, III = 3.
// 
//
// 示例 5: 
//
// 输入: "MCMXCIV"
//输出: 1994
//解释: M = 1000, CM = 900, XC = 90, IV = 4. 
// Related Topics 数学 字符串

import java.util.HashMap;
import java.util.Map;

public class P13_RomanToInteger{
    public static void main(String[] args) {
        Solution solution = new P13_RomanToInteger().new Solution();
        // 添加测试用例
        String s = "MDCXCV";
        int res = solution.romanToInt(s);
        System.out.println(res);
    }
    
    

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {

    Map<Character, Integer> romanMap = new HashMap<Character, Integer>() {{
        put('I', 1);
        put('V', 5);
        put('X', 10);
        put('L', 50);
        put('C', 100);
        put('D', 500);
        put('M', 1000);
    }};

    Map<String, Integer> multiRomanMap = new HashMap<String, Integer>() {{
        put("IV", 4);
        put("IX", 9);
        put("XL", 40);
        put("XC", 90);
        put("CD", 400);
        put("CM", 900);
    }};

    public int romanToInt(String s) {
        char[] chars = s.toCharArray();
        Character index = null;
        int romanInt = 0;
        for (int i = 0; i < chars.length; i++) {
            boolean flag = true;
            if (index != null) {
                char[] target = new char[] {index, chars[i]};
                String targetStr = String.valueOf(target);
                if (multiRomanMap.containsKey(targetStr)) {
                    romanInt += multiRomanMap.get(targetStr);
                    index = null;
                    flag = false;
                } else {
                    romanInt += romanMap.get(index);
                }
            }
            if (flag) {
                if (i == chars.length - 1) {
                    romanInt += romanMap.get(chars[i]);
                } else {
                    index = chars[i];
                }
            }
        }
        return romanInt;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}