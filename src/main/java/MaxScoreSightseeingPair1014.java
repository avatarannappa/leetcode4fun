/**
 * 1014. 最佳观光组合. medium
 *
 * @author avatarannappa
 * @version 1.0
 * @date 2021/10/18
 */
public class MaxScoreSightseeingPair1014 {

    public int maxScoreSightseeingPair(int[] values) {
        // DP values[i] + values[j] + i - j; 其中i<j
        int maxI = Math.max(values[0], values[1] + 1);
        int result = values[0] + values[1] - 1;
        for (int i = 2; i < values.length; i++) {
            result = Math.max(result, maxI + values[i] - i);
            maxI = Math.max(maxI, values[i] + i);
        }
        return result;
    }

    public int maxScoreSightseeingPairOld(int[] values) {
        // O(n**2) 不出意外的超时
        if (values == null || values.length < 2) {
            return 0;
        }
        int result = 0;
        for (int i = 0; i < values.length; i++) {
            for (int j = i + 1; j < values.length; j++) {
                result = Math.max(result, values[i] + values[j] + i - j);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] values = { 8, 1, 5, 2, 6 };
        // 11
        System.out.println(new MaxScoreSightseeingPair1014().maxScoreSightseeingPair(values));
    }
}
