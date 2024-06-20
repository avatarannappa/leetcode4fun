/**
 * 2748. 美丽下标对的数目
 * easy
 *
 * @author avatarannappa
 * @date 2024/6/20
 */
public class CountBeautifulPairs2748 {

    public int countBeautifulPairs(int[] nums) {
        int ans = 0;
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                int a = String.valueOf(nums[i]).charAt(0) - '0';
                int b = nums[j] % 10;
                if (gcd(a, b) == 1) {
                    ans++;
                }
            }
        }
        return ans;
    }

    private int gcd(int a, int b) {
        if (a < b) {
            return gcd(b, a);
        }
        return b == 0 ? a : gcd(b, a % b);
    }

    public static void main(String[] args) {
        int[] nums = {2, 5, 1, 4};
        // 输出：5
        System.out.println(new CountBeautifulPairs2748().countBeautifulPairs(nums));
    }
}
