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
        // 模拟
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
