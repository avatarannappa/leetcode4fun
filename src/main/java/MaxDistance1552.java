import java.util.Arrays;

/**
 * 1552. 两球之间的磁力
 * medium
 *
 * @author avatarannappa
 * @version 1.0, 2022/8/12
 */
public class MaxDistance1552 {

    public int maxDistance(int[] position, int m) {
        // 类似：401, 1011
        // 二分查找
        Arrays.sort(position);
        int r = position[position.length - 1] - position[0];
        int l = Integer.MAX_VALUE;
        for (int i = 1; i < position.length; i++) {
            l = Math.min(position[i] - position[i - 1], l);
        }
        while (l < r) {
            int mid = l + r >>> 1;
            int temp = split(position, mid);
            if (temp > m) {
                l = mid + 1;
            } else {
                r = mid;
            }
        }
        return l;
    }

    public int split(int[] position, int targetDistance) {
        // 最少两个球
        int bucket = 2;
        int sum = 0;
        for (int i = 1; i < position.length; i++) {
            int dis = position[i] - position[i - 1];
            if (sum + dis > targetDistance) {
                sum = 0;
                bucket++;
                continue;
            }
            sum += dis;
        }
        return bucket;
    }

    public static void main(String[] args) {
        int[] position = {79, 74, 57, 22};
        int m = 4;
        // 5
        System.out.println(new MaxDistance1552().maxDistance(position, m));
    }
}
