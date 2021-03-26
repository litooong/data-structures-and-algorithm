package litooong.com.github.easy;


import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

/**
 * @author litooong
 * @date 2021/3/18 11:04 上午
 * No.496 给你两个没有重复元素的数组 nums1 和 nums2，其中nums1是nums2的子集。
 * 请你找出 nums1 中每个元素在 nums2 中的下一个比其大的值。
 * nums1中数字 x 的下一个更大元素是指 x 在 nums2 中对应位置的右边的第一个比 x 大的元素。如果不存在，对应位置输出 -1 。
 * <p>
 * [1,3,4,2]
 * [2,5,1,9,0]
 * [8,3,9,1,4,3,6]
 */
public class NextGreaterElement {

    // Stack + Hashmap
    public int[] nextGreaterElement2(int[] nums1, int[] nums2) {
        // 准备与 nums1 大小相同的数组
        int[] result = new int[nums1.length];
        LinkedList<Integer> stack = new LinkedList<>();
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums2.length; i++) {
            while (!stack.isEmpty() && stack.peek().intValue() < nums2[i]) {
                map.put(stack.pop(), nums2[i]);
            }
            stack.push(nums2[i]);
        }
        while (!stack.isEmpty()) {
            map.put(stack.pop(), -1);
        }
        for (int j = 0; j < nums1.length; j++) {
            result[j] = map.get(nums1[j]);
        }

        return result;
    }

    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        // 准备与 nums1 大小相同的数组
        int[] result = new int[nums1.length];
        // 用于记录每一个num2中的值，所对应的右侧第一个比其大的数
        Map<Integer, Integer> temp = new HashMap<>();
        for (int i = nums2.length - 1; i >= 0; i--) {
            temp.put(nums2[i], -1);
            if (i == nums2.length - 1) {
                continue;
            } else if (nums2[i] < nums2[i + 1]) {
                temp.put(nums2[i], nums2[i + 1]);
            } else {
                // 如果前一次的值比它小，则继续比较前一次值的对应右侧比它大的值
                Integer it = temp.get(nums2[i + 1]);
                while (it != null && it.intValue() != -1) {
                    if (it.intValue() > nums2[i]) {
                        temp.put(nums2[i], it.intValue());
                        break;
                    }
                    it = temp.get(it);
                }
            }
        }
        for (int j = 0; j < nums1.length; j++) {
            result[j] = temp.get(nums1[j]);
        }
        return result;
    }


    public static void main(String[] args) {
        NextGreaterElement nge = new NextGreaterElement();
        int[] nums1 = {2, 4};
        int[] nums2 = {1, 2, 3, 4};
        int[] results = nge.nextGreaterElement(nums1, nums2);
        System.out.println(Arrays.toString(results));
    }


}
