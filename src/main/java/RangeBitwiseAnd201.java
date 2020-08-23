/**
 * 201. 数字范围按位与.
 *
 * @author avatarannappa
 * @version 1.0, 2020/08/23
 */
public class RangeBitwiseAnd201 {

    public int rangeBitwiseAnd(int m, int n) {
        while (m < n) {
            // 抹去最右边的 1
            n = n & (n - 1);
        }
        return n;
    }

}
