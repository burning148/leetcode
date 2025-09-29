package 链表;

/**
 * @author wangjun294
 * @description 19.删除链表的倒数第n个节点
 */
public class 删除链表的倒数第n个节点 {

    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(-1, head);
        ListNode x = findNthFromEnd(dummy, n + 1); // 先找到倒数第n + 1个节点, 使用dummy避免空指针
        x.next = x.next.next;
        return dummy.next;
    }

    /**
     * @description 查找链表倒数第n个节点
     * @param head
     * @param n
     * @return
     */
    private ListNode findNthFromEnd(ListNode head, int n) {
        ListNode p1 = head;
        for (int i = 0; i < n; i++) {
            p1 = p1.next;
        }
        ListNode p2 = head;
        while (p1 != null) {
            p2 = p2.next;
            p1 = p1.next;
        }
        return p2;
    }


    public ListNode removeNthFromEnd2(ListNode head, int n) {
        ListNode dummy = new ListNode(-1, head);
        ListNode slow = dummy, fast = dummy;

        // 快指针走 n + 1 步
        for (int i = 0; i <= n; i++) {
            fast = fast.next;
        }


        while (fast != null) {
            slow = slow.next;
            fast = fast.next;
        }

        slow.next = slow.next.next;

        return dummy.next;
    }
}
