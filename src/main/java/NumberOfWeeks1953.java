import java.util.Arrays;

/**
 * 1953. 你可以工作的最大周数
 * medium
 *
 * @author avatarannappa
 * @date 2024/5/16
 */
public class NumberOfWeeks1953 {

    public long numberOfWeeks(int[] milestones) {
        // 贪心
        long sum = 0;
        int n = milestones.length;
        Arrays.sort(milestones);
        for (int i = 0; i < n - 1; i++) {
            sum += milestones[i];
        }
        if (sum >= milestones[n - 1] - 1) {
            return sum + milestones[n - 1];
        } else {
            return sum * 2 + 1;
        }
    }

    public static void main(String[] args) {
        int[] milestones = {1, 2, 3};
        // 6
        System.out.println(new NumberOfWeeks1953().numberOfWeeks(milestones));
    }
}
