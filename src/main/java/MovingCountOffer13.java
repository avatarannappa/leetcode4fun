/**
 * 剑指 Offer 13. 机器人的运动范围
 * medium
 *
 * @author avatarannappa
 * @version 1.0, 2021/6/17
 */
public class MovingCountOffer13 {

    public int movingCount(int m, int n, int k) {
        int res = 0;
        int[][] mask = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int sum = 0;
                int x = i, y = j;
                while (x > 0) {
                    sum += x % 10;
                    x /= 10;
                }
                while (y > 0) {
                    sum += y % 10;
                    y /= 10;
                }
                if (sum <= k) {

                    if ((i == 0 && j == 0) || ((i > 0 && mask[i - 1][j] == 1) || (i < m - 1 && mask[i + 1][j] == 1) ||
                                               (j > 0 && mask[i][j - 1] == 1) || (j < n - 1 && mask[i][j + 1] == 1))) {
                        mask[i][j] = 1;
                        res++;
                    }
                }
            }
        }

        return res;
    }

    public static void main(String[] args) {
        int m = 39, n = 15;
        int k = 9;
        // 15
        System.out.println(new MovingCountOffer13().movingCount(m, n, k));
    }
}
