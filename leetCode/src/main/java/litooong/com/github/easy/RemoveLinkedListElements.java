package litooong.com.github.easy;


/**
 * @author litooong
 * @date 2021/3/9 9:46 下午
 * No.203 给你一个链表的头节点 head 和一个整数 val
 * 请你删除链表中所有满足 Node.val == val 的节点，并返回 新的头节点。
 */
public class RemoveLinkedListElements {

    public ListNode removeElements(ListNode head, int val) {
        // 1. 找头
        while (head != null && head.val == val) {
            head = head.next;
        }
        if (head == null) {
            return null;
        }
        ListNode prep = head;
        ListNode node = head.next;
        while (node != null) {
            if (node.val == val) {
                prep.next = node.next;
            } else {
                prep = prep.next;
            }
            node = node.next;
        }
        return head;
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


