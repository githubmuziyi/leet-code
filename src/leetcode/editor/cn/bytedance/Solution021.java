package leetcode.editor.cn.bytedance;

import leetcode.editor.cn.common.ListNode;

/**
 * 给你一个链表数组，每个链表都已经按升序排列。
 *
 * 请你将所有链表合并到一个升序链表中，返回合并后的链表。
 *
 *
 *
 * 示例 1：
 *
 * 输入：lists = [[1,4,5],[1,3,4],[2,6]]
 * 输出：[1,1,2,3,4,4,5,6]
 * 解释：链表数组如下：
 * [
 *   1->4->5,
 *   1->3->4,
 *   2->6
 * ]
 * 将它们合并到一个有序链表中得到。
 * 1->1->2->3->4->4->5->6
 * 示例 2：
 *
 * 输入：lists = []
 * 输出：[]
 * 示例 3：
 *
 * 输入：lists = [[]]
 * 输出：[]
 *
 *
 * 提示：
 *
 * k == lists.length
 * 0 <= k <= 10^4
 * 0 <= lists[i].length <= 500
 * -10^4 <= lists[i][j] <= 10^4
 * lists[i] 按 升序 排列
 * lists[i].length 的总和不超过 10^4
 *
 * @author ziwen
 * @since 2020-09-21 20:13
 */
public class Solution021 {

    public static ListNode mergeKLists(ListNode[] lists) {
        if (lists.length <= 0) {
            return null;
        }
        int length = lists.length;
        ListNode res = mergeLists(lists, 0, length - 1);
        return res;
    }

    public static ListNode mergeLists(ListNode[] listNodes, int start, int end) {
        // 终止条件
        if (start >= end) {
            return listNodes[start];
        }
        int middle = (end + start) / 2;
        ListNode left = mergeLists(listNodes, start, middle);
        ListNode right = mergeLists(listNodes, middle + 1, end);
        ListNode res = mergeListNode(left, right);
        return res;
    }

    /**
     * 合并两个有序链表
     * @param l1
     * @param l2
     * @return
     */
    public static ListNode mergeListNode(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }
        ListNode start = new ListNode(0);
        ListNode index = start;
        while (l1 != null && l2 != null) {
            if (l1.val <= l2.val) {
                index.next = l1;
                l1 = l1.next;
            } else {
                index.next = l2;
                l2 = l2.next;
            }
            index.next.next = null;
            index = index.next;
            if (l1 == null) {
                index.next = l2;
            }
            if (l2 == null) {
                index.next = l1;
            }
        }
        return start.next;
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(4);
        ListNode l3 = new ListNode(5);
        l1.next = l2;
        l2.next = l3;

        ListNode l4 = new ListNode(1);
        ListNode l5 = new ListNode(3);
        ListNode l6 = new ListNode(4);
        l4.next = l5;
        l5.next = l6;

        ListNode l8 = new ListNode(2);
        ListNode l9 = new ListNode(6);
        l8.next = l9;

        System.out.println(Solution021.mergeKLists(new ListNode[] {l1, l4, l8}));
    }
}
