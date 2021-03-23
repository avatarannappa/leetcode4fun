import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.TreeMap;

/**
 * 218. 天际线问题
 * hard
 *
 * @author avatarannappa
 * @version 1.0, 2021/3/23
 */
public class GetSkyline218 {

    public List<List<Integer>> getSkyline(int[][] buildings) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[0] != b[0] ? a[0] - b[0] : a[1] - b[1]);
        for (int[] building : buildings) {
            // 左顶点
            pq.offer(new int[] {building[0], -building[2]});
            // 右顶点
            pq.offer(new int[] {building[1], building[2]});
        }

        List<List<Integer>> res = new ArrayList<>();

        TreeMap<Integer, Integer> heights = new TreeMap<>((a, b) -> b - a);
        heights.put(0, 1);
        int left;
        int height = 0;
        while (!pq.isEmpty()) {
            int[] arr = pq.poll();
            if (arr[1] < 0) {
                heights.put(-arr[1], heights.getOrDefault(-arr[1], 0) + 1);
            } else {
                heights.put(arr[1], heights.get(arr[1]) - 1);
                if (heights.get(arr[1]) == 0) {
                    heights.remove(arr[1]);
                }
            }
            int maxHeight = heights.keySet().iterator().next();
            if (maxHeight != height) {
                left = arr[0];
                height = maxHeight;
                res.add(Arrays.asList(left, height));
            }
        }
        return res;
    }

    public static void main(String[] args) {
        //  [[2,10],[3,15],[7,12],[12,0],[15,10],[20,8],[24,0]]
        int[][] buildings = {{2, 9, 10}, {3, 7, 15}, {5, 12, 12}, {15, 20, 10}, {19, 24, 8}};
        System.out.println(new GetSkyline218().getSkyline(buildings));
    }
}
