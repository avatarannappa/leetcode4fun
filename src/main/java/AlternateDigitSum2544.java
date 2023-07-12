/**
 * 2544. 交替数字和
 * easy
 *
 * @author avatarannappa
 * @date 2023/7/12
 */
public class AlternateDigitSum2544 {

    public int alternateDigitSum(int n) {
        String s = String.valueOf(n);
        int res = 0;
        boolean alt = true;
        for (int i = 0; i < s.length(); i++) {
            int a = s.charAt(i) - '0';
            if (!alt) {
                a = -a;
            }
            alt = !alt;
            res += a;
        }
        return res;
    }

    public static void main(String[] args) {
        int n = 521;
        // 4
        System.out.println(new AlternateDigitSum2544().alternateDigitSum(n));
    }
}
