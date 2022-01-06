import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * 1705. 吃苹果的最大数目.
 * medium
 *
 * @author avatarannappa
 * @version 1.0
 * @date 2022/1/6
 */
public class EatenApples1705 {

    public int eatenApples(int[] apples, int[] days) {
        int ans = 0;
        PriorityQueue<int[]> queue = new PriorityQueue<>(Comparator.comparingInt(o -> o[0]));
        for (int i = 0; i < 400000000; i++) {
            if (i < apples.length) {
                int apple = apples[i];
                int day = days[i];
                if (apple != 0) {
                    int[] arr = new int[2];
                    arr[0] = day + i;
                    arr[1] = apple;
                    queue.add(arr);
                } 
            }
            
            while (!queue.isEmpty()) {
                int[] first = queue.peek();
                if (first[0] - i > 0) {
                    first[1] -= 1;
                    ans++;
                    if (first[0] - i == 1 || first[1] == 0) {
                        queue.poll();
                    }
                    break;
                } else {
                    queue.poll();
                }
            }
            
            if (queue.isEmpty() && i >= apples.length) {
                break;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] apples = {1, 2, 3, 5, 2};
        int[] days = {3, 2, 1, 4, 2};
        // 7
        System.out.println(new EatenApples1705().eatenApples(apples, days));
    }
}
