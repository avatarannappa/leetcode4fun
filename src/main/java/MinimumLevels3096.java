/**
 * 3096. 得到更多分数的最少关卡数目
 * medium
 *
 * @author avatarannappa
 * @date 2024/7/19
 */
public class MinimumLevels3096 {

    public int minimumLevels(int[] possible) {
        int n = possible.length;
        int[] sum = new int[n];
        sum[0] = possible[0] == 1 ? 1 : -1;
        for (int i = 1; i < n; i++) {
            sum[i] = sum[i - 1] + (possible[i] == 1 ? 1 : -1);
        }
        for (int i = 0; i < n - 1; i++) {
            if (sum[i] > sum[n - 1] - sum[i]) {
                return i + 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] possible = {1, 1};
        // 输出：2
        System.out.println(new MinimumLevels3096().minimumLevels(possible));
    }
}
