package 链表;

public class 两两交换链表中的节点 {

    //递归解法
    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        // 获取要交换的两个节点
        ListNode first = head;
        ListNode second = head.next;
        // 递归交换后序节点
        first.next = swapPairs(second.next);
        second.next = first;

        return second;
    }

    // 非递归解法
    public ListNode swapPairs2(ListNode head) {
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode temp = dummy;
        while (temp.next != null && temp.next.next != null) {
            ListNode first = temp.next;
            ListNode second = temp.next.next;
            // 两两交换temp节点后的两个节点
            temp.next = second;
            first.next = second.next;
            second.next = first;

            // 将temp指到原第一个节点
            temp = first;

        }

        return dummy.next;
    }
}
