import java.util.HashSet;
import java.util.Set;

/**
 * 142. 环形链表II
 *
 * @author avatarannappa
 * @version 1.0, 2020/2/10
 */
public class DetectCycle142 {

    public ListNode detectCycle(ListNode head) {
        Set<ListNode> set = new HashSet<>();
        while (head != null) {
            if (set.contains(head)) {
                return head;
            }
            set.add(head);
            head = head.next;
        }
        return head;
    }

    public static void main(String[] args) {
        ListNode one1 = new ListNode(0);
        ListNode two1 = new ListNode(1);
        ListNode three1 = new ListNode(2);
        ListNode four1 = new ListNode(3);
        one1.next = two1;
        two1.next = three1;
        three1.next = four1;
        four1.next = three1;

        System.out.println(new DetectCycle142().detectCycle(one1));
    }

}
