/**
 * 剑指 Offer 65. 不用加减乘除做加法
 * easy
 *
 * @author avatarannappa
 * @version 1.0, 2021/4/2
 */
public class AddOffer65 {

    public int add(int a, int b) {
        while (b != 0) {
            // 二进制进位
            int c = (a & b) << 1;
            // 二进制不进位
            a = a ^ b;
            b = c;
        }
        return a;
    }

    public static void main(String[] args) {
        int a = 5;
        int b = 6;
        System.out.println(new AddOffer65().add(a, b));
    }
}
