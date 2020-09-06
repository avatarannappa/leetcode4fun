/**
 * 132. 分割回文串 II.
 *
 * @author avatarannappa
 * @version 1.0, 2020/9/7
 */
public class MinCut132 {

    public int minCut(String s) {
        int len = s.length();
        boolean dp[][] = new boolean[len][len];
        int[] minArray = new int[len];
        for (int i = 0; i < len; i++) {
            minArray[i] = i;
            for (int j = 0; j <= i; j++) {
                if (s.charAt(i) == s.charAt(j) && (i - j < 2 || dp[i - 1][j + 1])) {
                    dp[i][j] = true;
                    minArray[i] = j == 0 ? 0 : Math.min(minArray[i], minArray[j - 1] + 1);
                }
            }
        }
        return minArray[len - 1];
    }

    public static void main(String[] args) {
        String s = "ccaacabacb";
        System.out.println(new MinCut132().minCut(s));
    }
}
