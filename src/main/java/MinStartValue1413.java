/**
 * 1413. 逐步求和得到正数的最小值
 * easy
 *
 * @author avatarannappa
 * @version 1.0, 2022/8/9
 */
public class MinStartValue1413 {

    public int minStartValue(int[] nums) {
        int min = Integer.MAX_VALUE;
        int sum = 0;
        for (int num : nums) {
            sum += num;
            min = Math.min(min, sum);
        }
        return min >= 0 ? 1 : -min + 1;
    }
}
