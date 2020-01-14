/**
 * 206. 反转链表
 *
 * @author avatarannappa
 * @version 1.0, 2019/11/18
 */
public class ReverseList206 {
    public ListNode reverseList(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode result = new ListNode(head.val);
        head = head.next;
        while (head != null) {
            ListNode temp = new ListNode(head.val);
            temp.next = result;
            result = temp;
            head = head.next;
        }
        return result;
    }
}
