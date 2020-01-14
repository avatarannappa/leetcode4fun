/**
 * 21. 合并两个有序链表
 *
 * @author avatarannappa
 * @version 1.0, 2019/11/23
 */
public class MergeTwoLists21 {

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }

        ListNode result = null;
        ListNode head = null;
        while (l1 != null && l2 != null) {
            if (l1.val > l2.val) {
                if (result == null) {
                    result = new ListNode(l2.val);
                    head = result;
                } else {
                    result.next = new ListNode(l2.val);
                    result = result.next;
                }
                l2 = l2.next;
            } else {
                if (result == null) {
                    result = new ListNode(l1.val);
                    head = result;
                } else {
                    result.next = new ListNode(l1.val);
                    result = result.next;
                }
                l1 = l1.next;
            }

        }
        if (l1 == null) {
            result.next = l2;
        } else if (l2 == null) {
            result.next = l1;
        }
        return head;
    }

}
