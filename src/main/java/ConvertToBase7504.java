/**
 * 504. 七进制数.
 *
 * @author avatarannappa
 * @version 1.0, 2020/10/19
 */
public class ConvertToBase7504 {

    public String convertToBase7(int num) {
        if (num == 0) {
            return "0";
        }
        boolean sign = num > 0;
        if (!sign) {
            num = -num;
        }
        StringBuilder sb = new StringBuilder();
        while (num > 0) {
            int m = num % 7;
            num = num / 7;
            if (m != 0 || num != 0) {
                sb.append(m);
            }
        }
        return sign ? sb.reverse().toString() : "-" + sb.reverse().toString();
    }

    public static void main(String[] args) {
        System.out.println(new ConvertToBase7504().convertToBase7(-7));
    }
}
