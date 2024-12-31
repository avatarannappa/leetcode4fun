import java.util.Arrays;

/**
 * 3219. 切蛋糕的最小总开销 II.
 * hard
 *
 * @author avatarannappa
 * @version 2024/12/31
 * @see MinimumCost3218
 */
public class MinimumCost3219 {

    public long minimumCost(int m, int n, int[] horizontalCut, int[] verticalCut) {
        Arrays.sort(horizontalCut); // 下面倒序遍历 
        Arrays.sort(verticalCut);
        long ans = 0;
        int i = 0;
        int j = 0;
        while (i < m - 1 || j < n - 1) {
            if (j == n - 1 || i < m - 1 && horizontalCut[i] < verticalCut[j]) {
                ans += horizontalCut[i++] * (n - j); // 上下连边
            } else {
                ans += verticalCut[j++] * (m - i); // 左右连边 
            }
        }
        return ans;
    }
}
