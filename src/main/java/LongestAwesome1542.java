import java.util.Arrays;

/**
 * 1542. 找出最长的超赞子字符串
 * hard
 *
 * @author avatarannappa
 * @date 2024/5/20
 */
public class LongestAwesome1542 {

    public int longestAwesome(String s) {
        // 状态压测+前缀和
        int res = 0;
        int n = s.length();
        int[] preArray = new int[1 << 10];
        Arrays.fill(preArray, n);
        preArray[0] = -1;
        int pre = 0;
        for (int i = 0; i < n; i++) {
            int now = s.charAt(i) - '0';
            pre ^= 1 << now;
            for (int j = 0; j < 10; j++) {
                int tmp = pre ^ (1 << j);
                res = Math.max(res, i - preArray[tmp]); // 奇数
            }
            res = Math.max(res, i - preArray[pre]); // 偶数
            if (preArray[pre] == n) { // 首次遇到值为 pre 的前缀异或和，记录其下标 i
                preArray[pre] = i;
            }

        }

        return res;
    }

    public int longestAwesomeOld(String s) {
        // 暴力，超时
        int res = 0;
        int n = s.length();

        for (int i = 0; i < n; i++) {
            int[] mask = new int[10];
            for (int j = i; j < n; j++) {
                int now = s.charAt(j) - '0';
                mask[now] ^= 1;
                int cnt = 0;
                for (int k = 0; k < 10; k++) {
                    if (mask[k] == 1) {
                        cnt++;
                    }
                }
                if (cnt <= 1) {
                    res = Math.max(res, j - i + 1);
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        String s = "3242415";
        // 5
        System.out.println(new LongestAwesome1542().longestAwesome(s));
    }

}
