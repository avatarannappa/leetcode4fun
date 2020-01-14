/**
 *141. 环形链表
 * @author avatarannappa
 * @version 1.0, 2019/11/22
 */
public class HasCycle141 {

    public boolean hasCycle(ListNode head) {
        ListNode step1 = head;
        ListNode step2 = head;
        while (step1 != null && step2 != null) {
            step1 = step1.next;
            step2 = step2.next;
            if (step2 == null) {
                return false;
            }
            step2 = step2.next;
            if (step2 == null) {
                return false;
            }
            if (step1.val == step2.val) {
                return true;
            }
        }
        return false;
    }
}
