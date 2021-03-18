package litooong.com.github.easy;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author litooong
 * @date 2021/3/14 11:28 上午
 * No.933
 */
public class RecentCounter {

    private Deque<Integer> q;

    public RecentCounter() {
        q = new LinkedList<>();
    }

    /**
     * 我们只会考虑最近 3000 毫秒到现在的 ping 数
     * 因此我们可以使用队列存储这些 ping 的记录
     * 当收到一个时间 t 的 ping 时，我们将它加入队列，
     * 并且将所有在时间 t - 3000 之前的 ping 移出队列。
     *
     * @param t
     * @return
     */
    public int ping(int t) {
        q.add(t);
        while (q.peek() < t - 3000) {
            q.poll();
        }
        return q.size();
    }

    /* 使用中转栈，保留了ping所有记录
    public int ping(int t) {
        record.push(Integer.valueOf(t));
        Deque<Integer> temp = new LinkedList<>();
        while (!record.isEmpty()) {
            if (record.peek().intValue() >= (t - 3000)) {
                temp.push(record.peek());
            }
            record.pop();
        }
        int result = temp.size();
        while (!temp.isEmpty()) {
            record.push(temp.pop());
        }
        return result;
    }
    */

    public static void main(String[] args) {
    }
}
