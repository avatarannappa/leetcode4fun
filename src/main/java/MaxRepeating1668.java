/**
 * 1668. 最大重复子字符串
 * easy
 *
 * @author avatarannappa
 * @date 2022/11/3
 */
public class MaxRepeating1668 {

    public int maxRepeating(String sequence, String word) {
        // 简单模拟
        // TODO 序列DP？
        int max = 0;

        int temp = 0;

        for (int i = 0; i < sequence.length(); i++) {
            int j = 0;
            for (; j < word.length(); j++) {
                if (i + j == sequence.length()) {
                    break;
                }
                if (sequence.charAt(i + j) != word.charAt(j)) {
                    break;
                }
            }
            if (j == word.length()) {
                temp++;
                max = Math.max(temp, max);
                i += word.length() - 1;
            } else {
                if (temp > 0) {
                    i -= word.length() - 1;
                }
                temp = 0;
            }
        }

        return max;
    }

    public static void main(String[] args) {
        // 输入：sequence = "ababc", word = "ab"
        // 输出：2
        String sequence = "aaabaaaabaaabaaaabaaaabaaaabaaaaba";
        String word = "aaaba";
        // 5
        System.out.println(new MaxRepeating1668().maxRepeating(sequence, word));
    }
}
