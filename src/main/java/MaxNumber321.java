import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * 321. 拼接最大数 hard
 *
 * @author avatarannappa
 * @version 1.0
 * @date 2021/9/16
 */
public class MaxNumber321 {

    public int[] maxNumber(int[] nums1, int[] nums2, int k) {
        int[] res = new int[k];

        int len1 = nums1.length;
        int len2 = nums2.length;
        for (int subLen1 = 0; subLen1 <= len1 && subLen1 <= k; subLen1++) {
            if (subLen1 + len2 >= k) {
                List<Integer> l1 = new ArrayList<>();
                List<Integer> l2 = new ArrayList<>();
                l1 = findMax(nums1, subLen1);
                l2 = findMax(nums2, k - subLen1);
                res = mergeAndCompare(l1, l2, res);
            }
        }

        return res;
    }

    public List<Integer> findMax(int[] nums, int len) {
        // 找到固定长度最大的，单调栈
        Deque<Integer> stack = new LinkedList<>();
        if (len == 0) {
            return new ArrayList<>();
        }
        int i = 0;
        do {
            while (!stack.isEmpty() && stack.getLast() < nums[i] && nums.length - i > len - stack.size()) {
                stack.pollLast();
            }
            if (stack.size() < len) {
                stack.addLast(nums[i]);
            }
            i++;
        } while (!stack.isEmpty() && i < nums.length);

        return new ArrayList<>(stack);
    }

    public int[] mergeAndCompare(List<Integer> l1, List<Integer> l2, int[] to) {
        // 合并 注意不一样长，先取长的[8,9][8] 和 [8,1][8]两个case体会一下
        int[] res = new int[l1.size() + l2.size()];

        int i = 0, j = 0, k = 0;
        while (k < res.length) {
            if (i < l1.size() && j < l2.size()) {
                if (compare(l1, i, l2, j) > 0) {
                    res[k] = l1.get(i);
                    i++;
                } else {
                    res[k] = l2.get(j);
                    j++;
                }
                k++;
            } else if (i < l1.size()) {
                while (i < l1.size()) {
                    res[k++] = l1.get(i++);
                }
            } else {
                while (j < l2.size()) {
                    res[k++] = l2.get(j++);
                }
            }
        }
        // 比较是不是比现有最大值大
        for (int x = 0; x < res.length; x++) {
            if (res[x] > to[x]) {
                return res;
            } else if (res[x] < to[x]) {
                return to;
            }
        }

        return to;
    }

    private int compare(List<Integer> l1, int i, List<Integer> l2, int j) {
        // 比较两个list大小
        while (i < l1.size() && j < l2.size()) {
            if (l1.get(i) > l2.get(j)) {
                return 1;
            } else if (l1.get(i) < l2.get(j)) {
                return -1;
            }
            i++;
            j++;
        }
        return l1.size() - i - (l2.size() - j);
    }

    public static void main(String[] args) {
        // int[] nums1 = { 3, 4, 6, 5 };
        // int[] nums2 = { 9, 1, 2, 5, 8, 3 };
        // int k = 5;
        // 9, 8, 6, 5, 3

        // int[] nums1 = { 6, 7 };
        // int[] nums2 = { 6, 0, 4 };
        // int k = 5;
        // // [6, 7, 6, 0, 4]
        // int[] nums1 = { 3, 4, 6, 5 };
        // int[] nums2 = { 9, 1, 2, 5, 8, 3 };
        // int k = 5;
        // [9,8,6,5,3]
        // int[] nums1 = { 6, 3, 9, 0, 5, 6 };
        // int[] nums2 = { 2, 2, 5, 2, 1, 4, 4, 5, 7, 8, 9, 3, 1, 6, 9, 7, 0 };
        // int k = 23;
        // [6,3,9,2,2,5,2,1,4,4,5,7,8,9,3,1,6,9,7,0,5,6,0]
        int[] nums1 = { 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1,
                1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1,
                1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1,
                1, 1, 1, 1, 1, 1, 1, 1, 1 };
        int[] nums2 = { 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1,
                1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1,
                1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1,
                1, 1, 1, 1, 1, 1, 1, 1, 1 };
        int k = 100;
        System.out.println(Arrays.toString(new MaxNumber321().maxNumber(nums1, nums2, k)));
    }

}
