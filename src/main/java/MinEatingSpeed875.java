/**
 * 875. 爱吃香蕉的珂珂
 * medium
 *
 * @author avatarannappa
 * @version 1.0, 2022/8/12
 */
public class MinEatingSpeed875 {

    public int minEatingSpeed(int[] piles, int h) {
        // 类似：410, 1011
        // 二分查找定位
        double sum = 0;
        int max = 0;
        for (int pile : piles) {
            max = Math.max(max, pile);
            sum += pile;
        }

        int l = (int) Math.ceil(sum / h);
        int r = max;
        while (l < r) {
            int mid = l + (r - l) / 2;
            int needHour = needHour(piles, mid);
            if (needHour > h) {
                l = mid + 1;
            } else {
                r = mid;
            }
        }
        return l;
    }

    public int needHour(int[] piles, int speed) {
        int hour = 0;
        for (int pile : piles) {
            hour += Math.ceil((double) pile / speed);
        }
        return hour;
    }

    public static void main(String[] args) {
        int[] piles = {3, 6, 7, 11};
        int h = 8;
        System.out.println(new MinEatingSpeed875().minEatingSpeed(piles, h));
    }
}
