/**
 * 371. 两整数之和
 * @author avatarannappa
 * @version 1.0, 2020/2/2
 */
public class GetSum371 {
    public int getSum(int a, int b) {
        while (b != 0) {
            // 进位
            int t = (a & b) << 1;
            // 保存0 + 1 和 1 + 0位
            a = a ^ b;
            b = t;
        }
        return a;
    }
}
