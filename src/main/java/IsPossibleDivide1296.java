import java.math.BigDecimal;
import java.util.Map;
import java.util.TreeMap;

/**
 * 1296. 划分数组为连续数字的集合.
 * medium
 *
 * @author avatarannappa
 * @version 1.0 2021/12/10
 */
public class IsPossibleDivide1296 {

    public boolean isPossibleDivide(int[] nums, int k) {
        // 同846. 一手顺子
        // TreeMap
        if (nums.length % k != 0) {
            return false;
        }
        Map<Integer, Integer> map = new TreeMap<>();
        for (int i : nums) {
            map.put(i, map.getOrDefault(i, 0) + 1);
        }
        for (Map.Entry<Integer, Integer> en : map.entrySet()) {
            int key = en.getKey();
            int val = en.getValue();
            for (int x = 0; x < val; x++) {
                for (int i = 1; i < k; i++) {
                    int nextKey = key + i;
                    int nextVal = map.getOrDefault(nextKey, 0);
                    if (nextVal <= 0) {
                        return false;
                    }
                    map.put(nextKey, nextVal - 1);
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        BigDecimal a = BigDecimal.valueOf(0.5);
        BigDecimal b = BigDecimal.valueOf(2);
        System.out.println(a.subtract(b));
        System.out.println(a.subtract(b).intValue());
    }
}
