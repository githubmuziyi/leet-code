package leetcode.editor.cn.bytedance;

/**
 * 反转一个单链表。
 *
 * 示例:
 *
 * 输入: 1->2->3->4->5->NULL
 * 输出: 5->4->3->2->1->NULL
 * 进阶:
 * 你可以迭代或递归地反转链表。你能否用两种方法解决这道题？
 *
 * @author ziwen
 * @since 2020-09-19 16:56
 */
public class Solution018 {

    public static class ListNode {
      int val;
      ListNode next;
      ListNode(int x) { val = x; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public static ListNode reverseList(ListNode head) {
       if (head == null || head.next == null) {
           return head;
       }
       ListNode listNode = reverseList(head.next);
       head.next.next = head;
       head.next = null;
       return listNode;
    }

    public static void main(String[] args) {
        ListNode listNode003 = new ListNode(4);
        ListNode listNode002 = new ListNode(2, listNode003);
        ListNode listNode001 = new ListNode(1, listNode002);

        System.out.println(Solution018.reverseList(listNode001));
    }
}
