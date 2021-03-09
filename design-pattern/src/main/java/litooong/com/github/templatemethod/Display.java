package litooong.com.github.templatemethod;

/**
 * @author savior
 * @date 2021/2/23 9:24 下午
 * @Description
 */
public interface Display {
    void open();
    void print();
    void close();
    default void display() {
        open();
        for (int i = 0; i < 5; i++) {
            print();
        }
        close();
    }
}