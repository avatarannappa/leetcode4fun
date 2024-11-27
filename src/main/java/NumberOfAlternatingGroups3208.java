/**
 * 3208. 交替组 II.
 * medium
 *
 * @author avatarannappa
 * @version 2024/11/27
 */
public class NumberOfAlternatingGroups3208 {

    public int numberOfAlternatingGroups(int[] colors, int k) {
        // 同3206，滑动窗口
        int res = 0;
        int n = colors.length;
        int i = 0;
        int j = 1;
        while (i < n) {
            while (j - i < k) {
                if (colors[j % n] == colors[(j - 1) % n]) {
                    break;
                }
                j++;
            }
            if (j - i == k) {
                res++;
                i++;
            } else {
                i = j;
                j++;
            }
        }
        return res;
    }

}
