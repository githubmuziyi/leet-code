package leetcode.editor.cn.bytedance;

/**
 * 将两个升序链表合并为一个新的 升序 链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。
 *
 *
 *
 * 示例：
 *
 * 输入：1->2->4, 1->3->4
 * 输出：1->1->2->3->4->4
 *
 * @author ziwen
 * @since 2020-09-19 15:47
 */
public class Solution017 {

    public static class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        // 伪头节点
        ListNode dum = new ListNode(0), cur = dum;
        while(l1 != null && l2 != null) {
            if(l1.val < l2.val) {
                cur.next = l1;
                l1 = l1.next;
            }
            else {
                cur.next = l2;
                l2 = l2.next;
            }
            cur = cur.next;
        }
        cur.next = l1 != null ? l1 : l2;
        return dum.next;
    }

    public static void main(String[] args) {
        ListNode listNode003 = new ListNode(4);
        //ListNode listNode002 = new ListNode(2, listNode003);
        //ListNode listNode001 = new ListNode(1, listNode002);

        ListNode listNode300 = new ListNode(5);
        //ListNode listNode200 = new ListNode(3, listNode300);
        //ListNode listNode100 = new ListNode(1, listNode200);

        System.out.println(Solution017.mergeTwoLists(listNode003, listNode300));
    }
}
