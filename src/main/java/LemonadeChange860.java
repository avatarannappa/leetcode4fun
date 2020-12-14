/**
 * 860. 柠檬水找零
 * easy
 *
 * @author avatarannappa
 * @version 1.0, 2020/12/11
 */
public class LemonadeChange860 {

    public boolean lemonadeChange(int[] bills) {
        // 贪心
        int five = 0;
        int ten = 0;
        for (int i = 0; i < bills.length; i++) {
            int bill = bills[i];
            if (20 == bill) {
                if (ten > 0) {
                    ten--;
                    if (five > 0) {
                        five--;
                    } else {
                        return false;
                    }
                } else if (five > 2) {
                    five -= 3;
                } else {
                    return false;
                }
            } else if (10 == bill) {
                if (five > 0) {
                    five--;
                } else {
                    return false;
                }
                ten++;
            } else {
                five++;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        int[] bills = {5, 5, 10, 10, 20};
        System.out.println(new LemonadeChange860().lemonadeChange(bills));
    }
}
