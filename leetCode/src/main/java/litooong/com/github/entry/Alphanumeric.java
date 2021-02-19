package litooong.com.github.entry;

/**
 * @author savior
 * @date 2021/2/19 10:38 下午
 * @Description 给出一个字符c，你需要判断它是不是一个数字字符或者字母字符。
 * 如果是，返回true，如果不是返回false。
 */
public class Alphanumeric {
    public static boolean isAlphanumeric(char c) {
        int v = (int) c;
        if (v >= 48 && v <= 57) {
            return true;
        } else if (v >= 65 && v <= 90) {
            return true;
        } else {
            return v >= 97 && v <= 122;
        }
    }

}
