import java.util.Arrays;

/**
 * 55. 跳跃游戏
 *
 * @author avatarannappa
 * @version 1.0, 2019/12/23
 */
public class CanJump55 {

    public boolean canJump(int[] nums) {
        if (nums.length == 1) {
            return true;
        }
        int last = nums.length - 1;
        for (int i = nums.length - 2; i >= 0; i--) {
            if (nums[i] >= last - i) {
                last = i;
            }
        }
        return last == 0 ? true : false;
    }

    public boolean canJumpRecursion(int[] nums) {
        if (nums.length == 1) {
            return true;
        }
        int last = nums.length - 1;
        int index = -1;
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] >= last - i) {
                index = i;
                break;
            }
        }
        if (index < 0) {
            return false;
        }
        return canJump(Arrays.copyOf(nums, index + 1));
    }

    public static void main(String[] args) {
        int[] a = {2, 3, 1, 1, 4};
        int[] b = {3, 2, 1, 0, 4};
        int[] c = {1, 2};
        System.out.println(new CanJump55().canJump(a));
        System.out.println(new CanJump55().canJump(b));
        System.out.println(new CanJump55().canJump(c));
    }
}
