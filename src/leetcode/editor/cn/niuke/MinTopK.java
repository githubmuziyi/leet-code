package leetcode.editor.cn.niuke;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * 输入n个整数，找出其中最小的K个数。例如输入4,5,1,6,2,7,3,8这8个数字，则最小的4个数字是1,2,3,4
 */
public class MinTopK {

    public static ArrayList<Integer> GetLeastNumbers_Solution(int [] input, int k) {
        ArrayList<Integer> list = new ArrayList<>(k);
        if (k > input.length || k <= 0) {
            return list;
        }
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<Integer>(
                new Comparator<Integer>() {
                    @Override
                    public int compare(Integer o1, Integer o2) {
                        return o2 - o1;
                    }
                });
        for (int i : input) {
            if (priorityQueue.size() < k) {
                priorityQueue.offer(i);
            } else if (priorityQueue.peek() > i) {
                priorityQueue.poll();
                priorityQueue.offer(i);
            }
        }
        for (int i = 0; i < k && !priorityQueue.isEmpty(); i++) {
            list.add(priorityQueue.poll());
        }
        return list;
    }

    public static void main(String[] args) {
        int [] input = {4,5,1,6,2,7,3,8};
        ArrayList list = GetLeastNumbers_Solution(input, 4);
        System.out.println(list);
    }
}
