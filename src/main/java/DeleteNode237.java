/**
 * 237. 删除链表中的节点.
 * @author avatarannappa
 * @version 1.0, 2020/1/26
 */
public class DeleteNode237 {

    public void deleteNode(ListNode node) {
        node.val = node.next.val;
        node.next = node.next.next;
    }

}
