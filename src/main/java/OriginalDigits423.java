import java.util.Arrays;

/**
 * 423. 从英文中重建数字.
 * medium
 *
 * @author avatarannappa
 * @version 1.0, 2021/11/30
 */
public class OriginalDigits423 {
    public String originalDigits(String s) {
        // 02687543219 随便搞个唯一序列
        String[] array = { "zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine" };
        int[] priority = new int[] { 0, 8, 6, 3, 2, 7, 5, 9, 4, 1 };
        char[] charArray = new char[] { 'z', 'g', 'x', 'h', 'w', 's', 'v', 'i', 'f', 'o' };
        int n = s.length();
        int[] cnts = new int[26];
        for (int i = 0; i < n; i++) cnts[s.charAt(i) - 'a']++;
        StringBuilder sb = new StringBuilder();
        for (int x = 0; x < priority.length; x++) {
            int i = priority[x];
            int k = cnts[charArray[x] - 'a'];
            if (k > 0) {
                for (char c : array[i].toCharArray()) cnts[c - 'a'] -= k;
                while (k-- > 0) sb.append(i);
            }
        }
        char[] cs = sb.toString().toCharArray();
        Arrays.sort(cs);
        return String.valueOf(cs);
    }

    public static void main(String[] args) {
        String s = "owoztneoer";
        // 012
        System.out.println(new OriginalDigits423().originalDigits(s));
    }
}
