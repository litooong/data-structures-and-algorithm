package litooong.com.github.medium;

/**
 * No. 209 给定一个含有 n 个正整数的数组和一个正整数 target 。
 * <p>
 * 找出该数组中满足其和 ≥ target 的长度最小的 连续子数组 [numsl, numsl+1, ..., numsr-1, numsr] ，
 * <p>
 * 并返回其长度。如果不存在符合条件的子数组，返回 0 。
 */
public class MinSubArrayLen {
    public static void main(String[] args) {
        MinSubArrayLen len = new MinSubArrayLen();
        System.out.println(len.minSubArrayLen(7, new int[]{5}));
    }
    public int minSubArrayLen(int target, int[] nums) {
        int result = 0;
        // 子数组的长度范围 1 ~ nums.length
        int low = 1;
        int high = nums.length;
         int middle = (low + high) / 2;
        // 如果 sumMax(nums, low) >= target 则返回 1
        // 如果 sumMax(nums, high) < target 则返回 0
        do {
            if (sumMax(nums, high) < target) {
                return 0;
            }

            if (sumMax(nums, low) >= target) {
                return low;
            }

            if (sumMax(nums, middle) < target) {
                low = middle + 1;
                middle = (low + high) / 2;
            } else {
                high = middle;
                middle = (low + high) / 2;
            }
        } while (high > low);

//        while (high > low) {
//        }
        // 循环完毕后，high == middle == low
        return middle;
    }

    /**
     * 计算 arr 数组中定长 num 子数组之最大和
     * 约定：num <= arr.length
     *
     * @param arr
     * @param num
     * @return
     */
    private int sumMax(int[] arr, int num) {
        int max = 0;
        // 1. 前 num 个数之和，给 max 赋初始值
        for (int i = 0; i < num; i++) {
            max += arr[i];
        }
        // 滑动：index 为指针，首先指向 num，即为上一步加完后的下一个元素
        int indexFrom = 0;
        int indexTo = num;
        int sum = max;
        while (indexTo < arr.length) {
            sum = sum - arr[indexFrom] + arr[indexTo];
            max = sum > max ? sum : max;
            indexFrom++;
            indexTo++;
        }
        return max;
    }
}
