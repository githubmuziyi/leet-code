package leetcode.editor.cn.bytedance;

import leetcode.editor.cn.common.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 给定一个二叉树，返回其节点值的锯齿形层次遍历。（即先从左往右，再从右往左进行下一层遍历，以此类推，层与层之间交替进行）。
 *
 * 例如：
 * 给定二叉树 [3,9,20,null,null,15,7],
 *
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * 返回锯齿形层次遍历如下：
 *
 * [
 *   [3],
 *   [20,9],
 *   [15,7]
 * ]
 *
 * @author ziwen
 * @since 2020-09-23 11:34
 */
public class Solution027 {

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        Stack<TreeNode> queue = new Stack<>();
        Stack<TreeNode> stack = new Stack<>();
        queue.add(root);
        List<Integer> levelNum = new ArrayList<>();
        while (true) {
            while (!queue.isEmpty()) {
                TreeNode cur = queue.pop();
                levelNum.add(cur.val);
                if (cur.left != null) {
                    stack.add(cur.left);
                }
                if (cur.right != null) {
                    stack.add(cur.right);
                }
                if (queue.isEmpty()) {
                    res.add(new ArrayList<>(levelNum));
                    levelNum.clear();
                }
            }
            if (stack.isEmpty()) {
                break;
            }
            while (!stack.isEmpty()) {
                TreeNode cur = stack.pop();
                levelNum.add(cur.val);
                if (cur.right != null) {
                    queue.add(cur.right);
                }
                if (cur.left != null) {
                    queue.add(cur.left);
                }
                if (stack.isEmpty()) {
                    res.add(new ArrayList<>(levelNum));
                    levelNum.clear();
                }
            }
            if (queue.isEmpty()) {
                break;
            }
        }
        return res;
    }

}
