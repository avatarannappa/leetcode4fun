import java.util.Arrays;

/**
 * 455. 分发饼干
 * easy
 *
 * @author avatarannappa
 * @version 1.0, 2022/10/19
 */
public class FindContentChildren455 {
    public int findContentChildren(int[] g, int[] s) {
        int ans = 0;

        Arrays.sort(g);
        Arrays.sort(s);

        for (int i = 0, j = 0; i < g.length && j < s.length;) {
            if (g[i] <= s[j]) {
                i++;
                j++;
                ans++;
            } else {
                j++;
            }
        }

        return ans;
    }
    
    public static void main(String[] args) {
        // 输入: g = [1,2,3], s = [1,1]
        // 输出: 1
        int[] g = { 10, 9, 8, 7 };
        int[] s = { 5, 6, 7, 8 };
        System.out.println(new FindContentChildren455().findContentChildren(g, s));
    }
}
