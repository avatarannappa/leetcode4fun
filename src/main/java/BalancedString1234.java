/**
 * 1234. 替换子串得到平衡字符串
 * medium
 *
 * @author avatarannappa
 * @date 2023/2/13
 */
public class BalancedString1234 {

    public int balancedString(String s) {
        // 规律 & (同向双指针 | 滑动窗口)
        char[] arr = s.toCharArray();
        int[] cnt = new int['Z'];
        for (char c : arr) {
            cnt[c]++;
        }
        int n = s.length();
        // 如果有子串外一个字符的数量大于m，则子串不论是什么都构不成平衡串
        int m = n / 4;
        if (cnt['Q'] == m && cnt['W'] == m && cnt['E'] == m && cnt['R'] == m) {
            return 0;
        }
        int ans = n;
        int left = 0;
        for (int right = 0; right < n; right++) {
            --cnt[s.charAt(right)];
            while (cnt['Q'] <= m && cnt['W'] <= m && cnt['E'] <= m && cnt['R'] <= m) {
                ans = Math.min(ans, right - left + 1);
                ++cnt[s.charAt(left++)];
            }
        }
        return ans;
    }

    public int balancedStringOld(String S) {
        char[] s = S.toCharArray();
        // 也可以用哈希表，不过数组更快一些
        int[] cnt = new int['X'];
        for (char c : s) {
            ++cnt[c];
        }
        int n = s.length, m = n / 4;
        if (cnt['Q'] == m && cnt['W'] == m && cnt['E'] == m && cnt['R'] == m) {
            // 已经符合要求啦
            return 0;
        }
        int ans = n;
        int left = 0;
        for (int right = 0; right < n; right++) {
            // 枚举子串右端点
            --cnt[s[right]];
            while (cnt['Q'] <= m && cnt['W'] <= m && cnt['E'] <= m && cnt['R'] <= m) {
                ans = Math.min(ans, right - left + 1);
                // 缩小子串
                ++cnt[s[left++]];
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        String s = "QQWE";
        // 输出：1
        System.out.println(new BalancedString1234().balancedString(s));
    }
}
