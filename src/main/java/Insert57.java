import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * 57. 插入区间.
 *
 * @author avatarannappa
 * @version 1.0, 2020/8/25
 */
public class Insert57 {

    public int[][] insert(int[][] intervals, int[] newInterval) {
        if (newInterval == null || newInterval.length < 1) {
            return intervals;
        }
        if (intervals == null || intervals.length == 0) {
            int[][] result = new int[1][];
            result[0] = newInterval;
            return result;
        }

        List<int[]> list = new LinkedList<>();
        int newStart = newInterval[0];
        int newEnd = newInterval[1];
        for (int i = 0; i < intervals.length; i++) {
            int[] interval = intervals[i];
            int start = interval[0];
            int end = interval[1];
            if (end < newStart) {
                list.add(interval);
            } else if (start > newEnd) {
                list.add(interval);
            } else {
                if (start < newStart) {
                    newStart = start;
                }
                if (end > newEnd) {
                    newEnd = end;
                }
            }
        }

        int[] temp = new int[2];
        temp[0] = newStart;
        temp[1] = newEnd;

        if (list.size() == 0) {
            list.add(temp);
        } else {
            if (list.get(0)[0] > temp[1]) {
                list.add(0, temp);
            } else if (list.get(list.size() - 1)[1] < temp[0]) {
                list.add(list.size(), temp);
            } else {
                for (int i = 0; i < list.size(); i++) {
                    int s = list.get(i)[0];
                    if (temp[1] < s) {
                        list.add(i, temp);
                        break;
                    }
                }
            }
        }

        int[][] result = new int[list.size()][2];
        for (int i = 0; i < list.size(); i++) {
            result[i] = list.get(i);
        }

        return result;
    }

    public static void main(String[] args) {
        //        int[][] intervals = {{1, 2}, {3, 5}, {6, 7}, {8, 10}, {12, 16}};
        //        int[] newInterval = {4, 8};
        // [[1,2],[3,10],[12,16]]
        int[][] intervals = {{1, 5}};
        int[] newInterval = {2, 3};
        int[][] result = new Insert57().insert(intervals, newInterval);
        for (int[] ints : result) {
            System.out.println(Arrays.toString(ints));
        }
    }
}
