/**
 * 24. 两两交换链表中的节点
 *
 * @author avatarannappa
 * @version 1.0, 2020/1/4
 */
public class SwapPairs24 {

    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode index = head;
        head = head.next;
        ListNode pre = null;
        while (index != null && index.next != null) {
            ListNode next = index.next;
            index.next = next.next;
            next.next = index;
            if (pre != null) {
                pre.next = next;
            }
            pre = index;
            index = index.next;
        }
        return head;
    }

    public static void main(String[] args) {
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(3);
        ListNode n4 = new ListNode(4);
        n1.next = n2;
        n2.next = n3;
        //n3.next = n4;
        System.out.println(n1);
        System.out.println(new SwapPairs24().swapPairs(n1));
    }

}
