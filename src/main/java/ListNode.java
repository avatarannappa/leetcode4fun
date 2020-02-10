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

//    @Override
//    public String toString() {
    // 输出列表
//        final StringBuilder sb = new StringBuilder("ListNode{");
//        sb.append("val=").append(val);
//        sb.append(", next=").append(next);
//        sb.append('}');
//        return sb.toString();
//    }

    @Override
    public String toString() {
        return val + "";
    }
}
