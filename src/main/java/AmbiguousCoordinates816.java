import java.util.ArrayList;
import java.util.List;

/**
 * 816. 模糊坐标
 * medium
 *
 * @author avatarannappa
 * @date 2022/11/7
 */
public class AmbiguousCoordinates816 {

    public List<String> ambiguousCoordinates(String s) {
        // 暴力枚举
        int n = s.length() - 2;
        List<String> res = new ArrayList<String>();
        s = s.substring(1, s.length() - 1);
        for (int i = 1; i < n; i++) {
            List<String> lt = subStr(s.substring(0, i));
            if (lt.isEmpty()) {
                continue;
            }
            List<String> rt = subStr(s.substring(i));
            if (rt.isEmpty()) {
                continue;
            }
            for (String j : lt) {
                for (String k : rt) {
                    res.add("(" + j + ", " + k + ")");
                }
            }
        }
        return res;
    }

    private List<String> subStr(String s) {
        List<String> res = new ArrayList<String>();
        if (s.charAt(0) != '0' || "0".equals(s)) {
            res.add(s);
        }
        for (int p = 1; p < s.length(); p++) {
            if ((p != 1 && s.charAt(0) == '0') || s.charAt(s.length() - 1) == '0') {
                break;
            }
            res.add(s.substring(0, p) + "." + s.substring(p));
        }
        return res;
    }

    public static void main(String[] args) {
        String s = "(123)";
        // ["(1, 23)", "(12, 3)", "(1.2, 3)", "(1, 2.3)"]
        System.out.println(new AmbiguousCoordinates816().ambiguousCoordinates(s));
    }
}
