package litooong.com.github.easy;

/**
 * @author savior
 * @date 2020/12/24 9:49 下午
 * @Description 整数反转
 */
public class Reverse {

    public static int reverse1(int num) {
        int rev = 0;
        while (num != 0) {
            int pop = num % 10;
            num /= 10;
            if (rev > Integer.MAX_VALUE/10 ) {
                return 0;
            }
            if (rev < Integer.MIN_VALUE/10 ) {
                return 0;
            }
            rev = rev * 10 + pop;
        }
        return rev;
    }
}
