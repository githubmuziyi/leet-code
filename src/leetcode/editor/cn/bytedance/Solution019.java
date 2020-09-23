package leetcode.editor.cn.bytedance;

import leetcode.editor.cn.common.ListNode;

/**
 * 给出两个 非空 的链表用来表示两个非负的整数。其中，它们各自的位数是按照 逆序 的方式存储的，并且它们的每个节点只能存储 一位 数字。
 *
 * 如果，我们将这两个数相加起来，则会返回一个新的链表来表示它们的和。
 *
 * 您可以假设除了数字 0 之外，这两个数都不会以 0 开头。
 *
 * 示例：
 *
 * 输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
 * 输出：7 -> 0 -> 8
 * 原因：342 + 465 = 807
 *
 *
 * @author ziwen
 * @since 2020-09-21 18:02
 */
public class Solution019 {

    class Solution {
        public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
            // 虚拟头节点
            ListNode start = new ListNode(0);
            ListNode index = start;
            while (l1 != null && l2 != null) {
                int val = l1.val + l2.val;
                ListNode current = new ListNode(val);
                index.next = current;
                index = current;
                l1 = l1.next;
                l2 = l2.next;
                if (l1 == null) {
                    index.next = l2;
                }
                if (l2 == null) {
                    index.next = l1;
                }
            }
            ListNode res = start.next;
            index = res;
            while (index != null) {
                if (index.val >= 10) {
                    index.val -= 10;
                    if (index.next != null) {
                        index.next.val += 1;
                    } else {
                        index.next = new ListNode(1);
                    }
                }
                index = index.next;
            }
            return res;
        }
    }
}
