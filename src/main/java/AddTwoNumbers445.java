import java.util.Stack;

/**
 * 445. 两数相加 II
 * medium
 *
 * @author avatarannappa
 * @date 2023/7/3
 */
public class AddTwoNumbers445 {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        // 栈模拟
        Stack<Integer> s1 = new Stack<>();
        Stack<Integer> s2 = new Stack<>();

        while (l1 != null) {
            s1.push(l1.val);
            l1 = l1.next;
        }

        while (l2 != null) {
            s2.push(l2.val);
            l2 = l2.next;
        }

        Stack<Integer> s3 = new Stack<>();
        int t = 0;
        while (!s1.isEmpty() || !s2.isEmpty()) {
            int a = s1.isEmpty() ? 0 : s1.pop();
            int b = s2.isEmpty() ? 0 : s2.pop();
            int sum = a + b + t;
            s3.push(sum % 10);
            t = sum / 10;
        }
        if (t > 0) {
            s3.push(t);
        }

        ListNode res = new ListNode(s3.pop());
        ListNode next = res;
        while (!s3.isEmpty()) {
            ListNode node = new ListNode(s3.pop());
            next.next = node;
            next = node;
        }

        return res;
    }

    public static void main(String[] args) {
        int[] l1 = {7, 2, 4, 3};
        int[] l2 = {5, 6, 4};
        // 输出：[7, 8, 0, 7]
        ListNode n1 = ListNode.generate(l1);
        ListNode n2 = ListNode.generate(l2);
        System.out.println(new AddTwoNumbers445().addTwoNumbers(n1, n2));
    }
}
