/**
 * 1071. 字符串的最大公因子.
 *
 * @author avatarannappa
 * @version 1.0, 2020/3/12
 */
public class GcdOfStrings1071 {

    public String gcdOfStrings(String str1, String str2) {
        if (!(str1 + str2).equals(str2 + str1)) {
            return "";
        }
        return str1.substring(0, gcd(str1.length(), str2.length()));
    }

    private int gcd(int a, int b) {
        return b == 0 ? a : gcd(b, a % b);
    }

    public static void main(String[] args) {
        String str1 = "ABCABC";
        String str2 = "ABC";
        System.out.println(new GcdOfStrings1071().gcdOfStrings(str1, str2));
    }

}
