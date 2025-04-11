/**
 * 2843. 统计对称整数的数目.
 * easy
 *
 * @author avatarannappa
 * @version 2025/4/11
 */
public class CountSymmetricIntegers2843 {


    public int countSymmetricIntegers(int low, int high) {
        // 模拟
        int result = 0;
        for (int i = low; i <= high; i++) {
            String s = String.valueOf(i);
            int len = s.length();
            if (len % 2 != 0) {
                continue;
            }
            int half = len / 2;
            int a = 0;
            int b = 0;
            int t = i;
            while (t > 0) {
                if (half > 0) {
                    a += t % 10;
                } else {
                    b += t % 10;
                }
                t = t / 10;
                half--;
            }
            if (a == b) {
                result++;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int low = 11;
        int high = 11;
        System.out.println(new CountSymmetricIntegers2843().countSymmetricIntegers(low, high));
    }
}
