package litooong.com.github.easy;

/**
 * @author litooong
 * @date 2021/3/9 11:27 上午
 * No.27 移除元素
 */
public class RemoveElement {
    public static int removeElement(int[] nums, int val) {
        int a = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != val) {
                nums[a++] = nums[i];
            }
        }
        return a;
    }
}
