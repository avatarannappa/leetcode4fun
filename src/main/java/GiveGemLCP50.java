/**
 * LCP 50. 宝石补给
 * easy
 *
 * @author chenhao138
 * @date 2023/9/15
 */
public class GiveGemLCP50 {

    public int giveGem(int[] gem, int[][] operations) {
        // 简单模拟
        for (int[] operation : operations) {
            int num = (int) Math.floor(gem[operation[0]] / 2);
            gem[operation[0]] -= num;
            gem[operation[1]] += num;
        }
        int max = gem[0];
        int min = gem[0];
        for (int i : gem) {
            max = Math.max(max, i);
            min = Math.min(min, i);
        }
        return max - min;
    }
}
