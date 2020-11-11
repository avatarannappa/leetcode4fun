/**
 * 264. 丑数 II
 * medium
 *
 * @author avatarannappa
 * @version 1.0, 2020/11/11
 */
public class NthUglyNumber264 {

    public int nthUglyNumber(int n) {
        // 动态规划
        int[] pre = new int[1690];
        pre[0] = 1;
        int i2 = 0;
        int i3 = 0;
        int i5 = 0;
        for (int i = 1; i < 1690; i++) {
            int temp2 = pre[i2] * 2;
            int temp3 = pre[i3] * 3;
            int temp5 = pre[i5] * 5;
            int temp = Math.min(Math.min(temp2, temp3), temp5);
            pre[i] = temp;
            if (temp2 == temp) {
                i2++;
            }
            if (temp3 == temp) {
                i3++;
            }
            if (temp5 == temp) {
                i5++;
            }
        }

        return pre[n - 1];
    }

    public static void main(String[] args) {
        System.out.println(new NthUglyNumber264().nthUglyNumber(1689));
    }
}
