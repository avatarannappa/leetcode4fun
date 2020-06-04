/**
 * 82. 删除排序链表中的重复元素 II
 *
 * @author avatarannappa
 * @version 1.0, 2020/6/4
 */
public class DeleteDuplicates82 {

    public ListNode deleteDuplicates(ListNode head) {
        ListNode index = head;
        ListNode pre = null;
        while (index != null && index.next != null) {
            boolean repeat = false;
            while (index != null && index.next != null && index.val == index.next.val) {
                index = index.next;
                repeat = true;
            }

            if (!repeat) {
                if (pre == null) {
                    head = index;
                } else {
                    pre.next = index;
                }
                pre = index;
            }
            index = index.next;
        }
        if (pre != null) {
            pre.next = index;
        } else {
            head = index;
        }
        return head;
    }

    public static void main(String[] args) {
        int[] nums = {1};
        ListNode head = ListNode.generate(nums);
        System.out.println(new DeleteDuplicates82().deleteDuplicates(head));
    }

}
