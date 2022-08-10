/**
 * 1417. 重新格式化字符串
 * easy
 *
 * @author avatarannappa
 * @version 1.0, 2022/8/11
 */
public class Reformat1417 {

    public String reformat(String s) {
        StringBuilder sb1 = new StringBuilder();
        StringBuilder sb2 = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c >= 'a' && c <= 'z') {
                sb1.append(c);
            } else if (c >= '0' && c <= '9') {
                sb2.append(c);
            }
        }
        if (Math.abs(sb1.length() - sb2.length()) > 1) {
            return "";
        }
        StringBuilder ans = new StringBuilder();
        if (sb1.length() < sb2.length()) {
            StringBuilder temp = sb1;
            sb1 = sb2;
            sb2 = temp;
        }
        for (int i = 0; i < s.length(); i++) {
            if (i % 2 == 0) {
                ans.append(sb1.charAt(i / 2));
            } else {
                ans.append(sb2.charAt(i / 2));
            }
        }
        return ans.toString();
    }

    public static void main(String[] args) {
        String s = "covid2019";
        System.out.println(new Reformat1417().reformat(s));
    }
}
