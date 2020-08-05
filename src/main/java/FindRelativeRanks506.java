import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 506. 相对名次
 *
 * @author avatarannappa
 * @version 1.0, 2020/8/5
 */
public class FindRelativeRanks506 {

    public String[] findRelativeRanks(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], i);
        }
        Arrays.sort(nums);
        String[] result = new String[nums.length];
        for (int i = nums.length - 1, j = 0; i >= 0; i--, j++) {
            if (i == nums.length - 1) {
                result[map.get(nums[i])] = "Gold Medal";
            } else if (i == nums.length - 2) {
                result[map.get(nums[i])] = "Silver Medal";
            } else if (i == nums.length - 3) {
                result[map.get(nums[i])] = "Bronze Medal";
            } else {
                result[map.get(nums[i])] = String.valueOf(j + 1);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] nums = {5, 4, 3, 2, 6};
        System.out.println(Arrays.toString(new FindRelativeRanks506().findRelativeRanks(nums)));
    }
}
