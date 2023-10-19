import java.util.HashMap;
import java.util.Map;

/**
 * 1726. 同积元组
 * medium
 *
 * @author avatarannappa
 * @date 2023/10/19
 */
public class TupleSameProduct1726 {

    public int tupleSameProduct(int[] nums) {
        Map<Integer, Integer> sameMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                int temp = nums[i] * nums[j];
                sameMap.put(temp, sameMap.getOrDefault(temp, 0) + 1);
            }
        }

        int ans = 0;

        for (Integer key : sameMap.keySet()) {
            int val = sameMap.get(key);
            ans += val * (val - 1) * 4;
        }

        return ans;
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 4, 5, 10};
        System.out.println(new TupleSameProduct1726().tupleSameProduct(nums));
    }
}
