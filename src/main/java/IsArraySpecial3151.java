/**
 * 3151. 特殊数组 I
 * easy
 *
 * @author avatarannappa
 * @date 2024/8/13
 */
public class IsArraySpecial3151 {

  public boolean isArraySpecial(int[] nums) {
    // 简单模拟
    for (int i = 1; i < nums.length; i++) {
      if (nums[i] % 2 == nums[i - 1] % 2) {
        return false;
      }
    }
    return true;
  }

}
