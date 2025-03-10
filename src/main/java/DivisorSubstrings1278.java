import java.util.HashMap;
import java.util.Map;

/**
 * 2269. 找到一个数字的 K 美丽值.
 * easy
 *
 * @author avatarannappa
 * @version 2025/3/10
 */
public class DivisorSubstrings1278 {

    public int divisorSubstrings(int num, int k) {
        // 数字转字符串
        int res = 0;
        String str = String.valueOf(num);
        Map<Integer, Boolean> map = new HashMap<>();
        for (int i = 0; i + k <= str.length(); i++) {
            String subStr = str.substring(i, i + k);
            Integer divisor = Integer.valueOf(subStr);
            if (divisor == 0) {
                continue;
            }
            if (map.getOrDefault(divisor, false)) {
                res++;
                continue;
            }
            if (num % divisor == 0) {
                res++;
                map.put(divisor, true);
            } else {
                map.put(divisor, false);
            }
        }
        return res;
    }

    public static void main(String[] args) {

    }

}
