package leetcode.editor.cn.bytedance;

import java.util.LinkedList;
import java.util.PriorityQueue;

/**
 * 设计一个支持 push ，pop ，top 操作，并能在常数时间内检索到最小元素的栈。
 *
 * push(x) —— 将元素 x 推入栈中。
 * pop() —— 删除栈顶的元素。
 * top() —— 获取栈顶元素。
 * getMin() —— 检索栈中的最小元素。
 *
 *
 * 示例:
 *
 * 输入：
 * ["MinStack","push","push","push","getMin","pop","top","getMin"]
 * [[],[-2],[0],[-3],[],[],[],[]]
 *
 * 输出：
 * [null,null,null,null,-3,null,0,-2]
 *
 * 解释：
 * MinStack minStack = new MinStack();
 * minStack.push(-2);
 * minStack.push(0);
 * minStack.push(-3);
 * minStack.getMin();   --> 返回 -3.
 * minStack.pop();
 * minStack.top();      --> 返回 0.
 * minStack.getMin();   --> 返回 -2.
 *
 *
 * 提示：
 *
 * pop、top 和 getMin 操作总是在 非空栈 上调用。
 *
 * @author ziwen
 * @since 2020-09-22 09:52
 */
public class MinStack {

    private PriorityQueue<Integer> queue;
    private LinkedList<Integer> linkedList;

    /** initialize your data structure here. */
    public MinStack() {
        queue = new PriorityQueue<>();
        linkedList = new LinkedList<>();
    }

    public void push(int x) {
        queue.add(x);
        linkedList.addFirst(x);
    }

    public void pop() {
        int i = linkedList.pop();
        queue.remove(i);
    }

    public int top() {
        return linkedList.peekFirst();
    }

    public int getMin() {
        return queue.peek();
    }

}
