/**
 * 495. 提莫攻击
 *
 * @author avatarannappa
 * @version 1.0, 2020/4/20
 */
public class FindPoisonedDuration495 {

    public int findPoisonedDuration(int[] timeSeries, int duration) {
        if (timeSeries == null || timeSeries.length < 1) {
            return 0;
        }
        int count = 0;
        int pre = timeSeries[0];
        for (int t : timeSeries) {
            int realDuration = t - pre;
            if (realDuration > duration) {
                count += duration;
            } else {
                count += realDuration;
            }
            pre = t;
        }
        return count + duration;
    }

    public static void main(String[] args) {
        int[] timeSeries = {1, 4};
        int duration = 2;
        System.out.println(new FindPoisonedDuration495().findPoisonedDuration(timeSeries, duration));
    }
}
