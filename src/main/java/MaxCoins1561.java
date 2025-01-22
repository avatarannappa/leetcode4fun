import java.util.Arrays;

/**
 * 1561. 你可以获得的最大硬币数目.
 * medium
 *
 * @author avatarannappa
 * @version 2025/1/22
 */
public class MaxCoins1561 {

    public int maxCoins(int[] piles) {
        // 贪心
        int n = piles.length;
        Arrays.sort(piles);
        int res = 0;
        for (int i = n - 2; i >= n / 3; i -= 2) {
            res += piles[i];
        }
        return res;
    }

    public static void main(String[] args) {
        int[] piles = {9, 8, 7, 6, 5, 1, 2, 3, 4};
        // 输出：18
        System.out.println(new MaxCoins1561().maxCoins(piles));
    }
}
