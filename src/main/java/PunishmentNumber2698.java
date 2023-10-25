/**
 * 2698. 求一个整数的惩罚数
 * medium
 *
 * @author avatarannappa
 * @date 2023/10/25
 */
public class PunishmentNumber2698 {

    public int punishmentNumber(int n) {
        // 递归，回溯
        int ans = 0;
        for (int i = 1; i <= n; i++) {
            if (check(i * i, i)) {
                ans += i * i;
            }
        }
        return ans;
    }

    public boolean check(int n, int m) {
        if (n == m) {
            return true;
        }
        int t = 10;
        while (t <= n && n % t <= m) {
            if (check(n / t, m - n % t)) {
                return true;
            }
            t *= 10;
        }
        return false;
    }

    public static void main(String[] args) {
        int n = 37;
        // 1478
        System.out.println(new PunishmentNumber2698().punishmentNumber(n));
    }
}
