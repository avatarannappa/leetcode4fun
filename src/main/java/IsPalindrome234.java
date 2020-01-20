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
        int half = list.size() / 2;
        for (int i = list.size() - 1; i >= half; i--) {
            if (!list.get(i).equals(list.get(list.size() - 1 - i))) {
                return false;
            }
        }
        return true;
    }
}
