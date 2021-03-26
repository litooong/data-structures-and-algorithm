package litooong.com.github.easy;

/**
 * @author litooong
 * @date 2021/3/26 5:00 下午
 * No.705 不使用任何内建的哈希表库设计一个哈希集合（HashSet）。
 *
 * 实现 MyHashSet 类：
 *
 * void add(key) 向哈希集合中插入值 key 。
 * bool contains(key) 返回哈希集合中是否存在这个值 key 。
 * void remove(key) 将给定值 key 从哈希集合中删除。如果哈希集合中没有这个值，什么也不做。
 */
public class MyHashSet {

    private static final int INIT = 16;
    private int[] arr;

    /** Initialize your data structure here. */
    public MyHashSet() {
        arr = new int[INIT];
        arr[0] = -1;
    }

    public void add(int key) {
        if (key >= arr.length) {
            expansion(key);
        }
        arr[key] = key;
    }

    /**
     * 扩容 + 数组拷贝
     * @param key
     */
    private void expansion(int key) {
        int[] exn = new int[key < Integer.MAX_VALUE / 2 ? key * 2 : Integer.MAX_VALUE];
        System.arraycopy(arr,0,exn,0,arr.length);
        arr = exn;
    }

    public void remove(int key) {
        if (key >= arr.length) {
            return;
        }
        arr[key] = -1;
    }

    /** Returns true if this set contains the specified element */
    public boolean contains(int key) {
        if (key >= arr.length) {
            return false;
        }
        return arr[key] == key;
    }
}
