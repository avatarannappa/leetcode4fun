/**
 * 2734. 执行子串操作后的字典序最小字符串
 * medium
 *
 * @author avatarannappa
 * @date 2024/6/27
 */
public class SmallestString2734 {

    public String smallestString(String s) {
        StringBuilder sb = new StringBuilder();
        boolean start = true;
        boolean copy = false;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (copy) {
                sb.append(c);
                continue;
            }
            if (start && c == 'a') {
                sb.append(c);
                continue;
            }
            if (!start && c == 'a') {
                copy = true;
                sb.append(c);
                continue;
            }
            start = false;
            sb.append((char) (c - 1));
        }
        if (start) {
            sb.setCharAt(sb.length() - 1, 'z');
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        String s = "cbabc";
        // 输出："baabc"
        System.out.println(new SmallestString2734().smallestString(s));
    }
}
