import java.util.Arrays;

/**
 * 1626. 无矛盾的最佳球队
 * medium
 *
 * @author avatarannappa
 * @date 2023/3/22
 */
public class BestTeamScore1626 {

    public int bestTeamScore(int[] scores, int[] ages) {
        // dp 最长递增子序列
        int n = scores.length;
        int[][] people = new int[n][2];
        for (int i = 0; i < n; ++i) {
            people[i] = new int[]{scores[i], ages[i]};
        }
        Arrays.sort(people, (a, b) -> a[0] != b[0] ? a[0] - b[0] : a[1] - b[1]);

        int[] dp = new int[n];
        int res = 0;
        for (int i = 0; i < n; ++i) {
            for (int j = i - 1; j >= 0; --j) {
                if (people[j][1] <= people[i][1]) {
                    dp[i] = Math.max(dp[i], dp[j]);
                }
            }
            dp[i] += people[i][0];
            res = Math.max(res, dp[i]);
        }
        return res;
    }

    public int bestTeamScoreNew(int[] scores, int[] ages) {
        // dp 最长递增子序列
        int n = scores.length;
        int[][] arr = new int[n][2];
        for (int i = 0; i < n; ++i) {
            arr[i] = new int[]{ages[i], scores[i]};
        }
        Arrays.sort(arr, (a, b) -> a[0] != b[0] ? a[0] - b[0] : a[1] - b[1]);

        int[] dp = new int[n];
        int res = 0;
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < i; j++) {
                if (arr[j][1] <= arr[i][1]) {
                    dp[i] = Math.max(dp[i], dp[j]);
                }
            }
            dp[i] += arr[i][1];
            res = Math.max(res, dp[i]);
        }
        return res;
    }

    public static void main(String[] args) {
        int[] scores = {1, 3, 7, 3, 2, 4, 10, 7, 5};
        int[] ages = {4, 5, 2, 1, 1, 2, 4, 1, 4};
        // 29
        System.out.println(new BestTeamScore1626().bestTeamScoreNew(scores, ages));
    }
}
