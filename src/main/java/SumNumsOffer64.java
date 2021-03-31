/**
 * 剑指 Offer 64. 求1+2+…+n
 * medium
 *
 * @author avatarannappa
 * @version 1.0, 2021/3/31
 */
public class SumNumsOffer64 {

    public int sumNums(int n) {
        // 等差数列求和
        return n * (n + 1) / 2;
    }
}
