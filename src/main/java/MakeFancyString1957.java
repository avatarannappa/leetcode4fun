/**
 * 1957. 删除字符使字符串变好
 * easy
 *
 * @author avatarannappa
 * @version 1.0, 2022/10/21
 */
public class MakeFancyString1957 {

    public String makeFancyString(String s) {
        StringBuilder sb = new StringBuilder();
        if (s.length() < 3) {
            return s;
        }
        sb.append(s.charAt(0));
        sb.append(s.charAt(1));
        for (int a = 0, b = 1, i = 2; i < s.length(); i++, a++, b++) {
            if (s.charAt(i) == s.charAt(b) && s.charAt(i) == s.charAt(a)) {
                continue;
            }
            sb.append(s.charAt(i));
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        String s = "aaabaaaa";
        // aabaa
        System.out.println(new MakeFancyString1957().makeFancyString(s));
    }
}
