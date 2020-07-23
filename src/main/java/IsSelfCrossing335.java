/**
 * 335. 路径交叉.
 *
 * @author avatarannappa
 * @version 1.0, 2020/7/23
 */
public class IsSelfCrossing335 {

    public boolean isSelfCrossing(int[] x) {
        if (x == null || x.length < 4) {
            return false;
        }
        for (int i = 3; i < x.length; i++) {
            if (x[i - 1] <= x[i - 3] && x[i] >= x[i - 2]) {
                return true;
            } else if (i >= 4 && (x[i - 1] == x[i - 3]) && (x[i] + x[i - 4] >= x[i - 2])) {
                return true;
            } else if (i >= 5 && x[i - 2] > x[i - 4] && x[i - 1] < x[i - 3] && x[i - 1] >= x[i - 3] - x[i - 5] &&
                       x[i] + x[i - 4] >= x[i - 2]) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[] x = {1, 1, 2, 2, 1, 1};
        System.out.println(new IsSelfCrossing335().isSelfCrossing(x));
    }
}
