package litooong.com.github.easy;

/**
 * No. 35
 * 给定一个排序数组和一个目标值，在数组中找到目标值，并返回其索引。如果目标值不存在于数组中，返回它将会被按顺序插入的位置。
 *
 * 你可以假设数组中无重复元素。
 */
public class SearchInsert {
    public int searchInsert(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return -1;
        }
        if (nums.length == 1) {
            if (target > nums[0]) {
                return 1;
            } else {
                return 0;
            }
        }
        // 升序
        if (nums[0] < nums[nums.length - 1]) {
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
            return high;
        } else {
            // 降序
            int low = nums.length - 1;
            int high = 0;
            int middle;
            while (high <= low) {
                middle = (low + high) / 2;
                if (target == nums[middle]) {
                    return middle;
                }
                if (target > nums[middle]) {
                    low = middle - 1;
                }
                if (target < nums[middle]) {
                    high = middle + 1;
                }
            }
            return low;
        }
    }
}
