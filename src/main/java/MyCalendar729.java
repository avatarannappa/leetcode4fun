import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/**
 * 729. 我的日程安排表 I
 * medium
 *
 * @author avatarannappa
 * @date 2022/7/5
 */
public class MyCalendar729 {

    Map<Integer, Integer> treeMap = new TreeMap<>();

    public MyCalendar729() {
    }

    List<int[]> list = new ArrayList<>();

    public boolean bookNew(int start, int end) {
        // 暴力O(N^2) 比用map快。。二分、线段树，不想写
        end--;
        for (int[] info : list) {
            int l = info[0], r = info[1];
            if (start > r || end < l) {
                continue;
            }
            return false;
        }
        list.add(new int[]{start, end});
        return true;
    }

    public boolean book(int start, int end) {
        end--;
        for (Integer s : treeMap.keySet()) {
            Integer e = treeMap.get(s);
            if ((start >= s && start <= e) || (end >= s && end <= e) || (start <= s && end >= e)) {
                return false;
            }
        }
        treeMap.put(start, end);
        return true;
    }

    public static void main(String[] args) {
        MyCalendar729 c = new MyCalendar729();
        System.out.println(c.book(37, 50));
        System.out.println(c.book(33, 50));
    }
}
