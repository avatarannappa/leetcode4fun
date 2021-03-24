/**
 * 482. 密钥格式化
 * easy
 *
 * @author avatarannappa
 * @version 1.0, 2021/3/24
 */
public class LicenseKeyFormatting482 {

    public String licenseKeyFormatting(String S, int K) {
        if (S == null || S.length() == 0 || K < 1) {
            return S;
        }
        StringBuilder sb = new StringBuilder();
        int count = 0;
        for (int i = S.length() - 1; i >= 0; i--) {
            char c = S.charAt(i);
            if (c != '-') {
                if (c >= 'a' && c <= 'z') {
                    c = (char) (c + ('A' - 'a'));
                }
                sb.append(c);
                if ((sb.length() - count) % K == 0) {
                    sb.append('-');
                    count++;
                }
            }
        }
        if (sb.length() != 0 && sb.lastIndexOf("-") == sb.length() - 1) {
            // case '---' 3
            sb.deleteCharAt(sb.length() - 1);
        }
        return sb.reverse().toString();
    }

    public static void main(String[] args) {
        String S = "2-5g-3-J";
        int K = 2;
        System.out.println(new LicenseKeyFormatting482().licenseKeyFormatting(S, K));
    }
}
