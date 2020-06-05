/**
 * 86. 分隔列表.
 *
 * @author avatarannappa
 * @version 1.0, 2020/6/5
 */
public class Partition86 {
    public ListNode partition(ListNode head, int x) {
        ListNode originHead = head;
        ListNode result = null;
        ListNode small = null;
        ListNode bigStart = null;
        ListNode big = null;
        while (head != null) {
            if (head.val < x) {
                if (result == null) {
                    result = head;
                }
                if (small == null) {
                    small = head;
                } else {
                    small.next = head;
                    small = small.next;
                }
            } else {
                if (big == null) {
                    big = head;
                    bigStart = head;
                } else {
                    big.next = head;
                    big = big.next;
                }
            }
            head = head.next;
        }
        if (small != null) {
            small.next = bigStart;
        }
        if (big != null) {
            big.next = null;
        }
        return result == null ? originHead : result;
    }

    public static void main(String[] args) {
        int[] nums = {1, 4, 3, 2, 5, 2};
        ListNode head = ListNode.generate(nums);
        int x = 0;
        System.out.println(new Partition86().partition(head, x));
    }
}
