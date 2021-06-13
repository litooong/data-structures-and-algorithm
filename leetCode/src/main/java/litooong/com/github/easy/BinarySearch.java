package litooong.com.github.easy;

/**
 * No. 704 二分查找
 * 给定一个元素有序的（升序）整型数组 nums 和一个目标值 target ，写一个函数搜索 nums 中的 target，如果目标值存在返回下标，否则返回 -1。
 */
public class BinarySearch {
    public int search(int[] nums, int target) {
        int low = 0;
        int high = nums.length - 1;
        int middle;
        while (high >= low) {
            middle = (low + high) / 2;
            if (target == nums[middle]) {
                return middle;
            }
            if (target > nums[middle]) {
                low = middle + 1;
            }
            if (target < nums[middle]) {
                high = middle - 1;
            }
        }
        return -1;
    }
}
