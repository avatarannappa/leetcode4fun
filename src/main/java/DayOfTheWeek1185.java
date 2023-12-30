import java.util.Arrays;
import java.util.Stack;

/**
 * 1185. 一周中的第几天
 * easy
 * @author avatarannappa
 * @version 1.0, 2023/12/30
 */
class DayOfTheWeek1185 {
    static String[] weeks = {"Sunday", "Monday", "Tuesday", "Wednesday","Thursday", "Friday", "Saturday"};
    static int[] months = {31,28,31,30,31,30,31,31,30,31,30,31};
    public String dayOfTheWeek(int day, int month, int year) {
        int ans = 4;
        for (int i = 1971; i < year; i++) {
            boolean isLeap = (i % 4 == 0 && i % 100 != 0) || i % 400 == 0;
            ans += isLeap ? 366 : 365;
        }
        for (int i = 1; i < month; i++) {
            ans += months[i-1];
            if (i == 2 && ((year % 4 == 0 && year % 100 != 0) || year % 400 == 0)) ans++;
        }
        ans += day;
        return weeks[ans % 7];
    }
}