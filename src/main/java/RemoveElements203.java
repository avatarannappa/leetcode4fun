/**
 * 203. 移除链表元素.
 *
 * @author avatarannappa
 * @version 1.0, 2020/2/18
 */
public class RemoveElements203 {
    public ListNode removeElements(ListNode head, int val) {
        ListNode start = head;
        ListNode pre = null;
        while (head != null) {
            if (pre == null) {
                if (head.val == val) {
                    start = head.next;
                } else {
                    pre = head;
                }
            } else {
                if (head.val == val) {
                    pre.next = head.next;
                } else {
                    pre = head;
                }
            }
            head = head.next;
        }
        return start;
    }

    public ListNode remove(ListNode head, int val) {
        // 当要删除的一个或多个节点位于链表的头部时，事情会变得复杂。
        // 可以通过哨兵节点去解决它，哨兵节点广泛应用于树和链表中.
        // 如伪头、伪尾、标记等，它们是纯功能的，通常不保存任何数据，其主要目的是使链表标准化，如使链表永不为空、永不无头、简化插入和删除
        ListNode sentinel = new ListNode(0);
        sentinel.next = head;

        ListNode prev = sentinel, curr = head;
        while (curr != null) {
            if (curr.val == val) {
                prev.next = curr.next;
            } else {
                prev = curr;
            }
            curr = curr.next;
        }
        return sentinel.next;
    }
}
