import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/**
 * 452. 用最少数量的箭引爆气球
 * medium
 *
 * @author avatarannappa
 * @version 1.0, 2020/11/23
 */
public class FindMinArrowShots452 {

    public int findMinArrowShots(int[][] points) {
        if (points == null || points.length < 1) {
            return 0;
        }
        Map<Integer, List<int[]>> treeMap = new TreeMap<>();
        for (int[] point : points) {
            List<int[]> list = treeMap.getOrDefault(point[0], new ArrayList<>());
            list.add(point);
            treeMap.put(point[0], list);
        }

        List<int[]> list = new LinkedList<>();
        for (List<int[]> value : treeMap.values()) {
            list.addAll(value);
        }

        int arrow = 0;
        int size = list.size();
        for (int i = 0; i < size; i++) {
            arrow++;
            int maxStart = list.get(i)[0];
            int minEnd = list.get(i)[1];
            while (++i < size) {
                maxStart = Math.max(maxStart, list.get(i)[0]);
                minEnd = Math.min(minEnd, list.get(i)[1]);
                if (maxStart > minEnd) {
                    i--;
                    break;
                }
            }
        }

        return arrow;
    }

    public static void main(String[] args) {
        // int[][] points = {{10, 16}, {2, 8}, {1, 6}, {7, 12}};
        int[][] points = {{1, 2}, {4, 5}, {1, 5}};
        System.out.println(new FindMinArrowShots452().findMinArrowShots(points));

        int a = 0;
        int b = 0;
        for (int i = 0; i < 99; i++) {
            a = a++;
            b = ++b;
        }
        System.out.println(a);
        System.out.println(b);

        Integer c = 0;
        int d = 0;
        for (int i = 0; i < 99; i++) {
            c = c++;
            d = c++;
        }
        System.out.println(c);
        System.out.println(d);
    }

}
