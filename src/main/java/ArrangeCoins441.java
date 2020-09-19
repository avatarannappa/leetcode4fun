/**
 * 441. 排列硬币.
 *
 * @author avatarannappa
 * @version 1.0, 2020/9/20
 */
public class ArrangeCoins441 {

    public int arrangeCoins(int n) {
        // 等差数列，一元二次方程
        return (int) (2 * Math.sqrt(n / 2.0 + 0.0625) - 0.5);
    }

}
