import java.util.TreeMap;

/**
 * 3102. 最小化曼哈顿距离
 * hard
 *
 * @author avatarannappa
 * @date 2024/7/9
 */
public class MinimumDistance3102 {

    public int minimumDistance(int[][] points) {
        // 曼哈顿距离转切比雪夫距离
        // Math.max((a1 + b1 - (a2 + b2)), a2 + b2 - (a1 + b1), a1 - b1 - (a2 - b2), a2 - b2 - (a1 - b1))
        TreeMap<Integer, Integer> xMap = new TreeMap<>();
        TreeMap<Integer, Integer> yMap = new TreeMap<>();
        for (int[] point : points) {
            xMap.merge(point[0] + point[1], 1, Integer::sum);
            yMap.merge(point[0] - point[1], 1, Integer::sum);
        }

        int min = Integer.MAX_VALUE;

        for (int[] point : points) {
            int x = point[0] + point[1];
            int y = point[0] - point[1];
            if (xMap.get(x) == 1) {
                xMap.remove(x);
            } else {
                xMap.merge(x, -1, Integer::sum);
            }
            if (yMap.get(y) == 1) {
                yMap.remove(y);
            } else {
                yMap.merge(y, -1, Integer::sum);
            }
            int xMax = xMap.lastKey() - xMap.firstKey();
            int yMax = yMap.lastKey() - yMap.firstKey();
            min = Math.min(min, Math.max(xMax, yMax));

            // 回溯
            xMap.merge(x, 1, Integer::sum);
            yMap.merge(y, 1, Integer::sum);
        }

        return min;
    }

    public static void main(String[] args) {
        int[][] points = {{3, 10}, {5, 15}, {10, 2}, {4, 4}};
        // 输出：12
        System.out.println(new MinimumDistance3102().minimumDistance(points));
    }
}
