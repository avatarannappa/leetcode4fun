/**
 * 2562. 找出数组的串联值
 * easy
 *
 * @author avatarannappa
 * @date 2023/10/12
 */
public class FindTheArrayConcVal2562 {

    public long findTheArrayConcVal(int[] nums) {
        long ans = 0;
        
        int l = 0;
        int r = nums.length - 1;
        while (l <= r) {
            if (l < r) {
                String str = "" + nums[l] + nums[r];
                ans += Long.valueOf(str);
            } else {
                ans += nums[l];
            }
            l++;
            r--;
        }
        
        return ans;
    }

    public static void main(String[] args) {
        int[] nums = {7, 52, 2, 4};
        // 596
        System.out.println(new FindTheArrayConcVal2562().findTheArrayConcVal(nums));
    }
}
