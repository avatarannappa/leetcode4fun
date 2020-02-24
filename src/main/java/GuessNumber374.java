/**
 * 374. 猜数字大小
 *
 * @author avatarannappa
 * @version 1.0, 2020/2/23
 */
public class GuessNumber374 {

    public static int pick = 6;

    public static int guess(int n) {
        int result = pick - n;
        return result > 0 ? 1 : (result < 0 ? -1 : 0);
    }

    public int guessNumber(int n) {
        // 超时
        int result = 0;
        do {
            result = guess(n);
            if (result < 0) {
                n--;
            } else if (result < 0) {
                n++;
            }
        } while (result != 0);
        return n;
    }

    public int guessNumberBinarySearch(int n) {
        int low = 1;
        int high = n;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            int res = guess(mid);
            if (res == 0) {
                return mid;
            } else if (res < 0) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        System.out.println(new GuessNumber374().guessNumber(10));
    }
}
