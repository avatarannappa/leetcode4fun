import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * 147. 对链表进行插入排序.
 *
 * @author avatarannappa
 * @version 1.0, 2020/6/11
 */
public class InsertionSortList147 {

    public ListNode insertionSortList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        List<ListNode> list = new ArrayList<>();
        while (head != null) {
            list.add(head);
            ListNode temp = head;
            head = head.next;
            temp.next = null;
        }
        list.sort(Comparator.comparingInt(o -> o.val));
        ListNode index = null;
        ListNode result = null;
        for (ListNode listNode : list) {
            if (index == null) {
                result = listNode;
                index = listNode;
            } else {
                index.next = listNode;
                index = index.next;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] nums = {-1, 0, 3, 4, 5};
        ListNode head = ListNode.generate(nums);
        System.out.println(new InsertionSortList147().insertionSortList(head));
    }
}
