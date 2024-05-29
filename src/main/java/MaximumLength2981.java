import java.util.HashSet;
import java.util.Set;

/**
 * 2981. 找出出现至少三次的最长特殊子字符串 I
 * medium
 *
 * @author avatarannappa
 * @version 1.0, 2024/5/29
 */
public class MaximumLength2981 {

    public int maximumLength(String s) {
        // 模拟
        // TODO 分类26个字母讨论
        int res = -1;

        int n = s.length();
        Set<String> set = new HashSet<>();
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n - 2; j++) {
                if (s.charAt(i) != s.charAt(j)) {
                    break;
                }
                if (j - i + 1 <= res) {
                    continue;
                }
                String sub = s.substring(i, j + 1);
                if (set.contains(sub)) {
                    continue;
                }
                int cnt = 0;
                for (int k = i + 1; k < n; k++) {
                    k = s.indexOf(sub, k);
                    if (k != -1) {
                        cnt++;
                    } else {
                        break;
                    }
                    if (cnt >= 2) {
                        res = Math.max(res, sub.length());
                        break;
                    }
                }
                set.add(sub);
            }
        }

        return res;
    }

    public static void main(String[] args) {
        String s = "cbc";
        // -1
        System.out.println(new MaximumLength2981().maximumLength(s));
    }
}
