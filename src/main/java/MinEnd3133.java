/**
 * 3133. 数组最后一个元素的最小值.
 * medium
 *
 * @author avatarannappa
 * @date 2024/8/22
 */
public class MinEnd3133 {

    public long minEnd(int n, int x) {
        // 位运算
        n--;
        long ans = x;
        int i = 0, j = 0;
        while ((n >> j) > 0) {
            // x 的第 i 个比特值是 0，即「空位」
            if ((ans >> i & 1) == 0) {
                // 空位填入 n 的第 j 个比特值
                ans |= (long) (n >> j & 1) << i;
                j++;
            }
            i++;
        }
        return ans;

    }

    public static void main(String[] args) {
        int n = 2;
        int x = 7;
        // 15
        System.out.println(new MinEnd3133().minEnd(n, x));
    }
}
