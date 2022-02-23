/**
 * 917. 仅仅反转字母.
 * easy
 *
 * @author avatarannappa
 * @version 1.0
 * @date 2022/2/23
 */
public class Reverseonlyletters917 {

    public String reverseOnlyLetters(String s) {
        int n = s.length();
        char[] array = new char[n];
        int r = n - 1;
        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);
            if ((c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z')) {
                while (r >= 0 && !((s.charAt(r) >= 'a' && s.charAt(r) <= 'z') || (s.charAt(r) >= 'A'
                    && s.charAt(r) <= 'Z'))) {
                    r--;
                }
                array[r] = c;
                r--;
            } else {
                array[i] = c;
            }
        }
        StringBuilder sb = new StringBuilder();
        for (char c : array) {
            sb.append(c);
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        String s = "a-bC-dEf-ghIj";
        System.out.println(new Reverseonlyletters917().reverseOnlyLetters(s));
    }

}
