package leetcode.editor.cn.bytedance;

import java.util.Deque;
import java.util.HashMap;
import java.util.concurrent.LinkedBlockingDeque;

/**
 * 运用你所掌握的数据结构，设计和实现一个  LRU (最近最少使用) 缓存机制。它应该支持以下操作： 获取数据 get 和 写入数据 put 。
 *
 * 获取数据 get(key) - 如果关键字 (key) 存在于缓存中，则获取关键字的值（总是正数），否则返回 -1。
 * 写入数据 put(key, value) - 如果关键字已经存在，则变更其数据值；如果关键字不存在，则插入该组「关键字/值」。当缓存容量达到上限时，
 * 它应该在写入新数据之前删除最久未使用的数据值，从而为新的数据值留出空间。
 *
 *
 *
 * 进阶:
 *
 * 你是否可以在 O(1) 时间复杂度内完成这两种操作？
 *
 * @author ziwen
 * @since 2020-09-22 10:06
 */
public class LRUCache {

    private HashMap<Integer, Integer> cache;
    private Deque<Integer> keyDeque;
    private int size;

    public LRUCache(int capacity) {
        cache = new HashMap<>(capacity);
        keyDeque = new LinkedBlockingDeque<>(capacity);
        size = capacity;
    }

    public int get(int key) {
        if (cache.containsKey(key)) {
            keyDeque.remove(key);
            keyDeque.addFirst(key);
            return cache.get(key);
        }
        return -1;
    }

    public void put(int key, int value) {
        if (cache.size() >= size) {
            if (!cache.containsKey(key)) {
                cache.remove(keyDeque.removeLast());
            }
        }
        cache.put(key, value);
        if (cache.containsKey(key)) {
            keyDeque.remove(key);
        }
        keyDeque.addFirst(key);
    }
}
