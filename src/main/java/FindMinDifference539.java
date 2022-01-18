import com.google.common.collect.Lists;
import java.util.Arrays;
import java.util.List;

/**
 * 539. 最小时间差.
 * medium
 *
 * @author avatarannappa
 * @version 1.0
 * @date 2022/1/18
 */
public class FindMinDifference539 {

    public int findMinDifference(List<String> timePoints) {
        int[] array = new int[timePoints.size() * 2];
        for (int i = 0; i < timePoints.size(); i++) {
            String[] timeArray = timePoints.get(i).split(":");
            int mins = Integer.parseInt(timeArray[0]) * 60 + Integer.parseInt(timeArray[1]);
            array[i] = mins;
            array[i + timePoints.size()] = mins + 1440;
        }
        Arrays.sort(array);
        int min = 1440;
        for (int i = 1; i < array.length; i++) {
            min = Math.min(min, array[i] - array[i - 1]);
        }
        return min;
    }

    public static void main(String[] args) {
        List<String> timePoints = Lists.newArrayList("00:00", "23:59", "00:00");
        System.out.println(new FindMinDifference539().findMinDifference(timePoints));
    }
}
