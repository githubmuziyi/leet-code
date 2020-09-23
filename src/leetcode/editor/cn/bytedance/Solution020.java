package leetcode.editor.cn.bytedance;

import leetcode.editor.cn.common.ListNode;

import java.util.PriorityQueue;

/**
 * 在 O(n log n) 时间复杂度和常数级空间复杂度下，对链表进行排序。
 *
 * 示例 1:
 *
 * 输入: 4->2->1->3
 * 输出: 1->2->3->4
 * 示例 2:
 *
 * 输入: -1->5->3->4->0
 * 输出: -1->0->3->4->5
 *
 *
 * @author ziwen
 * @since 2020-09-21 19:38
 */
public class Solution020 {

    public ListNode sortList(ListNode head) {
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        while (head != null) {
            queue.add(head.val);
            head = head.next;
        }
        ListNode start = new ListNode(0);
        ListNode index = start;
        while (!queue.isEmpty()) {
            index.next = new ListNode(queue.remove());
            index = index.next;
        }
        return start.next;
    }
}
