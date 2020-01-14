/**
 * 67. 二进制求和
 *
 * @author avatarannappa
 * @version 1.0, 2019/11/10
 */
public class AddBinary67 {
    public String addBinary(String a, String b) {
        String result = "";
        int length = Math.max(a.length(), b.length());
        int flag = 0;
        int al = a.length();
        int bl = b.length();
        if (al < bl) {
            for (int i = 0; i < (bl - al); i++) {
                a = '0' + a;
            }
        } else if (al > bl) {
            for (int i = 0; i < (al - bl); i++) {
                b = '0' + b;
            }
        }

        for (int i = length - 1; i >= 0; i--) {
            int x = a.charAt(i) - '0';
            int y = b.charAt(i) - '0';
            int count = x + y + flag;
            flag = count / 2;
            // 余数
            int remainder = count % 2;
            result = remainder + result;
        }

        if (flag == 1) {
            result = 1 + result;
        }
        return result;
    }

    public static void main(String[] args) {
        AddBinary67 addBinary67 = new AddBinary67();
        String a = "1010";
        String b = "1011";
        String s = addBinary67.addBinary(a, b);
        System.out.println(s);
        System.out.println('1' - '0');
    }
}
