package LCP;

/**
 * LCP 61. 气温变化趋势
 * easy
 *
 * @author avatarannappa
 * @date 2024/6/21
 */
public class TemperatureTrend61 {

    public int temperatureTrend(int[] temperatureA, int[] temperatureB) {
        // 简单模拟
        int n = temperatureA.length;
        int ans = 0;
        int temp = 0;
        for (int i = 1; i < n; i++) {
            int a = temperatureA[i] - temperatureA[i - 1];
            int b = temperatureB[i] - temperatureB[i - 1];
            if ((a > 0 && b > 0) || (a < 0 && b < 0) || (a == 0 && b == 0)) {
                temp++;
                ans = Math.max(ans, temp);
            } else {
                temp = 0;
            }
        }

        return ans;
    }
}
