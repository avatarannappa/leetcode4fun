import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

/**
 * 83. 删除排序链表中的重复元素
 *
 * @author avatarannappa
 * @version 1.0, 2020/1/6
 */
public class DeleteDuplicates83 {
    public ListNode deleteDuplicates(ListNode head) {
        Set<Integer> set = new HashSet<>();
        ListNode newList = null;
        ListNode pre = null;
        while (head != null) {
            if (!set.contains(head.val)) {
                if (newList == null) {
                    newList = head;
                } else {
                    pre.next = head;
                }
                set.add(head.val);
                pre = head;
                head = head.next;
                pre.next = null;
            } else {
                head = head.next;
            }
        }
        return newList;
    }

    public static void main(String[] args) {
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(1);
        ListNode n3 = new ListNode(2);
        n1.next = n2;
        n2.next = n3;
        System.out.println(new DeleteDuplicates83().deleteDuplicates(n1));
    }
}
