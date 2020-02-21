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
