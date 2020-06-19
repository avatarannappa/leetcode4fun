/**
 * 415. 字符串相加.
 *
 * @author avatarannappa
 * @version 1.0, 2020/6/19
 */
public class AddStrings415 {

    public String addStrings(String num1, String num2) {
        StringBuilder sb = new StringBuilder();
        int m = num1.length() - 1;
        int n = num2.length() - 1;
        int carry = 0;
        while (m >= 0 || n >= 0) {
            int i = m >= 0 ? num1.charAt(m) - '0' : 0;
            int j = n >= 0 ? num2.charAt(n) - '0' : 0;
            int temp = i + j + carry;
            int bit = temp % 10;
            carry = temp / 10;
            sb.append(bit);

            m--;
            n--;
        }
        if (carry == 1) {
            sb.append(carry);
        }
        return sb.reverse().toString();
    }

    public static void main(String[] args) {
        String num1 = "1212341";
        String num2 = "879";
        System.out.println(new AddStrings415().addStrings(num1, num2));
    }
}
