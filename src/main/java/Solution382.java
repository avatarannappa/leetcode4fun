import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * 382. 链表随机节点.
 *
 * @author avatarannappa
 * @version 1.0, 2020/10/13
 */
public class Solution382 {

    private ListNode head;

    private Random random = new Random();

    private List<Integer> list = new ArrayList();

    /**
     * @param head The linked list's head.
     *             Note that the head is guaranteed to be not null, so it contains at least one node.
     */
    public Solution382(ListNode head) {
        this.head = head;
    }

    /**
     * Returns a random node's value.
     */
    public int getRandom() {
        // 蓄水池抽样
        ListNode index = head;
        int i = 1;
        int res = index.val;
        while (index.next != null) {
            index = index.next;
            i++;
            if (random.nextInt(i) == 0) {
                res = index.val;
            }
        }
        return res;
    }

    public void Solution382Old(ListNode head) {
        this.head = head;
        while (head != null) {
            list.add(head.val);
            head = head.next;
        }
    }

    /**
     * Returns a random node's value.
     */
    public int getRandomOld() {
        return list.get(random.nextInt(list.size()));
    }

    public static void main(String[] args) {
        Random random = new Random();
        for (int i = 0; i < 100; i++) {
            System.out.println(random.nextInt(2));
        }
    }
}
