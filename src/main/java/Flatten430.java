/**
 * 430. 扁平化多级双向链表,Flatten a Multilevel Doubly Linked List. medium
 *
 * @author avatarannappa
 * @version 1.0, 2021/10/15
 */
public class Flatten430 {

    public Node flatten(Node head) {
        if (head == null) {
            return null;
        }
        dfs(head);
        return head;
    }

    private Node dfs(Node head) {
        Node child = head.child;
        Node next = head.next;
        if (child != null) {
            head.next = child;
            child.prev = head;
            head.child = null;
            Node last = dfs(child);
            if (next != null) {
                next.prev = last;
                last.next = next;
            } else {
                return last;
            }
        }
        if (next != null) {
            return dfs(next);
        } else {
            return head;
        }
    }

    class Node {
        public int val;
        public Node prev;
        public Node next;
        public Node child;
    };
}
