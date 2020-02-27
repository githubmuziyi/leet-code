package leetcode.editor.cn.letcode;

// 标题：反转链表
//反转一个单链表。 
//
// 示例: 
//
// 输入: 1->2->3->4->5->NULL
//输出: 5->4->3->2->1->NULL 
//
// 进阶: 
//你可以迭代或递归地反转链表。你能否用两种方法解决这道题？ 
// Related Topics 链表

import leetcode.editor.cn.common.ListNode;

public class P206_ReverseLinkedList{
    public static void main(String[] args) {
        Solution solution = new P206_ReverseLinkedList().new Solution();
        // 添加测试用例
    }
    
    

//leetcode submit region begin(Prohibit modification and deletion)
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode reverseList(ListNode head) {
        ListNode first = null;
        while (head != null) {
            ListNode current = new ListNode(head.val);
            if (first == null) {
                first = current;
            } else {
                current.next = first;
                first = current;
            }
            head = head.next;
        }
        return first;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}