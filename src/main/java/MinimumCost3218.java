import java.util.Arrays;

/**
 * 3218. 切蛋糕的最小总开销 I.
 * medium
 *
 * @author avatarannappa
 * @version 2024/12/25
 * @see MinimumCost3219
 */
public class MinimumCost3218 {

    public int minimumCost(int m, int n, int[] horizontalCut, int[] verticalCut) {
        // 贪心
        // 最小生成树的 Kruskal 算法
        int res = 0;
        Arrays.sort(horizontalCut);
        Arrays.sort(verticalCut);
        int i = 0;
        int j = 0;
        int row = m;
        int col = n;
        while (i < m - 1 || j < n - 1) {
            int h = i < m - 1 ? horizontalCut[i] : Integer.MAX_VALUE;
            int v = j < n - 1 ? verticalCut[j] : Integer.MAX_VALUE;
            if (h < v) {
                res += h * col;
                i++;
                row--;
            } else {
                res += v * row;
                j++;
                col--;
            }
        }

        return res;
    }

    public static void main(String[] args) {
        int m = 3, n = 2;
        int[] horizontalCut = {1, 3}, verticalCut = {5};
        // 输出：13
        System.out.println(new MinimumCost3218().minimumCost(m, n, horizontalCut, verticalCut));
    }
}
