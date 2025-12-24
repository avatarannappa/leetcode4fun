import java.util.Arrays;

/**
 * 3074. 重新分装苹果.
 * easy
 *
 * @author avatarannappa
 * @version 1.0, 2025/12/24
 */
public class MinimumBoxes3074 {
    public int minimumBoxes(int[] apple, int[] capacity) {
        Arrays.sort(capacity);
        long sum = Arrays.stream(apple).sum();
        int res = 0;
        for (int i = capacity.length - 1; i >= 0; i--) {
            if (capacity[i] >= sum) {
                return res + 1;
            }
            res++;
            sum -= capacity[i];
        }
        return -1;
    }

    public static void main(String[] args) {
        MinimumBoxes3074 minimumBoxes3074 = new MinimumBoxes3074();
        int[] apple = new int[]{5,5,5};
        int[] capacity = new int[]{2,4,2,7};
        // 2
        System.out.println(minimumBoxes3074.minimumBoxes(apple, capacity));
    }
}
