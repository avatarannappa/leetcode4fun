/**
 * 1154. 一年中的第几天.
 * easy
 *
 * @author avatarannappa
 * @version 1.0
 * @date 2021/12/29
 */
public class DayOfYear1154 {

    static int[] months = { 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };

    public int dayOfYear(String date) {
        String[] arr = date.split("-");
        int year = Integer.parseInt(arr[0]);
        int month = Integer.parseInt(arr[1]);
        int day = Integer.parseInt(arr[2]);
        int[] dic = { 0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };
        int ans = day;
        for (int i = 1; i <= 12; i++) {
            if (month > i) {
                if (i == 2 && (year % 400 == 0 || (year % 4 == 0 && year % 100 != 0))) {
                    ans += 29;
                } else {
                    ans += dic[i];
                }
            } else {
                break;
            }
        }
        return ans;
    }

    public int dayOfYearNew(String date) {
        int ans = 0;

        String[] arr = date.split("-");
        int year = Integer.valueOf(arr[0]);
        int month = Integer.valueOf(arr[1]);
        int day = Integer.valueOf(arr[2]);

        for (int i = 1; i < month; i++) {
            ans += months[i - 1];
            if (i == 2 && ((year % 4 == 0 && year % 100 != 0) || year % 400 == 0))
                ans++;
        }

        return ans + day;
    }

}
