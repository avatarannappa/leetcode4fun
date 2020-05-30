import java.util.LinkedList;

/**
 * 61. 旋转链表.
 *
 * @author avatarannappa
 * @version 1.0, 2020/5/30
 */
public class RotateRight61 {

    public ListNode rotateRight(ListNode head, int k) {
        if (head == null || head.next == null || k == 0) {
            return head;
        }
        int len = 0;
        LinkedList<ListNode> linkedList = new LinkedList();
        linkedList.add(null);
        ListNode index = head;
        ListNode last = head;
        while (index != null) {
            linkedList.add(index);
            if (index.next == null) {
                last = index;
            }
            len++;
            index = index.next;
        }
        k = k % len;
        for (int i = 0; i < k; i++) {
            ListNode temp = last;
            last = linkedList.get(len - 1 - i);
            last.next = null;
            temp.next = head;
            head = temp;
        }
        return head;
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 5};
        ListNode head = ListNode.generate(nums);
        int k = 7;
        System.out.println(new RotateRight61().rotateRight(head, k));
    }
}
