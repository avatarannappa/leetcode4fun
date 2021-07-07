import java.util.HashMap;
import java.util.Map;

/**
 * 1711. 大餐计数
 * medium
 *
 * @author avatarannappa
 * @version 1.0, 2021/7/7
 */
public class CountPairs1711 {

    public int countPairs(int[] deliciousness) {
        // hash表
        int len = deliciousness.length;
        int max = 0;
        for (int i : deliciousness) {
            max = Math.max(max, i);
        }
        int maxSum = max * 2;
        Map<Integer, Integer> map = new HashMap<>();
        int res = 0;
        for (int i = 0; i < len; i++) {
            int val = deliciousness[i];
            for (int j = 1; j <= maxSum; j <<= 1) {
                int left = j - val;
                int count = map.getOrDefault(left, 0);
                res = (res + count) % 1000000007;
            }
            map.put(val, map.getOrDefault(val, 0) + 1);
        }
        return res;
    }

    public static void main(String[] args) {
        int[] deliciousness = {1, 3, 5, 7, 9};
        System.out.println(new CountPairs1711().countPairs(deliciousness));
    }
}
