/**
 * 707. 设计链表
 * medium
 *
 * @author avatarannappa
 * @date 2022/9/23
 */
public class MyLinkedList707 {

    class ListNode {

        int val;
        ListNode next;

        public ListNode(int val) {
            this.val = val;
        }
    }

    int size;
    ListNode head;

    public MyLinkedList707() {
        // 哨兵
        head = new ListNode(0);
        size = 0;
    }

    public void out() {
        ListNode cur = head;
        for (int i = 0; i < size; i++) {
            cur = cur.next;
            System.out.print(cur.val + ",");
        }
        System.out.println();
    }
    
    public int get(int index) {
        if (index < 0 || index >= size) {
            return -1;
        }
        out();
        ListNode cur = head;
        for (int i = 0; i < index + 1; i++) {
            cur = cur.next;
        }
        return cur.val;
    }

    public void addAtHead(int val) {
        ListNode oldHead = head.next;
        ListNode newHead = new ListNode(val);
        head.next = newHead;
        newHead.next = oldHead;
        size++;
    }

    public void addAtTail(int val) {
        ListNode oldTail = head;
        while (oldTail.next != null) {
            oldTail = oldTail.next;
        }
        ListNode newTail = new ListNode(val);
        oldTail.next = newTail;
        size++;
    }

    public void addAtIndex(int index, int val) {
        if (index <= 0) {
            addAtHead(val);
        } else if (index == size) {
            addAtTail(val);
        } else if (index < size) {
            ListNode cur = head;
            for (int i = 0; i < index; i++) {
                cur = cur.next;
            }
            ListNode next = cur.next;
            ListNode insert = new ListNode(val);
            cur.next = insert;
            insert.next = next;
            size++;
        }
    }

    public void deleteAtIndex(int index) {
        if (index >= 0 && index < size) {
            ListNode cur = head;
            for (int i = 0; i < index; i++) {
                cur = cur.next;
            }
            ListNode toDelete = cur.next;
            cur.next = toDelete.next;
            toDelete.next = null;
            size--;
        }
    }

    public static void main(String[] args) {
        MyLinkedList707 myLinkedList = new MyLinkedList707();
        myLinkedList.addAtHead(5);
        myLinkedList.addAtIndex(1, 2);
        myLinkedList.get(1);
        myLinkedList.addAtHead(6);
        myLinkedList.addAtTail(2);
        myLinkedList.get(3);
        myLinkedList.addAtTail(1);
        myLinkedList.get(5);
        myLinkedList.addAtHead(2);
        myLinkedList.get(2);
        myLinkedList.addAtHead(6);
    }
}
