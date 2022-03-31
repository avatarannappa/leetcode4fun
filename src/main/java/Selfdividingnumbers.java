import java.util.ArrayList;
import java.util.List;

/**
 * 728. 自除数.
 * easy
 *
 * @author avatarannappa
 * @version 1.0
 * @date 2022/3/31
 */
public class Selfdividingnumbers {

    public List<Integer> selfDividingNumbers(int left, int right) {
        List<Integer> ans = new ArrayList<>();
        for (int i = left; i <= right; i++) {
            if (check(i)) {
                ans.add(i);
            }
        }
        return ans;
    }

    private boolean check(int num) {
        int orginNum = num;
        while (num > 0) {
            int b = num % 10;
            if (b == 0 || orginNum % b != 0) {
                return false;
            }
            num = num / 10;
        }
        return true;
    }

    public static void main(String[] args) {
        int left = 1;
        int right = 22;
        // 1, 2, 3, 4, 5, 6, 7, 8, 9, 11, 12, 15, 22
        System.out.println(new Selfdividingnumbers().selfDividingNumbers(left, right));
    }

}
