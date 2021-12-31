/**
 * 686. 重复叠加字符串匹配.
 * medium
 *
 * @author avatarannappa
 * @version 1.0
 * @date 2021/12/31
 */
public class RepeatedStringMatch686 {

    public int repeatedStringMatch(String a, String b) {
        // 上下界
        StringBuilder sb = new StringBuilder();
        int ans = 0;
        while (sb.length() < b.length()) {
            sb.append(a);
            ans++;
        }
        sb.append(a);
        int idx = sb.indexOf(b);
        if (idx == -1) {
            return -1;
        }
        return idx + b.length() > a.length() * ans ? ans + 1 : ans;
    }

    public static void main(String[] args) {
        String a = "abcd";
        String b = "cdabcdab";
        System.out.println(new RepeatedStringMatch686().repeatedStringMatch(a, b));
    }
}
