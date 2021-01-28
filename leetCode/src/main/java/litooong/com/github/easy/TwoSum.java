package litooong.com.github.easy;

import java.util.HashMap;
import java.util.Map;

/**
 * @author litong
 * @date 2020/12/22 10:57 下午
 * @Description 给定一个数组和一个目标和，从数组中找两个数字相加等于目标和，输出这两个数字的下标
 */
public class TwoSum {

    /**
     * 解法2：借助HashMap
     * 时间复杂度：O(n)
     */
    public static int[] twoSum2(int[] arr, int target) {
        Map<Integer,Integer> tempMap = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            int sub = target - arr[i];
            if (tempMap.containsKey(sub)) {
                return new int[]{i, tempMap.get(sub)};
            }
            tempMap.put(arr[i], 1);
        }
        throw new IllegalArgumentException("No two sum solution");
    }
    /**
     * 解法1：简单粗暴，两层for循环遍历所有情况
     * 时间复杂度：O(n^2)
     */
    public static int[] twoSum1(int[] arr, int target) {
        int[] result = new int[2];
        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[i] + arr[j] == target) {
                    result[0] = i;
                    result[1] = j;
                }
            }
        }
        return result;
    }
}
