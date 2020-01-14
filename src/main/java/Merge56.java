import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.TreeMap;

/**
 * 56. 合并区间
 *
 * @author avatarannappa
 * @version 1.0, 2020/1/9
 */
public class Merge56 {

    public int[][] merge(int[][] intervals) {
        if (intervals == null || intervals.length < 2) {
            return intervals;
        }

        Arrays.sort(intervals, Comparator.comparingInt(o -> o[0]));

        LinkedList<int[]> result = new LinkedList<>();
        for (int i = 0; i < intervals.length; i++) {
            if (result.isEmpty() || result.getLast()[1] < intervals[i][0]) {
                result.add(intervals[i]);
            } else {
                result.getLast()[1] = Math.max(result.getLast()[1], intervals[i][1]);
            }
        }

        return result.toArray(new int[0][]);
    }

    public int[][] mergeMy(int[][] intervals) {
        TreeMap<Integer, Integer> treeMap = new TreeMap<>();
        if (intervals == null) {
            return intervals;
        }
        int length = intervals.length;
        if (length < 2) {
            return intervals;
        }
        sort(intervals);

        int[] mask = new int[length];

        // 逐条合并，mask记录是否有效0无效（被合并），1有效（返回结果involve）
        for (int i = 0; i < length - 1; i++) {
            int[] now = intervals[i];
            int[] next = intervals[i + 1];
            if (now[1] >= next[0]) {
                int[] temp = new int[2];
                temp[0] = now[0];
                temp[1] = Math.max(now[1], next[1]);
                intervals[i + 1] = temp;
                mask[i] = 0;
                mask[i + 1] = 1;
            } else {
                mask[i] = 1;
                mask[i + 1] = 1;
            }
        }
        int newLength = 0;
        for (int i : mask) {
            if (i == 1) {
                newLength++;
            }
        }
        int[][] result = new int[newLength][2];
        for (int i = 0, j = 0; i < length; i++) {
            if (mask[i] == 1) {
                result[j] = intervals[i];
                j++;
            }
        }

        return result;
    }

    public int[][] sort(int[][] intervals) {
        // 左边界排序
        Arrays.sort(intervals, Comparator.comparingInt(o -> o[0]));
        return intervals;
    }

    public static void main(String[] args) {
        int[][] intervals = {{1, 3}, {2, 6}, {8, 10}, {11, 18}};
        int[][] result = new Merge56().merge(intervals);
        for (int[] ints : result) {
            System.out.print('[');
            for (int anInt : ints) {
                System.out.print(anInt);
                System.out.print(',');
            }
            System.out.println(']');
        }
    }
}
