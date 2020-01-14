/**
 * @author avatarannappa
 * @version 1.0, 2018/12/18
 */
public class AddTwoNumbers {

    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(5);
        // l1.next = new ListNode(8);
        /*l1.next.next = new ListNode(3);*/

        ListNode l2 = new ListNode(5);
        /*l2.next = new ListNode(6);
        l2.next.next = new ListNode(4);*/

        ListNode l = addTwoNumbers(l1,l2);
        while (true) {
            if (l != null) {
                System.out.println(l.val);
            } else {
                break;
            }
            l = l.next;
        }

    }

    static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode result = new ListNode(0);
        ListNode point = result;
        int pre = 0;
        for (int i = 0; ; i++) {
            int x1 = 0;
            int x2 = 0;
            if (l1 != null || l2 != null) {
                point.next = new ListNode(0);
                point = point.next;
            }
            if (l1 != null) {
                x1 = l1.val;
            }
            if (l2 != null) {
                x2 = l2.val;
            }
            if (l1 == null && l2 == null) {
                if (pre > 0) {
                    point.next = new ListNode(0);
                    point = point.next;
                    point.val = pre;
                    point = point.next;
                    break;
                } else {
                    break;
                }
            }
            int mod = (x1 + x2 + pre) % 10;
            pre = (x1 + x2 + pre) / 10;
            point.val = mod;

            if (l1 != null) {
                l1 = l1.next;
            }
            if (l2 != null) {
                l2 = l2.next;
            }
        }
        result = result.next;
        return result;
    }
}
