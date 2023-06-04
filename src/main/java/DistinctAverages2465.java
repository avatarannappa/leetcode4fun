import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * 2465. 不同的平均值数目
 * easy
 *
 * @author avatarannappa
 * @version 1.0, 2023/6/4
 */
public class DistinctAverages2465 {

    public int distinctAverages(int[] nums) {
        Arrays.sort(nums);
        Set<Double> set = new HashSet<>();
        for (int i = 0, j = nums.length - 1; i < nums.length; i++, j--) {
            double m = (nums[i] + nums[j]) / 2.0;
            set.add(m);
        }
        return set.size();
    }

    public static void main(String[] args) {
        int[] nums = {4, 1, 4, 0, 3, 5};
        // 2
        System.out.println(new DistinctAverages2465().distinctAverages(nums));
    }
}
