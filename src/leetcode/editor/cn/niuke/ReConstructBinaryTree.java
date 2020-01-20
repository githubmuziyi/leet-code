package leetcode.editor.cn.niuke;

import leetcode.editor.cn.common.TreeNode;

/**
 * 输入某二叉树的前序遍历和中序遍历的结果，
 * 请重建出该二叉树。假设输入的前序遍历和中序遍历的结果中都不含重复的数字。
 * 例如输入前序遍历序列{1,2,4,7,3,5,6,8}和中序遍历序列{4,7,2,1,5,3,8,6}，
 * 则重建二叉树并返回。
 */
public class ReConstructBinaryTree {

    public static void main(String[] args) {
        int[] pre = new int[] {1,2,4,3,5,6};
        int[] in = new int[] {4,2,1,5,3,6};
        System.out.println(reConstructBinaryTree(pre, in));
    }

    // [1,2,4,3,5,6],[4,2,1,5,3,6] -> {1,2,3,4,#,5,6}
    public static TreeNode reConstructBinaryTree(int [] pre,int [] in) {
        int preIndex = 0;
        int inIndex = 0;
        TreeNode root = new TreeNode(pre[preIndex]);
        while (inIndex < in.length && in[inIndex] != pre[preIndex]) {
            inIndex++;
        }

        if (inIndex > 0) {
            int[] preLeft = new int[inIndex];
            System.arraycopy(pre, 1, preLeft, 0, inIndex);
            int[] inLeft = new int[inIndex];
            System.arraycopy(in, 0, inLeft, 0, inIndex);
            root.left = reConstructBinaryTree(preLeft, inLeft);
        }

        if (pre.length - inIndex - 1 > 0) {
            int[] preRight = new int[pre.length - inIndex - 1];
            System.arraycopy(pre, inIndex + 1, preRight, 0, pre.length - inIndex - 1);
            int[] inRight = new int[in.length - inIndex - 1];
            System.arraycopy(in, inIndex + 1, inRight, 0, pre.length - inIndex - 1);
            root.right = reConstructBinaryTree(preRight, inRight);
        }
        return root;
    }
}
