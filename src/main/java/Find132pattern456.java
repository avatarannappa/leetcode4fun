import java.util.Deque;
import java.util.LinkedList;

/**
 * 456. 132模式
 * medium
 *
 * @author avatarannappa
 * @version 1.0, 2021/3/26
 */
public class Find132pattern456 {

    public boolean find132pattern(int[] nums) {
        // O(n) 单调栈
        int n = nums.length;
        Deque<Integer> candidateK = new LinkedList<Integer>();
        candidateK.push(nums[n - 1]);
        int maxK = Integer.MIN_VALUE;

        for (int i = n - 2; i >= 0; --i) {
            if (nums[i] < maxK) {
                return true;
            }
            while (!candidateK.isEmpty() && nums[i] > candidateK.peek()) {
                maxK = candidateK.pop();
            }
            if (nums[i] > maxK) {
                candidateK.push(nums[i]);
            }
        }

        return false;
    }

    public boolean find132pattern2(int[] nums) {
        // O(n ^ 3) - O(n ^ 2) 记录下左边最小的 通过
        if (nums == null || nums.length < 3) {
            return false;
        }
        int len = nums.length;

        int[] left = new int[nums.length];
        left[0] = Integer.MAX_VALUE;

        for (int i = 0; i < len - 1; i++) {
            if (nums[i] < left[i]) {
                left[i + 1] = nums[i];
            } else {
                left[i + 1] = left[i];
            }
        }

        for (int i = 0; i < len; i++) {
            for (int j = i + 1; j < len; j++) {
                if (nums[i] > nums[j] && nums[j] > left[i]) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean find132pattern1(int[] nums) {
        // O(n ^ 3)
        if (nums == null || nums.length < 3) {
            return false;
        }
        int len = nums.length;
        for (int i = 0; i < len; i++) {
            for (int j = i + 1; j < len; j++) {
                for (int k = j + 1; k < len; k++) {
                    if (nums[k] > nums[i] && nums[j] > nums[k]) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        // int[] nums = {1, 0, 1, -4, -3};
        int[] nums = {3, 5, 0, 3, 4};
        System.out.println(new Find132pattern456().find132pattern(nums));
    }
}
