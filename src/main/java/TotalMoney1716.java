/**
 * 1716. 计算力扣银行的钱.
 * easy
 *
 * @author avatarannappa
 * @version 1.0, 2022/1/9
 */
public class TotalMoney1716 {
    public int totalMoney(int n) {
        int index = 0;
        int ans = 0;
        while (n > 7) {
            n -= 7;
            ans += index * 7 + 28;
            index++;
        }
        ans += n * (n + 1) / 2 + index * n;
        return ans;
    }

    public static void main(String[] args) {
        int n = 10;
        System.out.println(new TotalMoney1716().totalMoney(n));
    }
}
