/**
 * 2446. 判断两个事件是否存在冲突
 * easy
 *
 * @author avatarannapp
 * @date 2023/5/17
 */
public class HaveConflict2446 {

    public boolean haveConflict(String[] event1, String[] event2) {
        int a = parse(event1[0]);
        int b = parse(event1[1]);
        int c = parse(event2[0]);
        int d = parse(event2[1]);
        if ((c >= a && c <= b) || (d >= a && d <= b)) {
            return true;
        } else if (c < a && d > b) {
            return true;
        }
        return false;
    }

    private Integer parse(String time) {
        String[] arr = time.split(":");
        return Integer.valueOf(arr[0]) * 60 + Integer.valueOf(arr[1]);
    }
}
