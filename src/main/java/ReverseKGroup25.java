import java.util.LinkedList;
import java.util.Stack;

/**
 * 25. K 个一组翻转链表.
 *
 * @author avatarannappa
 * @version 1.0, 2020/8/8
 */
public class ReverseKGroup25 {

    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode index = head;
        LinkedList<Stack<ListNode>> list = new LinkedList<>();
        while (index != null) {
            Stack<ListNode> stack = new Stack<>();
            for (int i = 0; i < k && index != null; i++) {
                stack.add(index);
                index = index.next;
            }
            list.add(stack);
        }

        ListNode result = null;
        for (Stack<ListNode> nodeStack : list) {
            if (nodeStack.size() == k) {
                while (!nodeStack.isEmpty()) {
                    ListNode temp = nodeStack.pop();
                    if (result == null) {
                        result = temp;
                        index = temp;
                    } else {
                        index.next = temp;
                        index = index.next;
                    }
                }
            } else {
                ListNode tail = null;
                Object[] array = nodeStack.toArray();
                for (int i = 0; i < array.length; i++) {
                    ListNode temp = (ListNode) array[i];
                    index.next = temp;
                    index = index.next;
                }
            }
        }
        index.next = null;

        return result;
    }

    public static void main(String[] args) {
        ListNode one = new ListNode(1);
        ListNode two = new ListNode(2);
        ListNode three = new ListNode(3);
        ListNode four = new ListNode(4);
        ListNode five = new ListNode(5);
        one.next = two;
        two.next = three;
        three.next = four;
        four.next = five;
        int k = 2;
        System.out.println(new ReverseKGroup25().reverseKGroup(one, 3));
    }

}
