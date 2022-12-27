/**
 * 2027. 转换字符串的最少操作次数
 * easy
 *
 * @author avatarannappa
 * @date 2022/12/27
 */
public class MinimumMoves2027 {

    public int minimumMoves(String s) {
        int count = 0;

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == 'X') {
                count++;
                i += 2;
            }
        }

        return count;
    }

    public static void main(String[] args) {
        String s = "XXOX";
        // 2
        // three consecutive characters 一次移动三个连续的字符
        System.out.println(new MinimumMoves2027().minimumMoves(s));
    }
}
