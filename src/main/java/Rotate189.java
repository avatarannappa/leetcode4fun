import java.util.Arrays;

/**
 * 189. 旋转数组
 *
 * @author avatarannappa
 * @version 1.0, 2020/1/16
 */
public class Rotate189 {
    public void rotate(int[] nums, int k) {
        // 时间复杂度O(n) 空间复杂度O(1)
        if (nums == null || nums.length < 2) {
            return;
        }
        k = k % nums.length;
        if (k == 0) {
            return;
        }

        for (int i = 0, count = 0; count < nums.length; i++) {
            int fromIndex = i;
            int fromValue = nums[i];
            int tempIndex = fromIndex;
            do {
                // n k最大公约数>1,如：6，2；6，4
                int toIndex = (tempIndex + k) % nums.length;
                int toValue = nums[toIndex];
                nums[toIndex] = fromValue;
                tempIndex = toIndex;
                fromValue = toValue;
                count++;
            } while (tempIndex != fromIndex);
        }
    }

    public void rotateOld(int[] nums, int k) {
        // 时间复杂度O(n) 空间复杂度O(n)
        if (nums == null || nums.length < 2) {
            return;
        }
        k = k % nums.length;
        if (k == 0) {
            return;
        }
        int[] res = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            int to = (i + k) % nums.length;
            res[to] = nums[i];
        }
        for (int i = 0; i < nums.length; i++) {
            nums[i] = res[i];
        }
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 5};
        new Rotate189().rotate(nums, 3);
        System.out.println(Arrays.toString(nums));
    }
}
