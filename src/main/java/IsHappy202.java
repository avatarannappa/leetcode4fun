/**
 * 202. 快乐数
 *
 * @author avatarannappa
 * @version 1.0, 2019/11/14
 */
public class IsHappy202 {
    public static void main(String[] args) {
        IsHappy202 isHappy202 = new IsHappy202();
        System.out.println(isHappy202.isHappy(19));
    }

    public boolean isHappy(int n) {
        int slow = n, fast = n;
        do {
            slow = sum(slow);
            fast = sum(fast);
            fast = sum(fast);
        } while (slow != fast);
        return slow == 1;
    }

    public int sum(int n) {
        int sum = 0;
        while (n > 0) {
            int i = n % 10;
            sum += i * i;
            n = n / 10;
        }
        return sum;
    }
}
