import java.util.HashSet;
import java.util.Set;

/**
 * 1044. 最长重复子串.
 * hard
 *
 * @author avatarannappa
 * @version 1.0
 * @date 2022/1/4
 */
public class LongestDupSubstring1044 {

    long[] preSum;
    long[] bit;

    public String longestDupSubstring(String s) {
        // 二分查找 + 前缀和，字符串hash（Integer hash是自己 O(1)，String hash O(str.len)复杂度）
        // or 二分查找 + Rabin-Karp 字符串编码，滑动窗口
        int seed = 1313131;
        int n = s.length();
        preSum = new long[n + 1];
        bit = new long[n + 1];
        bit[0] = 1;
        for (int i = 0; i < n; i++) {
            bit[i + 1] = bit[i] * seed;
            preSum[i + 1] = preSum[i] * seed + s.charAt(i);
        }

        String ans = "";
        int l = 0;
        int r = n - 1;
        while (l <= r) {
            // case:aa, l + r >>> 1会错过
            int mid = l + r + 1 >>> 1;
            String str = check(s, mid);
            if (str.length() != 0) {
                ans = str;
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        return ans;
    }

    public String check(String s, int len) {
        int n = s.length();
        Set<Long> set = new HashSet<>();
        for (int i = 1; i + len - 1 <= n; i++) {
            int j = i + len - 1;
            // 通过10进制思考
            // 45 = 12345 - 123 * 100
            long cur = preSum[j] - preSum[i - 1] * bit[j - i + 1];
            if (set.contains(cur)) {
                return s.substring(i - 1, j);
            }
            set.add(cur);
        }
        return "";
    }

    public static void main(String[] args) {
        // s = "aa", a
        String s = "banana";
        // ana
        System.out.println(new LongestDupSubstring1044().longestDupSubstring(s));
    }
}
