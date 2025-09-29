package 链表;

public class 删除链表的中间结点 {
    public ListNode deleteMiddle(ListNode head) {
        // 链表为空或只有一个节点
        if (head == null || head.next == null) {
            return null;
        }

        ListNode slow = head;
        ListNode fast = head;
        ListNode prev = null; // 记录 slow 前一个节点

        while (fast != null && fast.next != null) {
            prev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        // 删除中间节点
        prev.next = slow.next;

        return head;
    }


    public ListNode findMiddle(ListNode head) {
        ListNode slow = head, fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow; // 此时slow为中点
    }
}
