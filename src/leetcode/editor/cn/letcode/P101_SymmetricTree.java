package leetcode.editor.cn.letcode;

// 标题：对称二叉树
//给定一个二叉树，检查它是否是镜像对称的。 
//
// 例如，二叉树 [1,2,2,3,4,4,3] 是对称的。 
//
//    1
//   / \
//  2   2
// / \ / \
//3  4 4  3
// 
//
// 但是下面这个 [1,2,2,null,3,null,3] 则不是镜像对称的: 
//
//    1
//   / \
//  2   2
//   \   \
//   3    3
// 
//
// 说明: 
//
// 如果你可以运用递归和迭代两种方法解决这个问题，会很加分。 
// Related Topics 树 深度优先搜索 广度优先搜索

import leetcode.editor.cn.common.TreeNode;

public class P101_SymmetricTree{
    public static void main(String[] args) {
        Solution solution = new P101_SymmetricTree().new Solution();
        // 添加测试用例
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(2);
        TreeNode node4 = new TreeNode(3);
        TreeNode node5 = new TreeNode(4);
        TreeNode node6 = new TreeNode(4);
        TreeNode node7 = new TreeNode(3);
        node1.left = node2;
        node1.right = node3;
        node2.left = node4;
        node2.right = node5;
        node3.left = node6;
        node3.right = node7;
        System.out.println(solution.isSymmetric(node1));
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
    public boolean isSymmetric(TreeNode root) {
        return isSymmetryTree(root, root);
    }

    // 判断数组是否对称
    public boolean isSymmetryTree(TreeNode node1, TreeNode node2) {
        if (node1 == null && node2 == null) {
            return true;
        }
        if (node1 == null || node2 == null) {
            return false;
        }
        if (node1.val == node2.val
                && isSymmetryTree(node1.left, node2.right)
                && isSymmetryTree(node1.right, node2.left)) {
            return true;
        }
        return false;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}