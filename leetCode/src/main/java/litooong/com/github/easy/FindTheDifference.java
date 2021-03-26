package litooong.com.github.easy;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author litooong
 * @date 2021/3/22 11:15 上午
 * <p>
 * No.389 给定两个字符串 s 和 t，它们只包含小写字母。
 * <p>
 * 字符串 t 由字符串 s 随机重排，然后在随机位置添加一个字母。
 * <p>
 * 请找出在 t 中被添加的字母。
 *
 * tips:
 * a的ASCII码：97
 */
public class FindTheDifference {

    // 使用数组
    public char findTheDifference3(String s, String t) {
        int[] arr = new int[26];
        for (int i = 0; i < t.length(); i++) {
            arr[t.charAt(i) - 97] = 1;
        }
        for (int j = 0; j < s.length(); j++) {
            arr[s.charAt(j) - 97] -= 1;
        }
        for (int k = 0; k < arr.length; k++) {
            if (arr[k] > 0) {
                return (char)(k + 97);
            }
        }
        return 0;
    }

    // 使用JDK提供的HashMap
    public char findTheDifference2(String s, String t) {
        Map<Character, Integer> map = new HashMap<>();
        // 遍历长串，将其打散到哈希表中，key为字符，value为其出现的次数
        for (int i = 0; i < t.length(); i++) {
            Character c = t.charAt(i);
            if (map.containsKey(c)) {
                map.put(c, map.get(c) + 1);
            } else {
                map.put(c, 1);
            }
        }
        // 遍历子串，在map中减去，如果只有一个则删掉，不止一个则减一个
        for (int j = 0; j < s.length(); j++) {
            Character c = s.charAt(j);
            map.put(c, map.get(c) - 1);
        }
        //return map.entrySet().stream().filter(e -> e.getValue() > 0).findFirst().get().getKey().charValue();
        for (Character c: map.keySet()) {
            if (map.get(c) > 0) {
                return c.charValue();
            }
        }
        return 0;
    }

    public char findTheDifference(String s, String t) {
        char[] arr_short = s.toCharArray();
        char[] arr_long = t.toCharArray();
        Arrays.sort(arr_short);
        Arrays.sort(arr_long);
        for (int i = 0; i < arr_long.length; i++) {
            if (i <= arr_short.length - 1 && arr_short[i] != arr_long[i]) {
                return arr_long[i];
            }
        }
        return arr_long[arr_long.length - 1];
    }
}
