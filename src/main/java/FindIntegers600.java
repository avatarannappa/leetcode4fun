/**
 * 600. 不含连续1的非负整数
 * hard
 *
 * @author avatarannappa
 * @date 2022/8/26
 */
public class FindIntegers600 {

    public int findIntegers(int n) {
        // DP + 递归解法
        String str = Integer.toBinaryString(n);
        int[][] dp = new int[32][2];
        dp[0][0] = 1;
        dp[0][1] = 1;
        dp[1][0] = 2;
        dp[1][1] = 1;

        if (n == 0) {
            return 1;
        } else if (n == 1) {
            return 2;
        } else if (n == 2) {
            return 3;
        } else if (n == 3) {
            return 3;
        }

        int ans = 0;
        char[] arr = str.toCharArray();
        int oneCount = 0;
        for (int i = 1; i < arr.length + 1; i++) {
            int index = arr.length - i;
            if (i > 1) {
                dp[i][0] = dp[i - 1][0] + dp[i - 1][1];
                dp[i][1] = dp[i - 1][0];
            }

            if (arr[index] == '1') {
                oneCount++;
            }
        }

        return dp[arr.length - 1][0] + (((n >> arr.length - 2) & 1) == 1 ? dp[arr.length - 2][0]
            : findIntegers(n ^ (1 << arr.length - 1)));
    }

    public static void main(String[] args) {
        // int n = 1000000000;
        // 2178309
        int n = 1000000000;
        // 8 6
        // 9 7
        // 10 8
        // 11 8
        System.out.println(new FindIntegers600().findIntegers(n));
    }
}
