/**
 * 3184. 构成整天的下标对数目I.
 * easy
 *
 * @author avatarannappa
 * @version 2024/10/22
 */
public class CountCompleteDayPairs3184 {

    public int countCompleteDayPairs(int[] hours) {
        // 暴力
        int count = 0;
        for (int i = 0; i < hours.length; i++) {
            for (int j = i + 1; j < hours.length; j++) {
                if ((hours[i] + hours[j]) % 24 == 0) {
                    count++;
                }
            }
        }
        return count;
    }

    public static void main(String[] args) {
        int[] hours = {12, 12, 30, 24, 24};
        // 2
        System.out.println(new CountCompleteDayPairs3184().countCompleteDayPairs(hours));
    }

}
