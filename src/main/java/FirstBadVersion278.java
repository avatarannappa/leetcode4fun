/**
 * 278. 第一个错误的版本
 *
 * @author avatarannappa
 * @version 1.0, 2020/3/22
 */
public class FirstBadVersion278 {

    public int firstBadVersion(int n) {
        int l = 1;
        int r = n;
        if (isBadVersion(1)) {
            return 1;
        }

        while (l <= r) {
            int m = l + (r - l) / 2;
            if (isBadVersion(m) && !isBadVersion(m - 1)) {
                return m;
            } else if (isBadVersion(m)) {
                r = m - 1;
            } else {
                l = m + 1;
            }
        }
        return 0;
    }

    boolean isBadVersion(int version) {
        return version >= 2;
    }

    public static void main(String[] args) {
        System.out.println(new FirstBadVersion278().firstBadVersion(2));
    }

}
