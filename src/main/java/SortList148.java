/**
 * 148. 排序链表
 *
 * @author avatarannappa
 * @version 1.0, 2020/2/21
 */
public class SortList148 {

    public ListNode sortList(ListNode head) {
        // 递归终止条件
        if (head == null || head.next == null) {
            return head;
        }
        ListNode slow = head;
        ListNode fast = head.next;
        if (fast.next == null) {
            // 两个节点比较
            if (slow.val > fast.val) {
                slow.next = null;
                fast.next = slow;
                return fast;
            } else {
                return head;
            }
        }

        // 中点
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        // 分隔
        System.out.println(head);
        ListNode mid = slow.next;
        slow.next = null;
        // 递归
        ListNode left = sortList(head);
        ListNode right = sortList(mid);
        // 合并
        ListNode m = new ListNode(0);
        ListNode h = m;
        while (true) {
            if (left.val > right.val) {
                m.next = right;
                right = right.next;
            } else {
                m.next = left;
                left = left.next;
            }

            if (left == null) {
                m.next.next = right;
                break;
            }
            if (right == null) {
                m.next.next = left;
                break;
            }
            m = m.next;
        }
        return h.next;
    }

    public static void main(String[] args) {
        ListNode n1 = new ListNode(4);
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(1);
        ListNode n4 = new ListNode(3);
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        System.out.println(new SortList148().sortList(n1));
    }

}
