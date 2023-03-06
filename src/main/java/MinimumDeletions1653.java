/**
 * 1653. 使字符串平衡的最少删除次数
 * medium
 *
 * @author avatarannappa
 * @date 2023/3/6
 */
public class MinimumDeletions1653 {

    public int minimumDeletions(String s) {
        // DP O(n)
        int dp = 0;
        int cntB = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == 'b') {
                cntB++;
            } else {
                dp = Math.min(dp + 1, cntB);
            }
        }
        return dp;
    }

    public static void main(String[] args) {
        String s = "aababbab";
        System.out.println(new MinimumDeletions1653().minimumDeletions(s));
    }
}
