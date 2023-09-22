/**
 * 2591. 将钱分给最多的儿童
 * easy
 *
 * @author avatarannappa
 * @date 2023/9/22
 */
public class DistMoney2591 {

    public int distMoney(int money, int children) {
        if (money < children) {
            return -1;
        }
        if (money < children + 7) {
            return 0;
        }
        int m = money - children;
        int n = m / 7;
        int l = m % 7;
        if (n > children) {
            return children - 1;
        } else if (n == children) {
            if (l == 0) {
                return n;
            } else {
                return children - 1;
            }
        } else if (l == 0) {
            return n;
        } else if (children - 1 == n && l == 3) {
            return n - 1;
        } else {
            return n;
        }
    }

    public static void main(String[] args) {
        int money = 17;
        int children = 2;
        // 2
        System.out.println(new DistMoney2591().distMoney(money, children));
    }
}
