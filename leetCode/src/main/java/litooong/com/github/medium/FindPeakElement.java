package litooong.com.github.medium;

/**
 * No.162
 * 峰值元素是指其值大于左右相邻值的元素。
 * <p>
 * 给你一个输入数组 nums，找到峰值元素并返回其索引。数组可能包含多个峰值，在这种情况下，返回 任何一个峰值 所在位置即可。
 * <p>
 * 你可以假设 nums[-1] = nums[n] = -∞ 。
 */
public class FindPeakElement {

    public static void main(String[] args) {
        System.out.println(findPeakElement(new int[]{1, 2, 3, 1}));
    }
    public static int findPeakElement(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            //第一个元素
            if (i == 0) {
                // 如果数组中只有一个元素，则直接返回 0
                if (i + 1 == nums.length) {
                    return i;
                }
                if (nums[i + 1] < nums[i]) {
                    return i;
                }
                continue;
            }

            // 最后一个元素
            if (i == nums.length - 1) {
                if (nums[nums.length - 1] > nums[nums.length - 2]) {
                    return i;
                }
                continue;
            }

            // 中间元素
            if (nums[i] > nums[i - 1] && nums[i] < nums[i + 1]) {
                return i;
            }
        }
        return -1;
    }
}
