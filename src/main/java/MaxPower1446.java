/**
 * 1446. 连续字符.
 * easy
 *
 * @author avatarannappa
 * @version 1.0 2021/12/21
 */
public class MaxPower1446 {
    public int maxPower(String s) {
        int max = 0;
        
        int count = 1;
        char pre = s.charAt(0);
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == pre) {
                count++;
                max = Math.max(max, count);
            } else {
                pre = s.charAt(i);
                count = 1;
            }
        }

        return max;
    }

    public static void main(String[] args) {
        String s = "abbcccddddeeeeedcba";
        // 5
        System.out.println(new MaxPower1446().maxPower(s));
    }
}
