package litooong.com.github.medium;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * No. 1456
 * 给你字符串 s 和整数 k 。
 * 请返回字符串 s 中长度为 k 的单个子字符串中可能包含的最大元音字母数。
 * 英文中的 元音字母 为（a, e, i, o, u）。
 *
 */
public class MaxVowels {
    public int maxVowels(String s, int k) {

        char[] chars = s.toCharArray();
        Set<Character> vowels = new HashSet<>(Arrays.asList('a','e','i','o','u'));

        int max = 0;
        // 1. 前 k 个元素中元音字母的个数，给 max 赋初始值
        for (int i = 0; i < k; i++) {
            if (vowels.contains(chars[i])) {
                max++;
            }
        }
        // 滑动：index 为指针，首先指向 num，即为上一步加完后的下一个元素
        int indexFrom = 0;
        int indexTo = k;
        int sum = max;
        while (indexTo < chars.length) {

//            sum = sum - arr[indexFrom] + arr[indexTo];
            if (vowels.contains(chars[indexFrom])) {
                sum--;
            }
            if (vowels.contains(chars[indexTo])) {
                sum++;
            }
            max = sum > max ? sum : max;
            indexFrom++;
            indexTo++;
        }
        return max;
    }
}
