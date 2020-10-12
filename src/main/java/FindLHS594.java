/**
 * 594. 最长和谐子序列.
 *
 * @author avatarannappa
 * @version 1.0, 2020/10/12
 */
public class FindLHS594 {

    public int findLHS(int[] nums) {
        if (nums == null || nums.length < 2) {
            return 0;
        }
        int max = 0;
        boolean sign = false;
        for (int i = 0; i < nums.length; i++) {
            if (nums.length - i <= max) {
                break;
            }
            int tempMinCount = 0;
            int tempMaxCount = 0;
            int equalCount = 0;
            for (int j = i; j < nums.length; j++) {
                if (nums[i] == nums[j]) {
                    equalCount++;
                } else if (nums[i] - nums[j] == 1) {
                    tempMinCount++;
                } else if (nums[i] - nums[j] == -1) {
                    tempMaxCount++;
                }
            }
            sign = tempMaxCount != 0 || tempMinCount != 0;
            if (sign) {
                max = Math.max(Math.max(tempMinCount + equalCount, tempMaxCount + equalCount), max);
            }
        }
        return max;
    }

    public static void main(String[] args) {
        int[] nums = {1,1,1,1};
        System.out.println(new FindLHS594().findLHS(nums));
    }

}
