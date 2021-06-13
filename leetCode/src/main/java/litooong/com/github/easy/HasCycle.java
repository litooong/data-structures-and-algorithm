package litooong.com.github.easy;

import litooong.com.github.bean.ListNode;

import java.util.HashSet;
import java.util.Set;


/**
 * 给定一个链表，判断链表中是否有环。
 * <p>
 * 如果链表中有某个节点，可以通过连续跟踪 next 指针再次到达，则链表中存在环。
 * 为了表示给定链表中的环，我们使用整数 pos 来表示链表尾连接到链表中的位置（索引从 0 开始）。
 * 如果 pos 是 -1，则在该链表中没有环。注意：pos 不作为参数进行传递，仅仅是为了标识链表的实际情况。
 * 如果链表中存在环，则返回 true 。 否则，返回 false 。
 */
public class HasCycle {

    /**
     * 解法 2 ： 快慢指针
     *
     * @param head
     * @return 原理: 想象一下圆形跑道，两个人跑步，如果一个人跑的快，一个人跑的慢，那么不管两个人从哪个位置出发，跑的过程中两人一定会相遇。
     * <p>
     * 所以这里我们用两个指针 fast 和 slow。fast 每次走两步，slow 每次走一步，如果 fast 到达了 null 就说明没有环。
     * 如果 fast 和 slow 相遇了就说明有环。
     */
    public boolean hasCycle2(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null) {
            if (fast.next == null) {
                return false;
            }
            slow = slow.next;
            fast = fast.next.next;
            if (fast == slow) {
                return true;
            }
        }
        return false;
    }

    /**
     * 解法 1：常规思路利用 HashSet
     *
     * @param head
     * @return
     */
    public boolean hasCycle(ListNode head) {
        Set<ListNode> set = new HashSet<>();
        while (head != null) {
            if (set.contains(head)) {
                return true;
            }
            set.add(head);
            head = head.next;
        }
        return false;
    }
}
