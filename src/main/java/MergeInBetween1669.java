/**
 * 1669. 合并两个链表
 * medium
 *
 * @author avatarannappa
 * @version 1.0, 2023/1/30
 */
public class MergeInBetween1669 {

    public ListNode mergeInBetween(ListNode list1, int a, int b, ListNode list2) {
        ListNode p1 = list1;
        ListNode p2 = list2;
        ListNode pre = p1;
        int index = 0;
        while (p1 != null) {
            if (index == a) {
                pre.next = p2;
                while (p2.next != null) {
                    p2 = p2.next;
                }
            }
            if (index == b) {
                p2.next = p1.next;
                p1.next = null;
            }

            pre = p1;
            p1 = p1.next;
            index++;
        }
        return list1;
    }

}
