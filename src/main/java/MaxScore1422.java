/**
 * 1422. 分割字符串的最大得分
 * easy
 *
 * @author avatarannappa
 * @version 1.0, 2022/8/14
 */
public class MaxScore1422 {

    public int maxScore(String s) {
        int n = s.length();
        int[] z = new int[s.length()];
        int[] o = new int[s.length()];
        z[0] = s.charAt(0) == '0' ? 1 : 0;
        o[n - 1] = s.charAt(n - 1) == '1' ? 1 : 0;

        for (int i = 1; i < n - 1; i++) {
            if (s.charAt(i) == '0') {
                z[i] = z[i - 1] + 1;
            } else {
                z[i] = z[i - 1];
            }

            if (s.charAt(n - 1 - i) == '1') {
                o[n - 1 - i] = o[n - 1 - i + 1] + 1;
            } else {
                o[n - 1 - i] = o[n - 1 - i + 1];
            }
        }

        int ans = 0;

        for (int i = 0; i < n - 1; i++) {
            ans = Math.max(ans, z[i] + o[i + 1]);
        }

        return ans;
    }

    public static void main(String[] args) {
        String s = "011101";
        System.out.println(new MaxScore1422().maxScore(s));
    }
}
