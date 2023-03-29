import java.util.Arrays;

/**
 * 1641. 统计字典序元音字符串的数目
 * medium
 *
 * @author avatarannappa
 * @date 2023/3/29
 */
public class CountVowelStrings1641 {

    public int countVowelStrings(int n) {
        // dp
        int[] dp = new int[5];
        Arrays.fill(dp, 1);
        for (int i = 0; i < n; i++) {
            for (int j = 1; j < 5; j++) {
                dp[j] += dp[j - 1];
            }
        }
        return dp[4];
    }

    public int countVowelStringsNew(int n) {
        // 组合数学
        return (n + 1) * (n + 2) * (n + 3) * (n + 4) / 24;
    }

    public static void main(String[] args) {
        int n = 2;
        // 15
        System.out.println(new CountVowelStrings1641().countVowelStrings(n));
    }
}
