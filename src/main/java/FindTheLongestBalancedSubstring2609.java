/**
 * 2609. 最长平衡子字符串
 * easy
 *
 * @author avatarannappa
 * @date 2023/11/8
 */
public class FindTheLongestBalancedSubstring2609 {

    public int findTheLongestBalancedSubstring(String s) {
        // 简单模拟
        int max = 0;
        int zeroLen = 0;
        int oneLen = 0;
        int pre = -1;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '0') {
                if (pre == 1) {
                    // 重新计数
                    max = Math.max(max, Math.min(zeroLen, oneLen) * 2);
                    zeroLen = 0;
                    oneLen = 0;
                }
                zeroLen++;
                pre = 0;
            } else {
                if (pre == -1) {
                    continue;
                } else {
                    pre = 1;
                    oneLen++;
                }
            }
        }
        max = Math.max(max, Math.min(zeroLen, oneLen) * 2);
        return max;
    }
}
