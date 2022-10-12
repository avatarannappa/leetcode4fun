import java.util.HashSet;
import java.util.Set;

/**
 * 817. 链表组件
 * medium
 *
 * @author avatarannappa
 * @date 2022/10/12
 */
public class NumComponents817 {

    public int numComponents(ListNode head, int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }
        int ans = 0;

        while (head != null) {
            if (set.contains(head.val)) {
                while (head != null && set.contains(head.val)) {
                    head = head.next;
                }
                ans++;
            } else {
                head = head.next;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(0);
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(3);
        ListNode n4 = new ListNode(4);
        head.next = n1;
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        int[] nums = {0, 3, 1, 4};
        // 2
        System.out.println(new NumComponents817().numComponents(head, nums));
    }
}
