import java.util.Arrays;
import java.util.Comparator;

/**
 * 3075. 幸福值最大化的选择方案.
 * medium
 *
 * @author avatarannappa
 * @version 1.0, 2025/12/25
 */
public class MaximumHappinessSum3075 {

    public long maximumHappinessSum(int[] happiness, int k) {
        long sum = 0;

        Arrays.sort(happiness);
        int j = 0;
        for (int i = happiness.length - 1; i >= 0; i--) {
            if (k-- == 0) {
                return sum;
            }
            int num = happiness[i];
            if (num >= j) {
                num -= j;
                j++;
            } else {
                return sum;
            }
            sum += num;
        }

        return sum;
    }

    public static void main(String[] args) {
        int[] happiness = {2,3,4,5};
        int k = 1;
        // 5
        System.out.println(new MaximumHappinessSum3075().maximumHappinessSum(happiness, k));
    }
}
