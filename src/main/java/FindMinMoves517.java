import java.util.Arrays;

/**
 * 517. 超级洗衣机. hard
 *
 * @author avatarannappa
 * @version 1.0, 2021/10/29
 */
public class FindMinMoves517 {
    public int findMinMoves(int[] machines) {
        int sum = Arrays.stream(machines).sum();
        int len = machines.length;
        if (sum % len != 0) {
            return -1;
        }
        int avg = sum / len;

        int res = -1;
        sum = 0;
        for (int machine : machines) {
            int rev = machine - avg;
            sum += rev;
            res = Math.max(res, Math.max(Math.abs(sum), rev));
        }
        return res;
    }

    public static void main(String[] args) {
        int[] machines = {0,0,15,0,0};
        // 3
        System.out.println(new FindMinMoves517().findMinMoves(machines));
    }
}
