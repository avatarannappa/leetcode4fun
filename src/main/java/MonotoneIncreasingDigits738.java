/**
 * 738. 单调递增的数字
 * medium
 *
 * @author avatarannappa
 * @version 1.0, 2020/12/15
 */
public class MonotoneIncreasingDigits738 {

    public int monotoneIncreasingDigits(int N) {
        // 贪心
        int result = 0;
        int pre = 10;
        int index = 1;
        while (N > 0) {
            int now = N % 10;
            if (now > pre) {
                N--;
                now = N % 10;
                result = now * index + index - 1;
            } else {
                result = now * index + result;
            }
            N = N / 10;
            pre = now;
            index = index * 10;
        }
        return result;
    }

    public int monotoneIncreasingDigitsOld(int N) {
        // 747131058 超时
        for (int n = N; n > 0; n--) {
            if (isIncreasing(n)) {
                return n;
            }
        }
        return 0;
    }

    public boolean isIncreasing(int N) {
        if (N < 10) {
            return true;
        }
        int pre = 10;
        while (N > 0) {
            int temp = N % 10;
            if (temp > pre) {
                return false;
            }
            pre = temp;
            N = N / 10;
        }
        return true;
    }

    public static void main(String[] args) {
        int N = 1201;
        System.out.println(new MonotoneIncreasingDigits738().monotoneIncreasingDigits(N));
    }
}
