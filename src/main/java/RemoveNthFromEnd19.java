/**
 * @author avatarannappa
 * @version 1.0, 2019/10/28
 */
public class RemoveNthFromEnd19 {

    public ListNode removeNthFromEnd(ListNode head, int n) {
        int length = 0;
        ListNode temp = head;
        while (temp != null) {
            temp = temp.next;
            length++;
        }
        int index = length - n;
        if (index == 0) {
            return head.next;
        }

        ListNode point = head;
        for (int i = 0; i < index; i++, point = point.next) {

            if (i == (index - 1)) {
                point.next = point.next.next;
            }

        }
        return head;
    }

    public static void main(String[] args) {
        RemoveNthFromEnd19 removeNthFromEnd19 = new RemoveNthFromEnd19();
        ListNode param = new ListNode(3);
        ListNode n1 = new ListNode(1);
        param.next = n1;
        ListNode n2 = new ListNode(2);
        n1.next = n2;
        ListNode result = removeNthFromEnd19.removeNthFromEnd(param, 3);
        System.out.println(result);
    }
}
