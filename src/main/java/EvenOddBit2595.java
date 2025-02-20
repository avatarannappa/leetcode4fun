/**
 * 2595. 奇偶位数.
 * easy
 *
 * @author avatarannappa
 * @version 2025/2/20
 */
public class EvenOddBit2595 {

    public int[] evenOddBit(int n) {
        int[] ans = new int[2];

        int index = 0;
        while (n > 0) {
            int bit = n & 1;
            if (index % 2 == 0) {
                ans[0] += bit;
            } else {
                ans[1] += bit;
            }
            n >>= 1;
            index++;
        }
        return ans;
    }

    public static void main(String[] args) {
        int n = 50;
        // 输出：[1,2]
        System.out.println(new EvenOddBit2595().evenOddBit(n));
    }


}
