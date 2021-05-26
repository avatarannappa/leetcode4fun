/**
 * 剑指 Offer 22. 链表中倒数第k个节点
 * easy
 *
 * @author avatarannappa
 * @version 1.0, 2021/5/26
 */
public class GetKthFromEndOffer22 {

    public ListNode getKthFromEnd(ListNode head, int k) {
        int len = 0;
        ListNode p = head;
        while (p != null) {
            p = p.next;
            len++;
        }
        int index = len - k;
        ListNode res = head;
        int i = 0;
        while (i < index) {
            res = res.next;
            i++;
        }
        return res;
    }

}
