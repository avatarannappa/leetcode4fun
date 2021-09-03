import java.util.HashMap;
import java.util.Map;


/**
 * 697. 数组的度 easy
 *
 * @author avatarannappa
 * @version 1.0
 * @date 2021/9/3
 */
public class FindShortestSubArray697 {

    public int findShortestSubArray(int[] nums) {
        int max = 0;
        int min = Integer.MAX_VALUE;
        Map<Integer, int[]> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i])) {
                int[] value = map.get(nums[i]);
                value[1] = value[1] + 1;
                value[2] = i - value[0] + 1;
                map.put(nums[i], value);
            } else {
                int[] value = new int[3];
                value[0] = i;
                value[1] = 1;
                value[2] = 1;
                map.put(nums[i], value);
            }
        }

        for (Map.Entry<Integer, int[]> entry : map.entrySet()) {
            int[] value = entry.getValue();
            int count = value[1];
            int len = value[2];
            if (count > max) {
                min = len;
                max = count;
            } else if (count == max) {
                min = Math.min(min, len);
            }
        }
        return min;
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 2, 3, 1};
        System.out.println(new FindShortestSubArray697().findShortestSubArray(nums));
    }

}
