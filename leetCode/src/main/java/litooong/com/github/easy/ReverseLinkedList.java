package litooong.com.github.easy;


/**
 * @author litooong
 * @date 2021/3/12 9:48 下午
 * <p>
 * No.206 反转一个单链表
 * tips: 迭代/递归
 */
public class ReverseLinkedList {

    // 1. 迭代
    public ListNode reverseList(ListNode head) {
        if (head == null) {
            return head;
        }
        ListNode pre = null;
        ListNode next;
        while (head != null) {
            next = head.next;
            head.next = pre;
            pre = head;
            head = next;
        }
        return pre;
    }

    // 2. 递归
    public ListNode reverseListRecursion(ListNode head) {
        ListNode newHead;
        if (head == null || head.next == null) {
            return head;
        }
        newHead = reverseList(head.next);
        // head.next 代表新链表的尾，将它的 next 置为 head，就是将 head 加到末尾了。
        head.next.next = head;
        head.next = null;
        return newHead;
    }


    class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    public static void main(String[] args) {

    }
}
