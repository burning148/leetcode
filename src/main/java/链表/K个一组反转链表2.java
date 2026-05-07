package 链表;

class ListNode {
    int val;
    ListNode next;
    ListNode(int val) { this.val = val; }
}

public class K个一组反转链表2 {

    public static ListNode reverseKGroup(ListNode head, int k) {
        if (head == null || k <= 1) return head;

        ListNode dummy = new ListNode(0);
        dummy.next = head;

        ListNode pre = dummy;
        ListNode end = dummy;

        while (true) {
            int count = 0;

            // 找到一组的 end
            while (count < k && end != null) {
                end = end.next;
                count++;
            }

            // 不足 k
            if (end == null) {
                ListNode start = pre.next;
                int len = getLength(start);

                // 偶数才翻转
                if (len % 2 == 0) {
                    pre.next = reverse(start);
                }
                break;
            }

            // 正常 k 组翻转
            ListNode start = pre.next;
            ListNode next = end.next;

            end.next = null; // 截断

            pre.next = reverse(start);

            // 接回去
            start.next = next;

            // 移动指针
            pre = start;
            end = pre;
        }

        return dummy.next;
    }

    // 反转链表
    private static ListNode reverse(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;

        while (curr != null) {
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        return prev;
    }

    // 计算长度
    private static int getLength(ListNode node) {
        int len = 0;
        while (node != null) {
            len++;
            node = node.next;
        }
        return len;
    }
}