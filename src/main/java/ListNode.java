/**
 * @author avatarannappa
 * @version 1.0, 2019/10/28
 */
public class ListNode {
    int val;

    ListNode next;

    ListNode(int x) {
        val = x;
    }

    public static ListNode generate(int[] args) {
        ListNode root = null;
        ListNode index = null;
        for (int arg : args) {
            if (root == null) {
                root = new ListNode(arg);
                index = root;
            } else {
                ListNode node = new ListNode(arg);
                index.next = node;
                index = node;
            }
        }
        return root;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("");
        sb.append(val);
        sb.append("->");
        sb.append(next);

        return sb.toString();
    }

    //    @Override
    //    public String toString() {
    //        return val + "";
    //    }
}
