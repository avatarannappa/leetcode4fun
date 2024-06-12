/**
 * 2806.取整购买后的账户余额
 * easy
 *
 * @author avatarannappa
 * @version 1.0, 2024/6/12
 */
public class AccountBalanceAfterPurchase2806 {

    public int accountBalanceAfterPurchase(int purchaseAmount) {
        int a = purchaseAmount % 10;
        int b = purchaseAmount / 10;
        if (a >= 5) {
            return 100 - (b + 1) * 10;
        } else {
            return 100 - b * 10;
        }
    }

    public static void main(String[] args) {
        int purchaseAmount = 10;
        System.out.println(new AccountBalanceAfterPurchase2806().accountBalanceAfterPurchase(purchaseAmount));
    }
}
