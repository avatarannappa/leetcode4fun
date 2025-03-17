/**
 * 1963. 使字符串平衡的最小交换次数.
 * medium
 *
 * @author avatarannappa
 * @version 2025/3/17
 */
public class MinSwaps1963 {

    public int minSwaps(String s) {
        // 规律+贪心
        // 规律：从最左遇[ +1 ，遇 ] -1 ，则sum>=0才会是平衡的
        // 贪心：遇到不平衡则最左的]，替换最右的[
        int r = s.length() - 1;
        int sum = 0;
        char[] arr = s.toCharArray();
        int ans = 0;
        for (int l = 0; l < r; l++) {
            char c = arr[l];
            if (c == '[') {
                sum++;
            } else {
                sum--;
            }
            if (sum < 0) {
                // 需要移动
                while (r > l && arr[r] == ']') {
                    r--;
                }
                // 没有真的移动，模拟移动后sum数量、ans数量和r往前左移动一位
                r--;
                ans++;
                sum += 2;
            }
        }
        return ans;
    }

}
