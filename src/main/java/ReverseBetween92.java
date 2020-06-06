import java.util.Stack;

/**
 * 92. 反转链表 II.
 *
 * @author avatarannappa
 * @version 1.0, 2020/6/6
 */
public class ReverseBetween92 {

    public ListNode reverseBetween(ListNode head, int m, int n) {
        if (head == null || m == n) {
            return head;
        }
        if (m > 1) {
            head.next = reverseBetween(head.next, m - 1, n - 1);
            return head;
        }
        ListNode result = null;
        Stack<ListNode> stack = new Stack<>();

        int i = 1;
        while (head != null) {
            if (i >= m && i <= n) {
                ListNode temp = head;
                head = head.next;
                temp.next = null;
                stack.push(temp);
            } else if (i == n + 1) {
                break;
            }
            i++;
        }
        ListNode index = null;
        while (!stack.isEmpty()) {
            ListNode node = stack.pop();
            if (index == null) {
                index = node;
                result = index;
            } else {
                index.next = node;
                index = index.next;
            }
        }
        index.next = head;
        return result;
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 5};
        ListNode head = ListNode.generate(nums);
        int m = 2;
        int n = 4;
        System.out.println(new ReverseBetween92().reverseBetween(head, m, n));
    }
}
