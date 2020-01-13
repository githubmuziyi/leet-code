package leetcode.editor.cn;

// 标题：杨辉三角
//给定一个非负整数 numRows，生成杨辉三角的前 numRows 行。 
//
// 
//
// 在杨辉三角中，每个数是它左上方和右上方的数的和。 
//
// 示例: 
//
// 输入: 5
//输出:
//[
//     [1],
//    [1,1],
//   [1,2,1],
//  [1,3,3,1],
// [1,4,6,4,1]
//] 
// Related Topics 数组

import java.util.ArrayList;
import java.util.List;

public class P118_PascalsTriangle{
    public static void main(String[] args) {
        Solution solution = new P118_PascalsTriangle().new Solution();
        // 添加测试用例
        System.out.println(solution.generate(0));
    }
    
    

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<List<Integer>> generate(int numRows) {
        if (numRows == 0) {
            return new ArrayList<List<Integer>>();
        }
        List<List<Integer>> lists = new ArrayList<List<Integer>>();
        List<Integer> root = new ArrayList<Integer>() {{
            add(1);
        }};
        lists.add(root);
        if (numRows == 1) {
            return lists;
        }
        int level = 1;
        while (level < numRows) {
            List<Integer> next = new ArrayList<Integer>();
            for (int i = 0; i <= level; i++) {
                int sum = i >= root.size() || i - 1 < 0 ? 1 : root.get(i) + root.get(i - 1);
                next.add(sum);
            }
            root = next;
            lists.add(next);
            level++;
        }
        return lists;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}