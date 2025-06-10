import java.util.HashMap;
import java.util.Map;

/**
 * 3442. 奇偶频次间的最大差值I.
 * easy.
 *
 * @author avatarannappa
 * @version 1.0
 * @date 2025/6/10
 */
public class MaxDifference3442 {

    public int maxDifference(String s) {
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0) + 1);
        }
        int minEven = Integer.MAX_VALUE;
        int maxOdd = Integer.MIN_VALUE;
        for (Integer value : map.values()) {
            if (value % 2 == 0) {
                minEven = Math.min(minEven, value);
            } else {
                maxOdd = Math.max(maxOdd, value);
            }
        }
        return maxOdd - minEven;
    }

    public static void main(String[] args) {
        // 1
        System.out.println(new MaxDifference3442().maxDifference("tzt"));
    }
}
