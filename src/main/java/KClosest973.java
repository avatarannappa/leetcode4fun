import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 973. 最接近原点的 K 个点
 * medium
 *
 * @author avatarannappa
 * @version 1.0, 2020/11/10
 */
public class KClosest973 {

    public int[][] kClosest(int[][] points, int K) {
        Map<Integer, Integer> map = new HashMap<>();
        if (K >= points.length) {
            return points;
        }
        for (int i = 0; i < points.length; i++) {
            int[] point = points[i];
            map.put(i, point[0] * point[0] + point[1] * point[1]);
        }
        List<Map.Entry<Integer, Integer>> list = new ArrayList<>(map.entrySet());
        list.sort((Comparator.comparingInt(Map.Entry::getValue)));
        int[][] result = new int[K][2];
        for (int i = 0; i < K; i++) {
            result[i][0] = points[list.get(i).getKey()][0];
            result[i][1] = points[list.get(i).getKey()][1];
        }
        return result;
    }

    public static void main(String[] args) {
        int[][] points = {{3, 3}, {5, -1}, {-2, 4}};
        int K = 2;
        int[][] result = new KClosest973().kClosest(points, K);
        for (int[] r : result) {
            System.out.println(Arrays.toString(r));
        }
    }
}
