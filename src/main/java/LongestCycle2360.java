/**
 * 2360. 图中的最长环.
 * hard
 *
 * @author avatarannappa
 * @version 2025/3/30
 */
public class LongestCycle2360 {

    public int longestCycle(int[] edges) {
        // 内向基环树
        int n = edges.length;
        int[] label = new int[n];
        int ans = -1;
        int current = 0;

        for (int i = 0; i < n; i++) {
            if (label[i] != 0) {
                continue;
            }
            int pos = i;
            int start = current;
            while (pos != -1) {
                current++;
                if (label[pos] != 0) {
                    if (label[pos] > start) {
                        ans = Math.max(ans, current - label[pos]);
                    }
                    break;
                }
                label[pos] = current;
                pos = edges[pos];
            }
        }

        return ans;
    }

}
