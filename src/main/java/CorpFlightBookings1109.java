/**
 * 1109. 航班预订统计.
 * medium
 *
 * @author avatarannappa
 * @version 1.0
 * @date 2022/3/9
 */
public class CorpFlightBookings1109 {

    public int[] corpFlightBookings(int[][] bookings, int n) {
        // 差分 O(m + n)
        int[] cf = new int[n + 1];
        for (int[] b : bookings) {
            int l = b[0] - 1;
            int r = b[1];
            int v = b[2];
            cf[l] += v;
            cf[r] -= v;
        }
        
        int[] ans = new int[n];
        ans[0] = cf[0];
        for (int i = 1; i < n; i++) {
            ans[i] = ans[i - 1] + cf[i];
        }
        return ans;
    }
    
    public int[] corpFlightBookingsOld(int[][] bookings, int n) {
        // 模拟 O(m * n)
        int[] ans = new int[n];

        for (int i = 0; i < bookings.length; i++) {
            int[] booking = bookings[i];
            for (int j = booking[0] - 1; j <= booking[1] - 1; j++) {
                ans[j] += booking[2];
            }
        }

        return ans;
    }
    
}
