/**
 * 1670. 设计前中后队列
 * medium
 *
 * @author avatarannappa
 * @date 2023/11/28
 */
public class FrontMiddleBackQueue1670 {

    public static class Node {

        private int val;
        private Node prev;
        private Node next;

        public Node(int val) {
            this.val = val;
        }

        public Node() {
        }
    }

    Node head;
    Node tail;
    Node mid;
    int size;

    public FrontMiddleBackQueue1670() {
        // 简化版LRU缓存，不使用Deque
        head = new Node();
        tail = new Node();
        head.next = tail;
        tail.prev = head;
        mid = head;
        size = 0;
    }

    public void pushFront(int val) {
        Node node = new Node(val);
        node.next = head.next;
        node.prev = head;
        head.next.prev = node;
        head.next = node;
        if (size == 0) {
            mid = node;
        } else {
            mid = size % 2 == 0 ? mid : mid.prev;
        }
        size++;
    }

    public void pushMiddle(int val) {
        Node node = new Node(val);
        if (size == 0) {
            node.next = tail;
            tail.prev = node;
            node.prev = head;
            head.next = node;
        } else if (size % 2 == 0) {
            node.next = mid.next;
            node.prev = mid;
            mid.next = node;
            node.next.prev = node;
        } else {
            node.next = mid;
            node.prev = mid.prev;
            mid.prev = node;
            node.prev.next = node;
        }
        mid = node;
        size++;
    }

    public void pushBack(int val) {
        Node node = new Node(val);
        node.next = tail;
        node.prev = tail.prev;
        tail.prev.next = node;
        tail.prev = node;
        if (size == 0) {
            mid = node;
        } else {
            mid = size % 2 == 0 ? mid.next : mid;
        }
        size++;
    }

    public int popFront() {
        if (size == 0) {
            return -1;
        }
        int ret = head.next.val;
        head.next = head.next.next;
        head.next.prev = head;
        mid = size % 2 == 0 ? mid.next : mid;
        size--;
        if (size == 0) {
            mid = head;
        }
        return ret;
    }

    public int popMiddle() {
        if (size == 0) {
            return -1;
        }
        int ret = mid.val;
        mid.next.prev = mid.prev;
        mid.prev.next = mid.next;
        mid = size % 2 == 0 ? mid.next : mid.prev;
        size--;
        if (size == 0) {
            mid = head;
        }
        return ret;
    }

    public int popBack() {
        if (size == 0) {
            return -1;
        }
        int ret = tail.prev.val;
        tail.prev.prev.next = tail;
        tail.prev = tail.prev.prev;
        mid = size % 2 == 0 ? mid : mid.prev;
        size--;
        if (size == 0) {
            mid = head;
        }
        return ret;
    }
}
