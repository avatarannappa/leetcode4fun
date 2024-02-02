/**
 * 1689. 十-二进制数的最少数目
 * medium
 *
 * @author avatarannappa
 * @date 2024/2/2
 */
public class MinPartitions1689 {

    public int minPartitions(String n) {
        // 找每一位上最大数字
        int max = 0;
        for (int i = 0; i < n.length(); i++) {
            char c = n.charAt(i);
            max = Math.max(max, c - '0');
        }
        return max;
    }
}
