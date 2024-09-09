/**
 * 2181. 合并零之间的节点.
 * medium
 *
 * @author avatarannappa
 * @version 2024/9/9
 */
public class MergeNodes2181 {

    public ListNode mergeNodes(ListNode head) {
        // 模拟
        ListNode ans = null;
        ListNode res = null;
        int sum = 0;
        while (head != null) {
            if (head.val == 0) {
                if (sum == 0) {
                    head = head.next;
                    continue;
                }
                if (res == null) {
                    res = new ListNode(sum);
                    ans = res;
                } else {
                    res.next = new ListNode(sum);
                    res = res.next;
                }

                sum = 0;
            } else {
                sum += head.val;
            }
            head = head.next;
        }
        return ans;
    }

    public static void main(String[] args) {
        // 0,1,0,3,0,2,2,0
        ListNode head = new ListNode(0);
        head.next = new ListNode(1);
        head.next.next = new ListNode(0);
        head.next.next.next = new ListNode(3);
        head.next.next.next.next = new ListNode(0);
        head.next.next.next.next.next = new ListNode(2);
        head.next.next.next.next.next.next = new ListNode(2);
        head.next.next.next.next.next.next.next = new ListNode(0);
        System.out.println(new MergeNodes2181().mergeNodes(head));
    }
}
