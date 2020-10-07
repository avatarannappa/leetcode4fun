import java.util.Arrays;

/**
 * 475. 供暖器.
 *
 * @author avatarannappa
 * @version 1.0, 2020/10/7
 */
public class FindRadius475 {

    public int findRadius(int[] houses, int[] heaters) {
        Arrays.sort(houses);
        Arrays.sort(heaters);
        int result = 0;
        int heaterIndex = 0;
        for (int i = 0; i < houses.length; i++) {
            while (heaters[heaterIndex] < houses[i] && heaterIndex < heaters.length - 1) {
                heaterIndex++;
            }
            if (heaterIndex == 0) {
                result = Math.max(result, Math.abs(heaters[heaterIndex] - houses[i]));
            } else {
                result = Math.max(result, Math.min(Math.abs(houses[i] - heaters[heaterIndex - 1]),
                                                   Math.abs(heaters[heaterIndex] - houses[i])));
            }
        }

        return result;
    }

    public static void main(String[] args) {
        int[] houses = {1, 5};
        int[] heaters = {2};
        System.out.println(new FindRadius475().findRadius(houses, heaters));
    }
}
