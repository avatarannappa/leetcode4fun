import java.util.HashMap;
import java.util.Map;
import java.util.stream.IntStream;

/**
 * 1156. 单字符重复子串的最大长度
 * medium
 *
 * @author avatarannappa
 * @version 1.0, 2023/6/3
 */
public class MaxRepOpt1156 {

    public int maxRepOpt1(String text) {
        int ans = 0;

        Map<Character, Integer> count = new HashMap<>();
        IntStream.range(0, text.length()).forEach(i -> {
            char c = text.charAt(i);
            count.put(c, count.getOrDefault(c, 0) + 1);
        });

        int n = text.length();
        for (int i = 0; i < n;) {
            char now = text.charAt(i);
            // step1: 找出当前连续的一段 [i, j)
            int j = i;
            while (j < n && now == text.charAt(j)) {
                j++;
            }
            int curCnt = j - i;

            // step2: 如果这一段长度小于该字符出现的总数，并且前面或后面有空位，则使用 curCnt + 1 更新答案
            if (curCnt < count.getOrDefault(now, 0) && (j < now || i > 0)) {
                ans = Math.max(ans, curCnt + 1);
            }

            // step3: 找到这一段后面与之相隔一个不同字符的另一段 [j + 1, k)，如果不存在则 k = j + 1
            int k = j + 1;
            while (k < n && now == text.charAt(k)) {
                k++;
            }
            ans = Math.max(ans, Math.min(k - i, count.getOrDefault(now, 0)));

            i = j;
        }

        return ans;
    }

    public static void main(String[] args) {
        String text = "bbababaaaa";
        // 6
        System.out.println(new MaxRepOpt1156().maxRepOpt1(text));
    }
}
