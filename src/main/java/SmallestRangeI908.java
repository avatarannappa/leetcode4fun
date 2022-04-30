/**
 * 908. 最小差值 I.
 * easy
 *
 * @author avatarannappa
 * @version 1.0, 2022/4/30
 */
public class SmallestRangeI908 {
    public int smallestRangeI(int[] nums, int k) {
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        for (int num : nums) {
            max = Math.max(max, num);
            min = Math.min(min, num);
        }
        return Math.max(0, max - min - 2 * k);
    }

    public static void main(String[] args) {
        SmallestRangeI908 smallestRangeI908 = new SmallestRangeI908();
        // 6
        System.out.println(smallestRangeI908.smallestRangeI(new int[]{0, 10}, 2));
    }
}
