/**
 * 3110. 字符串的分数.
 * easy
 *
 * @author avatarannappa
 * @version 1.0, 2025/3/15
 */
public class ScoreOfString3110 {

    public int scoreOfString(String s) {
        int score = 0;
        for (int i = 0; i < s.length() - 1; i++) {
            score += Math.abs(s.charAt(i) - s.charAt(i + 1));
        }
        return score;
    }

    public static void main(String[] args) {
        // 13
        System.out.println(new ScoreOfString3110().scoreOfString("hello"));
    }
}
