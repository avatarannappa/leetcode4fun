import java.util.LinkedList;
import java.util.List;

/**
 * 2682. 找出转圈游戏输家
 * easy
 *
 * @author avatarannappa
 * @date 2023/8/16
 */
public class CircularGameLosers2682 {

    public int[] circularGameLosers(int n, int k) {
        // 简单模拟
        int[] arr = new int[n];

        int idx = 0;
        int step = 1;
        while (true) {
            if (arr[idx] == 1) {
                break;
            }
            arr[idx] = 1;
            idx = (idx + step * k) % n;
            step++;
        }

        List<Integer> l = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            if (arr[i] == 0) {
                l.add(i + 1);
            }
        }
        int[] res = new int[l.size()];
        for (int i = 0; i < l.size(); i++) {
            res[i] = l.get(i);
        }
        return res;
    }
}
