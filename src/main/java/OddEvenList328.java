/**
 * 328. 奇偶链表.
 *
 * @author avatarannappa
 * @version 1.0, 2020/2/27
 */
public class OddEvenList328 {

    public ListNode oddEvenList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode odd = head;
        ListNode oddPre = odd;
        ListNode evenHead = head.next;
        ListNode even = evenHead;
        int count = 1;
        while (odd != null && even != null) {
            if (count % 2 == 1) {
                odd.next = even.next;
                oddPre = odd;
                odd = odd.next;
            } else {
                even.next = odd.next;
                even = even.next;
            }
            count++;
        }
        if (odd == null) {
            oddPre.next = evenHead;
        } else {
            odd.next = evenHead;
        }
        return head;
    }

}
