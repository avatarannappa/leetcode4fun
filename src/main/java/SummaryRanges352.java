import java.util.*;

/**
 * 352. 将数据流变为多个不相交区间
 * hard
 *
 * @author avatarannappa
 * @version 1.0, 2022/8/9
 */
public class SummaryRanges352 {

    public SummaryRanges352() {

    }

    TreeMap<Integer, Integer> map = new TreeMap<>();

    public void addNum(int val) {
        int l = val - 1;
        int r = val + 1;
        // 已经存在的两种情况，map里有 or map值区间里有
        if (map.containsKey(val)) {
            return;
        }
        Integer a = map.lowerKey(val);
        if (a != null && map.get(a) >= val) {
            return;
        }

        // 4种情况，两边合并，合并前面，合并后面，直接插入
        if (map.containsKey(l) && map.containsKey(r)) {
            int start = map.get(l);
            int end = map.get(r);
            map.remove(l);
            map.remove(r);
            map.put(start, end);
            map.put(end, start);
        } else if (map.containsKey(l)) {
            int start = map.get(l);
            map.remove(l);
            map.put(val, start);
            map.put(start, val);
        } else if (map.containsKey(r)) {
            int end = map.get(r);
            map.remove(r);
            map.put(val, end);
            map.put(end, val);
        } else {
            map.put(val, val);
        }
    }

    public int[][] getIntervals() {
        List<int[]> list = new LinkedList<>();
        int index = 0;
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            int start = entry.getKey();
            int end = entry.getValue();
            if (start > end) {
                continue;
            }
            int[] arr = new int[2];
            arr[0] = start;
            arr[1] = end;
            list.add(arr);
        }
        int[][] ans = new int[list.size()][];
        return list.toArray(ans);
    }

    public static void main(String[] args) {
        SummaryRanges352 ob = new SummaryRanges352();
        ob.addNum(1);
        ob.getIntervals();
        ob.addNum(3);
        ob.getIntervals();
        ob.addNum(7);
        ob.getIntervals();
        ob.addNum(2);
        ob.getIntervals();
        ob.addNum(1);
        ob.getIntervals();
        ob.addNum(6);
        ob.getIntervals();
    }

}
