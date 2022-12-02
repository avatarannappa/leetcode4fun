/**
 * 1796. 字符串中第二大的数字.
 * easy
 *
 * @author avatarannappa
 * @date 2022/12/3
 */
public class SecondHighest1796 {

    public int secondHighest(String s) {
        int a = -1;
        int b = -1;

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c >= '0' && c <= '9') {
                int num = c - '0';
                if (num > a) {
                    b = a;
                    a = num;
                } else if (num < a && num > b) {
                    b = num;
                }
            }
        }

        return b;
    }

    public static void main(String[] args) {
        String s = "ck077";
        // 2
        System.out.println(new SecondHighest1796().secondHighest(s));
    }
}
