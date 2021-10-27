/**
 * 393. UTF-8 编码验证. medium
 *
 * @author avatarannappa
 * @version 1.0, 2021/10/27
 */
public class ValidUtf8I393 {
    public boolean validUtf8(int[] data) {
        int num = 0;
        for (int i = 0; i < data.length; i++) {
            String str = Integer.toBinaryString(data[i]);
            if (num == 0) {
                if (str.length() < 8) {
                    continue;
                } else if (str.startsWith("10")) {
                    return false;
                } else if (str.startsWith("110")) {
                    num = 1;
                } else if (str.startsWith("1110")) {
                    num = 2;
                } else if (str.startsWith("11110")) {
                    num = 3;
                } else {
                    return false;
                }
            } else {
                if (str.length() == 8 && str.startsWith("10")) {
                    num--;
                } else {
                    return false;
                }
            }
        }
        return num == 0;
    }

    public static void main(String[] args) {
        int[] data = { 237 };
        System.out.println(new ValidUtf8I393().validUtf8(data));
    }
}
