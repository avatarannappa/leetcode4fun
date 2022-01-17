import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

/**
 * 373. 查找和最小的 K 对数字.
 * medium
 *
 * @author avatarannappa
 * @version 1.0
 * @date 2022/1/17
 */
public class KSmallestPairs373 {

    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        // 双路归并
        List<List<Integer>> ans = new ArrayList<>();
        PriorityQueue<int[]> queue = new PriorityQueue<>(
            (o1, o2) -> nums1[o1[0]] + nums2[o1[1]] - nums1[o2[0]] - nums2[o2[1]]);
        for (int i = 0; i < nums1.length; i++) {
            int[] temp = {i, 0};
            queue.add(temp);
        }
        
        while (ans.size() < k && !queue.isEmpty()) {
            int[] top = queue.poll();
            List<Integer> item = new ArrayList<>();
            item.add(nums1[top[0]]);
            item.add(nums2[top[1]]);
            ans.add(item);
            if (top[1] + 1 < nums2.length) {
                queue.add(new int[]{top[0], top[1] + 1});
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] nums1 = {1, 7, 11};
        int[] nums2 = {2, 4, 6};
        int k = 3;
        System.out.println(new KSmallestPairs373().kSmallestPairs(nums1, nums2, k));
    }
}
