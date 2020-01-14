import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

/**
 * @lc app=leetcode.cn id=23 lang=java
 * <p>
 * [23] 合并K个排序链表
 * <p>
 * https://leetcode-cn.com/problems/merge-k-sorted-lists/description/
 * <p>
 * algorithms
 * Hard (44.35%)
 * Total Accepted:    18.2K
 * Total Submissions: 41.1K
 * Testcase Example:  '[[1,4,5],[1,3,4],[2,6]]'
 * <p>
 * 合并 k 个排序链表，返回合并后的排序链表。请分析和描述算法的复杂度。
 * <p>
 * 示例:
 * <p>
 * 输入:
 * [
 * 1->4->5,
 * 1->3->4,
 * 2->6
 * ]
 * 输出: 1->1->2->3->4->4->5->6
 */
public class MergeKLists {

    private String key;

    private static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public static ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length < 1) {
            return null;
        }
        int size = lists.length;
        List<Integer> resultList = new LinkedList<>();

        for (int i = 0; i < size; i++) {
            if (lists[i] == null) {
                continue;
            }
            ListNode node = lists[i];
            while (node != null) {
                resultList.add(node.val);
                node = node.next;
            }
        }

        if (!resultList.isEmpty()) {
            resultList.sort(new Comparator<Integer>() {
                @Override
                public int compare(Integer o1, Integer o2) {
                    return o1 - o2;
                }
            });
            ListNode node = new ListNode(resultList.get(0));
            ListNode point = node;
            for (int i = 1; i < resultList.size(); i++) {
                ListNode t = new ListNode(resultList.get(i));
                point.next = t;
                point = t;

            }
            return node;
        }


        return null;
    }

    public static void main(String[] args) {
        ListNode one1 = new ListNode(0);
        ListNode two1 = new ListNode(1);
        ListNode three1 = new ListNode(2);
        one1.next = two1;
        two1.next = three1;

        ListNode one2 = new ListNode(1);
        ListNode two2 = new ListNode(4);
        ListNode three2 = new ListNode(6);
        one2.next = two2;
        two2.next = three2;

        ListNode one3 = new ListNode(3);
        ListNode two3 = new ListNode(5);
        one3.next = two3;

        ListNode[] lists = new ListNode[3];
        lists[0] = one1;
        lists[1] = one2;
        lists[2] = one3;

        ListNode result = mergeKLists(lists);
        while (result != null) {
            System.out.print(result.val);
            result = result.next;
            if (result != null) {
                System.out.print("->");

            }
        }

    }

}
