import java.util.HashMap;
import java.util.Map;

/**
 * 169. 多数元素
 *
 * @author avatarannappa
 * @version 1.0, 2019/12/21
 */
public class MajorityElement169 {

    public int majorityElementBoyerMoore(int[] nums) {
        int count = 1;
        int result = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (result == nums[i]) {
                count++;
            } else {
                count--;
                if (count == 0) {
                    result = nums[i];
                    count++;
                }
            }
        }
        return result;
    }

    public int majorityElement(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            if (map.containsKey(num)) {
                map.put(num, map.get(num) + 1);
            } else {
                map.put(num, 1);
            }
        }
        int half = nums.length / 2;
        for (Map.Entry<Integer, Integer> i : map.entrySet()) {
            if (i.getValue() > half) {
                return i.getKey();
            }
        }
        return nums[0];
    }

    public static void main(String[] args) {
        int[] a = {6, 5, 5};
        System.out.println(new MajorityElement169().majorityElementBoyerMoore(a));
    }
}
