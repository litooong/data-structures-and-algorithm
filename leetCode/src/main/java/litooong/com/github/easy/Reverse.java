package litooong.com.github.easy;

/**
 * @author savior
 * @date 2020/12/24 9:49 下午
 * @Description 整数反转
 */
public class Reverse {

    public static void main(String[] args) {

    }
    public static int reverse1(int num) {
        int rev = 0;
        while (num != 0) {
            int pop = num % 10;
            num /= 10;
            // 1. 如果 rev > intMax/10 则 rev * 10 + pop 肯定溢出
            // 如果 rev == intMax / 10 = 2147483647 / 10 = 214748364 ，
            // 此时 rev * 10 就是 2147483640 如果 pop 大于 7 ，那么就一定溢出了。
            // 但是！如果假设 pop 等于 8，那么意味着原数 x 是 8463847412 了，输入的是 int ，
            // 而此时是溢出的状态，所以不可能输入，所以意味着 pop 不可能大于 7 ，
            // 也就意味着 rev == intMax / 10 时不会造成溢出。
            // 如果 rev < intMax / 10 ，意味着 rev 最大是 214748363 ， rev * 10 就是 2147483630 ,
            // 此时再加上 pop ，一定不会溢出。
            // 小于 intMin 同理分析
            if (rev > Integer.MAX_VALUE / 10 || rev < Integer.MIN_VALUE / 10) {
                return 0;
            }
            rev = rev * 10 + pop;
        }
        return rev;
    }

    // 解法二： 利用 long 更大的数字范围求解
    public static int reverse2(int num) {
        long rev = 0;
        while (num != 0) {
            int pop = num % 10;
            num /= 10;
            rev = rev * 10 + pop;
        }
        if (rev > Integer.MAX_VALUE || rev < Integer.MIN_VALUE) {
            return 0;
        }
        return (int) rev;
    }
}
