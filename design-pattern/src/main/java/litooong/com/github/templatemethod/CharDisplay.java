package litooong.com.github.templatemethod;

/**
 * @author savior
 * @date 2021/2/23 9:30 下午
 * @Description
 */
public class CharDisplay implements Display {
    private char ch;

    public CharDisplay(char ch) {
        this.ch = ch;
    }

    @Override
    public void open() {
        System.out.print("<<");
    }

    @Override
    public void print() {
        System.out.print(ch);
    }

    @Override
    public void close() {
        System.out.println(">>");
    }
}
