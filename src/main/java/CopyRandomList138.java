import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * 138. 复制带随机指针的链表.
 *
 * @author avatarannappa
 * @version 1.0, 2020/6/16
 */
public class CopyRandomList138 {

    public Node copyRandomList(Node head) {
        if (head == null) {
            return head;
        }
        Node index = head;
        Map<Integer, Node> map = new LinkedHashMap<>();
        List<Node> list = new LinkedList<>();
        while (index != null) {
            Node newHead = new Node(index.val);
            list.add(newHead);
            map.put(index.hashCode(), newHead);
            index = index.next;
        }

        int i =0;
        Node pre = null;
        while (head != null) {

            Node node = list.get(i);
            if (pre != null) {
                pre.next = node;
            }
            if (head.random != null) {
                node.random = map.get(head.random.hashCode());
            }

            pre = node;
            head = head.next;
            i++;
        }


        return list.get(0);
    }

    class Node {
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }
}
