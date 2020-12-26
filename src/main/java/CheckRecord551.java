/**
 * 551. 学生出勤记录 I.
 * easy.
 *
 * @author avatarannappa
 * @version 1.0, 2020/12/27
 */
public class CheckRecord551 {

    public boolean checkRecord(String s) {
        if (s == null || s.length() == 0) {
            return true;
        }
        int a = 0;
        boolean l = false;
        for (int i = 0; i < s.length(); i++) {
            if ('A' == s.charAt(i)) {
                a++;
            } else if ('L' == s.charAt(i)) {
                int temp = 1;
                int j = i + 1;
                while (j < s.length()) {
                    if ('L' == s.charAt(j)) {
                        temp++;
                    } else {
                        break;
                    }
                    j++;
                }
                i = j - 1;
                if (temp > 2) {
                    l = true;
                }
            } else {
                continue;
            }
        }
        return !(a > 1 || l);
    }

    public static void main(String[] args) {
        String s = "PPALLP";
        System.out.println(new CheckRecord551().checkRecord(s));
    }

}
