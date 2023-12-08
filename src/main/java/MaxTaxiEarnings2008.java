import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * 2008. 出租车的最大盈利, Maximum Earnings From Taxi
 * medium
 *
 * @author avatarannappa
 * @date 2023/12/8
 */
public class MaxTaxiEarnings2008 {

    public long maxTaxiEarnings(int n, int[][] rides) {
        // DP O(m * n)
        long[] dp = new long[n + 1];
        // 如果用hashmap存储end的列表，就不需要排序。时间复杂度O(m * n) 减少为 O(m + n)
        Arrays.sort(rides, Comparator.comparingInt(r -> r[1]));
        int j = 0;
        for (int i = 1; i <= n; i++) {
            dp[i] = dp[i - 1];
            if (j < rides.length && rides[j][1] == i) {
                while (j < rides.length && rides[j][1] == i) {
                    int[] ride = rides[j++];
                    dp[i] = Math.max(dp[i], dp[ride[0]] + i - ride[0] + ride[2]);
                }
            }
        }

        return dp[n];
    }

    public long maxTaxiEarningsNew(int n, int[][] rides) {
        // DP O(m + n)
        long[] dp = new long[n + 1];
        Map<Integer, List<int[]>> map = new HashMap<>();
        for (int[] ride : rides) {
            List<int[]> l = map.getOrDefault(ride[1], new LinkedList<>());
            l.add(ride);
            map.put(ride[1], l);
        }
        int j = 0;
        for (int i = 1; i <= n; i++) {
            dp[i] = dp[i - 1];
            if (map.containsKey(i)) {
                for (int[] ride : map.get(i)) {
                    dp[i] = Math.max(dp[i], dp[ride[0]] + i - ride[0] + ride[2]);
                }
            }
        }

        return dp[n];
    }

    public static void main(String[] args) {
        // int n = 20;
        // int[][] rides = {{1, 6, 1}, {3, 10, 2}, {10, 12, 3}, {11, 12, 2}, {12, 15, 2}, {13, 18, 1}};
        // 20
        int n = 5;
        int[][] rides = {{2, 5, 4}, {1, 5, 1}};
        System.out.println(new MaxTaxiEarnings2008().maxTaxiEarnings(n, rides));

    }
}
