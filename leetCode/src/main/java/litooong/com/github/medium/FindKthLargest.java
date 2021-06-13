package litooong.com.github.medium;

import java.util.Collections;
import java.util.PriorityQueue;

/**
 * No.215 在未排序的数组中找到第 k 个最大的元素。请注意，你需要找的是数组排序后的第 k 个最大的元素，而不是第 k 个不同的元素。
 */
public class FindKthLargest {
    public static int findKthLargest(int[] nums, int k) {
        // 创建最大堆
        PriorityQueue<Integer> heap = new PriorityQueue<>(Collections.reverseOrder());
        for (int i = 0; i < nums.length; i++) {
            heap.add(Integer.valueOf(nums[i]));
        }
        // 找到第 k 大的元素
        int result = 0;
        for (int i = 0; i < k; i++) {
            result = heap.poll();
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(findKthLargest(new int[]{3, 2, 3, 1, 2, 4, 5, 5, 6}, 4));
    }
}