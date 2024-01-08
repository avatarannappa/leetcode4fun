import java.util.HashMap;
import java.util.Map;

/**
 * 447. 回旋镖的数量
 * medium
 *
 * @author avatarannappa
 * @date 2024/1/8
 */
public class NumberOfBoomerangs447 {

    public int numberOfBoomerangs(int[][] points) {
        int ans = 0;
        for (int i = 0; i < points.length; i++) {
            int[] origin = points[i];
            Map<Integer, Integer> map = new HashMap<>();
            for (int j = 0; j < points.length; j++) {
                if (j == i) {
                    continue;
                }
                int[] point = points[j];
                int distance = (origin[0] - point[0]) * (origin[0] - point[0]) + (origin[1] - point[1]) * (origin[1] - point[1]);
                map.put(distance, map.getOrDefault(distance, 0) + 1);

            }
            for (int count : map.values()) {
                ans += count * (count - 1);
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int[][] points = {{0, 0}, {1, 0}, {2, 0}};
        // 2
        System.out.println(new NumberOfBoomerangs447().numberOfBoomerangs(points));
    }
}
