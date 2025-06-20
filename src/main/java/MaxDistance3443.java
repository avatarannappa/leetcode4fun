/**
 * 3443. K 次修改后的最大曼哈顿距离.
 * medium
 *
 * @author avatarannappa
 * @version 1.0, 2025/6/20
 */
public class MaxDistance3443 {

    String s;

    public int maxDistance(String s, int k) {
        // 贪心 + 枚举
        this.s = s;
        int ans = 0;
        ans = Math.max(ans, maxDis('W', 'N', k));
        ans = Math.max(ans, maxDis('N', 'E', k));
        ans = Math.max(ans, maxDis('E', 'S', k));
        ans = Math.max(ans, maxDis('S', 'W', k));

        return ans;
    }

    private int maxDis(char a, char b, int k) {
        int ans = 0;
        int step = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == a || c == b) {
                step++;
            } else {
                if (k > 0) {
                    step++;
                    k--;
                } else {
                    step--;
                }
            }
            ans = Math.max(ans, step);
        }
        return ans;
    }

    public static void main(String[] args) {
        String s = "NWSE";
        int k = 1;
        System.out.println(new MaxDistance3443().maxDistance(s, k));
    }
}
