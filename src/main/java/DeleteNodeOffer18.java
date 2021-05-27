/**
 * 剑指 Offer 18. 删除链表的节点
 * easy
 *
 * @author avatarannappa
 * @version 1.0, 2021/5/27
 */
public class DeleteNodeOffer18 {

    public ListNode deleteNode(ListNode head, int val) {
        ListNode index = head;
        ListNode pre = null;
        while (index != null) {

            if (index.val == val) {
                if (pre == null) {
                    head = index.next;
                    index.next = null;
                    break;
                } else {
                    pre.next = index.next;
                    index.next = null;
                    break;
                }
            }

            pre = index;
            index = index.next;
        }
        return head;
    }

}
