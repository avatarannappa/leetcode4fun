/**
 * 2140. 解决智力问题.
 * medium
 *
 * @author avatarannappa
 * @version 2025/4/1
 * @see Rob198 打家劫舍
 */
public class MostPoints2140 {

    public long mostPoints(int[][] questions) {
        // 记忆化搜索，从左往右
        int n = questions.length;
        long[] memo = new long[n];
        return recursion(0, questions, memo);
    }

    public long recursion(int index, int[][] questions, long[] memo) {
        if (index >= questions.length) {
            return 0;
        }
        if (memo[index] > 0) {
            return memo[index];
        }
        int point = questions[index][0];
        int power = questions[index][1];
        long noChoose = recursion(index + 1, questions, memo);
        long choose = recursion(index + power + 1, questions, memo) + point;
        return memo[index] = Math.max(noChoose, choose);
    }

    public long mostPointsNew(int[][] questions) {
        // 递推
        int n = questions.length;
        long[] f = new long[n + 1];
        for (int i = n - 1; i >= 0; i--) {
            int point = questions[i][0];
            int power = questions[i][1];
            int j = Math.min(i + power + 1, n);
            f[i] = Math.max(f[i + 1], f[j] + point);
        }
        return f[0];
    }

}
