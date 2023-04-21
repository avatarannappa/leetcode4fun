/**
 * 2413. 最小偶倍数
 * easy
 *
 * @author avatarannappa
 * @date 2023/4/21
 */
public class SmallestEvenMultiple2413 {

    public int smallestEvenMultiple(int n) {
        return n % 2 == 0 ? n : n * 2;
    }
}
