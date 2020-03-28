/**
 * 876. 链表的中间结点
 *
 * @author avatarannappa
 * @version 1.0, 2020/3/27
 */
public class MiddleNode876 {

    public ListNode middleNode(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            head = head.next;
            fast = fast.next.next;
        }
        return head;
    }

    public ListNode middleNodeOld(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        int size = 0;
        ListNode h = head;
        while (head != null) {
            size++;
            head = head.next;
        }
        int half = size / 2;
        for (int i = 0; i < half; i++) {
            h = h.next;
        }
        return h;
    }

}
