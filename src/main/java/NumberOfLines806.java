import java.util.Arrays;

/**
 * 806. 写字符串需要的行数.
 * easy
 *
 * @author avatarannappa
 * @version 1.0
 * @date 2022/4/12
 */
public class NumberOfLines806 {

    public int[] numberOfLines(int[] widths, String s) {
        int lines = 1;
        int cur = 0;
        for (int i = 0; i < s.length(); i++) {
            int width = widths[s.charAt(i) - 'a'];
            if (cur + width > 100) {
                lines++;
                cur = width;
            } else {
                cur += width;
            }
        }
        return new int[]{lines, cur};
    }

    public static void main(String[] args) {
        NumberOfLines806 numberOfLines806 = new NumberOfLines806();
        int[] widths = {10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10};
        String s = "abcdefghijklmnopqrstuvwxyz";
        int[] result = numberOfLines806.numberOfLines(widths, s);
        System.out.println(Arrays.toString(result));
    }

}
