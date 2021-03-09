package litooong.com.github.easy;

import java.util.HashMap;
import java.util.Map;

/**
 * @author litooong
 * @date 2021/3/5 8:51 下午
 *
 * s 仅含字符 ('I', 'V', 'X', 'L', 'C', 'D', 'M')
 * 题目数据保证 s 是一个有效的罗马数字，且表示整数在范围 [1, 3999] 内
 * 题目所给测试用例皆符合罗马数字书写规则，不会出现跨位等情况。
 */
public class RomanToInteger {
    public static int romanToInt2(String s) {
        int res = 0;
        Map<Character, Integer> table = new HashMap<>();
        table.put('I', 1);
        table.put('V', 5);
        table.put('X', 10);
        table.put('L', 50);
        table.put('C', 100);
        table.put('D', 500);
        table.put('M', 1000);
        for (int i = 0; i < s.length(); i++) {
            if (i < s.length() - 1 && table.get(s.charAt(i)) < table.get(s.charAt(i + 1))) {
                res -= table.get(s.charAt(i));
            } else {
                res += table.get(s.charAt(i));
            }
        }
        return res;
    }

    public static int romanToInt(String s) {

        // 把可能出现的特殊情况提前减掉
        int sum = 0;
        if (s.indexOf("IV") != -1) {
            sum -= 2;
        }
        if (s.indexOf("IX") != -1) {
            sum -= 2;
        }
        if (s.indexOf("XL") != -1) {
            sum -= 20;
        }
        if (s.indexOf("XC") != -1) {
            sum -= 20;
        }
        if (s.indexOf("CD") != -1) {
            sum -= 200;
        }
        if (s.indexOf("CM") != -1) {
            sum -= 200;
        }
        char c[] = s.toCharArray();
        for (int count = 0; count <= s.length() - 1; count++) {
            if (c[count] == 'M') {
                sum += 1000;
            }
            if (c[count] == 'D') {
                sum += 500;
            }
            if (c[count] == 'C') {
                sum += 100;
            }
            if (c[count] == 'L') {
                sum += 50;
            }
            if (c[count] == 'X') {
                sum += 10;
            }
            if (c[count] == 'V') {
                sum += 5;
            }
            if (c[count] == 'I') {
                sum += 1;
            }

        }
        return sum;
    }

    public static void main(String[] args) {
        System.out.println(romanToInt2("LVIII"));
    }
}
