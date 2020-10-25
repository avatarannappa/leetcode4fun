/**
 * 405. 数字转换为十六进制数.
 * easy
 *
 * @author avatarannappa
 * @version 1.0, 2020/10/25
 */
public class ToHex405 {

    public String toHex(int num) {
        if (num == 0) {
            return "0";
        }
        char[] array = "0123456789abcdef".toCharArray();
        StringBuilder sb = new StringBuilder();
        while (num != 0) {
            int temp = num & 0xf;
            sb.append(array[temp]);
            num = num >>> 4;
        }
        return sb.reverse().toString();
    }

    public static void main(String[] args) {
        int num = -1;
        System.out.println(new ToHex405().toHex(num));
    }

}
