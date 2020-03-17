package leetcode.editor.cn.letcode;

// 标题：二叉树的中序遍历
//给定一个二叉树，返回它的中序 遍历。 
//
// 示例: 
//
// 输入: [1,null,2,3]
//   1
//    \
//     2
//    /
//   3
//
//输出: [1,3,2] 
//
// 进阶: 递归算法很简单，你可以通过迭代算法完成吗？ 
// Related Topics 栈 树 哈希表

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import leetcode.editor.cn.common.TreeNode;

public class P94_BinaryTreeInorderTraversal{
    public static void main(String[] args) {
        Solution solution = new P94_BinaryTreeInorderTraversal().new Solution();
        // 添加测试用例
    }
    
    //leetcode submit region begin(Prohibit modification and deletion)
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
        Stack<TreeNode> stack = new Stack<TreeNode>();
        List<Integer> list = new ArrayList<Integer>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode node = stack.peek();
            while (node != null) {
                stack.push(node.left);
                node = stack.peek();
            }
            stack.pop();
            if (!stack.isEmpty()) {
                TreeNode node1 = stack.pop();
                list.add(node1.val);
                stack.push(node1.right);
            }
        }
        return list;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}