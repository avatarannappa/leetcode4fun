/**
 * 3206. 交替组 I.
 * easy
 *
 * @author avatarannappa
 * @version 2024/11/26
 */
public class NumberOfAlternatingGroups3206 {

    public int numberOfAlternatingGroups(int[] colors) {
        // 简单模拟，注意环
        int res = 0;
        int n = colors.length;
        for (int i = 0; i < n; i++) {
            if ((colors[i] != colors[(i - 1 + n) % n]) && (colors[i] != colors[(i + 1) % n])) {
                res++;
            }
        }
        return res;
    }

}
