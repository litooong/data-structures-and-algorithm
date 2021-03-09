package litooong.com.github.templatemethod;

/**
 * @author savior
 * @date 2021/2/23 9:32 下午
 * @Description
 */
public class StringDisplay implements Display {

    private String str;

    public StringDisplay(String str) {
        if (str != null) {
            this.str = str;
        } else {
            str = "";
        }
    }

    @Override
    public void open() {
        printLine();
    }

    @Override
    public void print() {
        System.out.println("|" + str + "|");
    }

    @Override
    public void close() {
        printLine();
    }

    private void printLine() {
        System.out.print("+");
        for (int i = 0; i < str.length(); i++) {
            System.out.print("-");
        }
        System.out.println("+");
    }
}
