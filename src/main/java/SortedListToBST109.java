/**
 * 109. 有序链表转换二叉搜索树.
 *
 * @author avatarannappa
 * @version 1.0, 2020/5/23
 */
public class SortedListToBST109 {

    public TreeNode sortedListToBST(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode mid = midNode(head);
        TreeNode root = new TreeNode(mid.val);
        if (head == mid) {
            return root;
        }
        mid = mid.next;
        root.left = sortedListToBST(head);
        root.right = sortedListToBST(mid);
        return root;
    }

    public ListNode midNode(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        ListNode pre = null;
        while (fast != null && fast.next != null) {
            pre = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        if (pre != null) {
            pre.next = null;
        }
        return slow;
    }

    public static void main(String[] args) {
        ListNode one = new ListNode(-10);
        ListNode two = new ListNode(-3);
        ListNode three = new ListNode(0);
        ListNode four = new ListNode(5);
        ListNode five = new ListNode(9);
        one.next = two;
        two.next = three;
        three.next = four;
        four.next = five;
        System.out.println(new SortedListToBST109().sortedListToBST(one));
    }
}
