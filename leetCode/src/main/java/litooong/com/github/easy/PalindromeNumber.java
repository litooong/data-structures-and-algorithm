package litooong.com.github.easy;

/**
 * @author litooong
 * @date 2021/3/5 7:34 下午
 * @Description 给你一个整数 x ，如果 x 是一个回文整数，返回 true ；否则，返回 false 。
 * 回文数是指正序（从左向右）和倒序（从右向左）读都是一样的整数。例如，121 是回文，而 123 不是。
 */
public class PalindromeNumber {

    /**
     * 解法1：将原数反过来表示，然后判断前后是否相等
     * @param x
     * @return
     */
    public static boolean isPalindrome(int x) {
        if (x < 0) {
            return false;
        }
        int pre = x;
        int rev = 0;
        while (pre != 0) {
            int pop = pre % 10;
            rev = rev * 10 + pop;
            pre /= 10;
        }
        return rev == x;
    }

    // 解法2：只倒置右半部分，然后和左半部分比较
    public static boolean isPalindrome2(int x) {
        if (x < 0) {
            return false;
        }
        // 总位数
        int digit = (int) (Math.log(x) / Math.log(10) + 1);
        int revert = 0;
        int pop = 0;
        //倒置右半部分
        for (int i = 0; i < digit / 2; i++) {
            pop = x % 10;
            revert = revert * 10 + pop;
            x /= 10;
        }
        if (digit % 2 == 0 && x == revert) {
            return true;
        }
        //奇数情况 x 除以 10 去除 1 位
        if (digit % 2 != 0 && x / 10 == revert) {
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(isPalindrome(45654));
    }
}
