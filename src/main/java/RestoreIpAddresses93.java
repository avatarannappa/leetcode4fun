import java.util.ArrayList;
import java.util.List;

/**
 * 93. 复原IP地址.
 *
 * @author avatarannappa
 * @version 1.0, 2020/8/19
 */
public class RestoreIpAddresses93 {

    public List<String> restoreIpAddresses(String s) {
        List<String> result = new ArrayList<>();
        if (s == null || s.length() < 4) {
            return result;
        }

        int len = s.length();
        String ip = "";
        for (int i = 1; i < 4; i++) {
            for (int j = 1; j < 4; j++) {
                for (int k = 1; k < 4; k++) {
                    for (int m = 1; m < 4; m++) {
                        if (i + j + k + m == len) {
                            int n1 = Integer.parseInt(s.substring(0, i));
                            int n2 = Integer.parseInt(s.substring(i, i + j));
                            int n3 = Integer.parseInt(s.substring(i + j, i + j + k));
                            int n4 = Integer.parseInt(s.substring(i + j + k, len));
                            if (n1 <= 255 && n2 <= 255 && n3 <= 255 && n4 <= 255) {
                                ip = n1 + "." + n2 + "." + n3 + "." + n4;
                            }
                            if (ip.length() == s.length() + 3) {
                                result.add(ip);

                            }
                        }
                    }
                }
            }
        }

        return result;
    }

    public static void main(String[] args) {
        String s = "25525511135";
        System.out.println(new RestoreIpAddresses93().restoreIpAddresses(s));
    }
}
