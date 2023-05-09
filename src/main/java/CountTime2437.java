/**
 * 2437. 有效时间的数目
 * easy
 *
 * @author avatarannappa
 * @date 2023/5/9
 */
public class CountTime2437 {

    public int countTime(String time) {
        // 模拟
        char a = time.charAt(0);
        char b = time.charAt(1);
        char c = time.charAt(3);
        char d = time.charAt(4);
        int l = 1;
        int r = 1;
        if (a == '?' && b == '?') {
            l = 24;
        } else if (a == '?') {
            if (b > '3') {
                l = 2;
            } else {
                l = 3;
            }
        } else if (b == '?') {
            if (a == '2') {
                l = 4;
            } else {
                l = 10;
            }
        }

        if (c == '?' && d == '?') {
            r = 60;
        } else if (c == '?') {
            r = 6;
        } else if (d == '?') {
            r = 10;
        }
        return l * r;
    }
}
