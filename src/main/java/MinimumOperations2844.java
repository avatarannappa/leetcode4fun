import java.util.HashMap;
import java.util.Map;

/**
 * 2844. 生成特殊数字的最少操作
 * medium
 *
 * @author avatarannappa
 * @date 2024/7/25
 */
public class MinimumOperations2844 {

    public int minimumOperations(String num) {
        // 枚举：结尾是00，50，25，75；如果都不是且有一个0，则移除n - 1位，如：10，否则移除n位，及得到空字符串
        int last0 = -1;
        int last5 = -1;
        int n = num.length();
        for (int i = n - 1; i >= 0; i--) {
            char c = num.charAt(i);
            if (c == '0') {
                if (last0 == -1) {
                    last0 = i;
                    continue;
                }
            } else if (c == '5') {
                if (last0 == -1) {
                    last5 = i;
                    continue;
                }
            } else if (c == '2' || c == '7') {
                if (last5 == -1) {
                    continue;
                }
            } else {
                continue;
            }
            return n - 2 - i;
        }
        return last0 == -1 ? n : n - 1;
    }

    Map<String, Integer> map = new HashMap<>();

    public int minimumOperationsOld(String num) {
        // 记忆化搜索，num长度100会超
        if (Long.parseLong(num) % 25 == 0) {
            return 0;
        }
        return dfs(num, 0);
    }

    public int dfs(String num, int cnt) {
        if (num.isEmpty()) {
            return cnt;
        }
        if (Long.parseLong(num) % 25 == 0) {
            return cnt;
        }
        if (map.containsKey(num)) {
            return map.get(num);
        }
        int res = Integer.MAX_VALUE;
        for (int i = 0; i < num.length(); i++) {
            res = Math.min(res, dfs(num.substring(0, i) + num.substring(i + 1), cnt + 1));
        }
        map.put(num, res);
        return res;
    }

    public static void main(String[] args) {
        String num = "2245047";
        // 输出：2
        System.out.println(new MinimumOperations2844().minimumOperations(num));
    }

}
