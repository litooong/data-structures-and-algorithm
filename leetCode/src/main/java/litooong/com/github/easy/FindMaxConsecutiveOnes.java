package litooong.com.github.easy;

/**
 * @author litooong
 * @date 2021/3/9 10:42 上午
 * No.485: 给定一个二进制数组， 计算其中最大连续 1 的个数。
 */
public class FindMaxConsecutiveOnes {

    public static int findMaxConsecutiveOnes(int[] nums) {
        // 保存结果
        int max = 0;
        // 用于计数
        int count = 0;
        // 遍历数组
        for (int i = 0; i < nums.length; i++) {
            // 如果当前元素为 1， 则计数 + 1
            if (nums[i] == 1) {
                count += 1;
            } else {
                // 否则计数归零
                count = 0;
            }
            // 每次遍历后都更新 max 值
            max = Math.max(max, count);
        }
        return max;
    }

    public static void main(String[] args) {
        System.out.println(findMaxConsecutiveOnes(new int[]{1, 1, 1, 0, 0, 1, 1, 1, 1, 0, 1, 1, 1, 1, 1, 1, 0}));
    }
}
