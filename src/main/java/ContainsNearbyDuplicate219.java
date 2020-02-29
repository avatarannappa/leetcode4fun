/**
 * 219. 存在重复元素 II
 *
 * @author avatarannappa
 * @version 1.0, 2020/3/1
 */
public class ContainsNearbyDuplicate219 {

    public boolean containsNearbyDuplicate(int[] nums, int k) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j <= i + k & j < nums.length; j++) {
                if (nums[i] == nums[j]) {
                    return true;
                }
            }
        }
        return false;
    }

}
