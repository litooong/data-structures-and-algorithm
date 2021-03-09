package litooong.com.github.easy;

import java.util.Arrays;

/**
 * @author litooong
 * @date 2021/3/9 10:52 上午
 * No.283 : 给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。
 * 必须在原数组上操作，不能拷贝额外的数组。
 * 尽量减少操作次数。
 */
public class MoveZeros {
    public static void moveZeroes(int[] nums) {
        int index = 0;
        // 遍历数组
        for (int i = 0; i < nums.length; i++) {
            // 找到一个不为 0 的数字，把它放到index处
            if (nums[i] != 0) {
                nums[index++] = nums[i];
            }
        }
        // 遍历完成后，该数组前index项即为跳过0的项，后面剩下的则全部为0
        for (int j = index; j < nums.length; j++) {
            nums[j] = 0;
        }
    }

    public static void main(String[] args) {
        int[] arr = {0, 1, 0, 3, 12};
        moveZeroes(arr);
        System.out.println(Arrays.toString(arr));

    }
}
