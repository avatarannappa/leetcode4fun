import java.util.Arrays;

/**
 * 72. 编辑距离.
 *
 * @author avatarannappa
 * @version 1.0, 2020/5/3
 */
public class MinDistance72 {

    public int minDistance(String word1, String word2) {
        // DP
        int len1 = word1.length() + 1;
        int len2 = word2.length() + 1;
        int[][] m = new int[len1][len2];
        for (int j = 0; j < len1; j++) {
            m[j][0] = j;
        }
        for (int i = 0; i < len2; i++) {
            m[0][i] = i;
        }

        for (int j = 1; j < len1; j++) {
            for (int i = 1; i < len2; i++) {
                char c1 = word1.charAt(j - 1);
                char c2 = word2.charAt(i - 1);
                if (c1 == c2) {
                    m[j][i] = m[j - 1][i - 1];
                } else {
                    m[j][i] = Math.min(Math.min(m[j - 1][i - 1], m[j - 1][i]), m[j][i - 1]) + 1;
                }
            }
        }
        return m[len1 - 1][len2 - 1];
    }

    public static void main(String[] args) {
        String word1 = "horse";
        String word2 = "ros";
        System.out.println(new MinDistance72().minDistance(word1, word2));
    }
}
