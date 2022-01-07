import java.util.Arrays;

/**
 * 825. 适龄的朋友.
 * medium
 *
 * @author avatarannappa
 * @version 1.0
 * @date 2022/1/7
 */
public class NumFriendRequests825 {

    public int numFriendRequests(int[] ages) {
        Arrays.sort(ages);
        int ans = 0;
        int i = 0;
        int j = 0;

        for (int k = 0; k < ages.length; k++) {
            while (i < k && !check(ages[i], ages[k])) {
                i++;
            }
            if (j < k) {
                j = k;
            }
            while (j < ages.length && check(ages[j], ages[k])) {
                j++;
            }
            if (j > i) {
                ans += j - i - 1;
            }
        }
        return ans;
    }

    boolean check(int x, int y) {
        if (y <= 0.5 * x + 7) {
            return false;
        }
        if (y > x) {
            return false;
        }
        if (y > 100 && x < 100) {
            return false;
        }
        return true;
    }

    public int numFriendRequestsOld(int[] ages) {
        // 超时
        // age[y] <= 0.5 * age[x] + 7
        // age[y] > age[x]
        // age[y] > 100 && age[x] < 100
        int ans = 0;

        for (int i = 0; i < ages.length; i++) {
            for (int j = i + 1; j < ages.length; j++) {
                int ii = 1;
                int jj = 1;
                if (ages[i] > ages[j] || ages[i] <= 0.5 * ages[j] + 7 || ages[i] > 100 && ages[j] < 100) {
                    jj = 0;
                }
                if (ages[j] > ages[i] || ages[j] <= 0.5 * ages[i] + 7 || ages[j] > 100 && ages[i] < 100) {
                    ii = 0;
                }
                ans += ii + jj;
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        int[] ages = {20, 30, 100, 110, 120};
        // 3
        System.out.println(new NumFriendRequests825().numFriendRequests(ages));
    }
}
