import java.util.HashMap;
import java.util.Map;

/**
 * 1. 两数之和
 * easy
 *
 * @author avatarannappa
 * @version 1.0, 2018/12/18
 * 1.1 2021/07/07 优化哈希表写法
 */
public class TwoSum1 {

    public static void main(String[] args) {
        int[] nums =
                {230, 863, 916, 585, 981, 404, 316, 785, 88, 12, 70, 435, 384, 778, 887, 755, 740, 337, 86, 92, 325,
                        422, 815, 650, 920, 125, 277, 336, 221, 847, 168, 23, 677, 61, 400, 136, 874, 363, 394, 199,
                        863, 997, 794, 587, 124, 321, 212, 957, 764, 173, 314, 422, 927, 783, 930, 282, 306, 506, 44,
                        926, 691, 568, 68, 730, 933, 737, 531, 180, 414, 751, 28, 546, 60, 371, 493, 370, 527, 387, 43,
                        541, 13, 457, 328, 227, 652, 365, 430, 803, 59, 858, 538, 427, 583, 368, 375, 173, 809, 896,
                        370, 789};

        int target = 542;
        ;
        int[] result = twoSum2(nums, target);
        for (int i : result) {
            System.out.println(i);
        }
    }

    public static int[] twoSum(int[] nums, int target) {
        int[] result = new int[2];
        boolean returnSign = false;
        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if ((nums[i] + nums[j]) == target) {
                    result[0] = i;
                    result[1] = j;
                    returnSign = true;
                    break;
                }
            }
            if (returnSign) {
                break;
            }
        }
        return result;
    }

    public static int[] twoSum2(int[] nums, int target) {
        // 哈希表 同类：1711
        int[] result = new int[2];
        Map<Integer, Integer> maps = new HashMap<Integer, Integer>();
        for (int i = 0; i < nums.length; i++) {
            if (maps.containsKey(target - nums[i])) {
                result[0] = maps.get(target - nums[i]);
                result[1] = i;
                break;
            }
            maps.put(nums[i], i);
        }
        return result;
    }

}
