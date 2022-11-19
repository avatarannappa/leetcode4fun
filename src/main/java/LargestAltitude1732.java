/**
 * 1732. 找到最高海拔.
 * easy
 *
 * @author avatarannappa
 * @version 1.0, 2022/11/19
 */
public class LargestAltitude1732 {

    public int largestAltitude(int[] gain) {
        int ans = 0;
        int max = 0;
        for (int i : gain) {
            ans += i;
            if (i > 0) {
                max = Math.max(max, ans);
            }
        }
        return max;
    }

    public static void main(String[] args) {
        int[] gain = {-5, 1, 5, 0, -7};
        // 1
        System.out.println(new LargestAltitude1732().largestAltitude(gain));
    }
}
