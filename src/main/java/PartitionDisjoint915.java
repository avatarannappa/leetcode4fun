import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * 915. 分割数组
 * medium
 *
 * @author avatarannappa
 * @version 1.0, 2022/10/24
 */
public class PartitionDisjoint915 {

    public int partitionDisjointOld(int[] nums) {
        if (nums == null || nums.length < 2) {
            return 0;
        }
        PriorityQueue<Integer> left = new PriorityQueue<>(Comparator.reverseOrder());
        PriorityQueue<Integer> right = new PriorityQueue<>();
        for (int num : nums) {
            left.add(num);
        }

        int ans = 0;
        for (int i = nums.length - 1; i > 0; i--) {
            int num = nums[i];
            left.remove(num);
            right.add(num);
            if (left.peek() <= right.peek()) {
                ans = i;
            }
        }
        return ans;
    }

    public int partitionDisjoint(int[] nums) {
        if (nums == null || nums.length < 2) {
            return 0;
        }
        int[] arr = new int[nums.length];
        arr[nums.length - 1] = nums[nums.length - 1];
        for (int i = nums.length - 2; i > 0; i--) {
            arr[i] = Math.min(arr[i + 1], nums[i]);
        }

        if (nums[0] <= arr[1]) {
            return 1;
        }
        for (int i = 1; i < nums.length - 1; i++) {
            nums[i] = Math.max(nums[i], nums[i - 1]);
            if (nums[i] <= arr[i + 1]) {
                return i + 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        // 输入：nums = [5,0,3,8,6]
        // 输出：3
        // 解释：left = [5,0,3]，right = [8,6]
        int[] nums = { 5, 0, 3, 8, 6 };
        System.out.println(new PartitionDisjoint915().partitionDisjoint(nums));
    }
}
