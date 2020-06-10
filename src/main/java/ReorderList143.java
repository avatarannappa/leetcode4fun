import java.util.ArrayList;
import java.util.List;

/**
 * 143. 重排链表.
 *
 * @author avatarannappa
 * @version 1.0, 2020/6/10
 */
public class ReorderList143 {

    public void reorderList(ListNode head) {
        List<ListNode> list = new ArrayList<>();
        while (head != null) {
            list.add(head);
            ListNode temp = head;
            head = head.next;
            temp.next = null;
        }
        int l = 0;
        int r = list.size() - 1;
        ListNode index = null;
        for (int i = 0; i < list.size(); i++) {
            if (i % 2 == 0) {
                if (index == null) {
                    index = list.get(l);
                } else {
                    index.next = list.get(l);
                    index = index.next;
                }
                l++;
            } else {
                index.next = list.get(r);
                index = index.next;
                r--;
            }
        }
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4};
        ListNode head = ListNode.generate(nums);
        new ReorderList143().reorderList(head);
        System.out.println(head);
    }
}
