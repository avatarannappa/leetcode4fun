/**
 * 481. 神奇字符串
 * medium
 *
 * @author avatarannappa
 * @version 1.0, 2020/11/19
 */
public class MagicalString481 {

    public int magicalString(int n) {
        StringBuilder sb = new StringBuilder("122");
        int i = 3;
        int j = 2;
        while (i < n) {
            int now = sb.charAt(j) - '0';
            char pre = sb.charAt(i - 1);
            for (int t = 0; t < now; t++) {
                if (pre == '1') {
                    sb.append("2");
                } else {
                    sb.append("1");
                }
                i++;
            }
            j++;
        }

        int count = 0;
        String str = sb.toString();
        for (int m = 0; m < n; m++) {
            if (str.charAt(m) == '1') {
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        int n = 21;
        System.out.println(new MagicalString481().magicalString(n));
    }
}
