/**
 * 面试题 01.06. 字符串压缩
 *
 * @author avatarannappa
 * @version 1.0, 2020/3/19
 */
public class CompressString0106M {

    public String compressString(String S) {
        if (S == null || S.length() < 1) {
            return S;
        }
        StringBuilder sb = new StringBuilder();
        int count = 1;
        char pre = S.charAt(0);
        for (int i = 1; i < S.length(); i++) {
            char a = S.charAt(i);
            if (a != pre) {
                sb.append(pre);
                sb.append(count);
                count = 1;
            } else {
                count++;
            }
            pre = a;
        }
        sb.append(pre);
        sb.append(count);
        String result = sb.toString();
        return result.length() >= S.length() ? S : result;
    }

    public static void main(String[] args) {
        String s = "aa";
        System.out.println(new CompressString0106M().compressString(s));
    }
}
