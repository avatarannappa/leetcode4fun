import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;

/**
 * 1333. 餐厅过滤器
 * medium
 *
 * @author avatarannappa
 * @date 2023/9/27
 */
public class FilterRestaurants1333 {

    public List<Integer> filterRestaurants(int[][] restaurants, int veganFriendly, int maxPrice, int maxDistance) {
        // 排序
        List<Integer> ans = new LinkedList<>();

        PriorityQueue<int[]> queue = new PriorityQueue<>((o1, o2) -> o2[1] - o1[1] == 0 ? o2[0] - o1[0] : o2[1] - o1[1]);
        for (int[] restaurant : restaurants) {
            if (veganFriendly == 1 && restaurant[2] == 0) {
                continue;
            }
            if (restaurant[3] > maxPrice || restaurant[4] > maxDistance) {
                continue;
            }
            queue.add(restaurant);
        }

        while (!queue.isEmpty()) {
            ans.add(queue.poll()[0]);
        }

        return ans;
    }

    public static void main(String[] args) {
        int[][] restaurants = {{1, 4, 1, 40, 10}, {2, 8, 0, 50, 5}, {3, 8, 1, 30, 4}, {4, 10, 0, 10, 3}, {5, 1, 1, 15, 1}};
        int veganFriendly = 1;
        int maxPrice = 50;
        int maxDistance = 10;
        // 3,1,5
        System.out.println(new FilterRestaurants1333().filterRestaurants(restaurants, veganFriendly, maxPrice, maxDistance));
    }
}
