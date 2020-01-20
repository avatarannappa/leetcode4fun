import java.util.LinkedList;
import java.util.List;

/**
 * 234. 回文链表
 *
 * @author avatarannappa
 * @version 1.0, 2020/1/20
 */
public class IsPalindrome234 {
    public boolean isPalindrome(ListNode head) {
        if (head == null) {
            return true;
        }
        List<Integer> list = new LinkedList<>();
        while (head != null) {
            list.add(head.val);
            head = head.next;
        }
        for (int i = list.size() - 1; i >= 0; i--) {
            if (!list.get(i).equals(list.get(list.size() - 1 - i))) {
                return false;
            }
            if (i > list.size() / 2) {

            }
        } return true;
    }
}
