package litooong.com.github.templatemethod;

/**
 * @author savior
 * @date 2021/2/23 9:36 下午
 * @Description
 */
public class Main {
    public static void main(String[] args) {
        Display d1 = new CharDisplay('H');
        Display d2 = new StringDisplay("Hello, world.");
        Display d3 = new StringDisplay("你好，世界。");
        d1.display();
        d2.display();
        d3.display();
    }
}
