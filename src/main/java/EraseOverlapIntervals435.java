import java.util.Arrays;
import java.util.Comparator;

/**
 * 435. 无重叠区间
 * medium
 *
 * @author avatarannappa
 * @date 2022/9/13
 */
public class EraseOverlapIntervals435 {

    public int eraseOverlapIntervals(int[][] intervals) {
        // 贪心
        if (intervals.length == 1) {
            return 0;
        }
        Arrays.sort(intervals, Comparator.comparingInt(o -> o[1]));
        int right = intervals[0][1];
        int count = 1;

        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i][0] >= right) {
                count++;
                right = intervals[i][1];
            }
        }

        return intervals.length - count;
    }

    public static void main(String[] args) {
        int[][] intervals = {{1, 2}, {2, 3}, {3, 4}, {1, 3}};
        System.out.println(new EraseOverlapIntervals435().eraseOverlapIntervals(intervals));
    }
}
