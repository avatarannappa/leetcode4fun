import java.util.HashSet;
import java.util.Set;

/**
 * 822. 翻转卡片游戏
 * medium
 *
 * @author avatarannappa
 * @date 2023/8/2
 */
public class Flipgame822 {

    public int flipgame(int[] fronts, int[] backs) {
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < fronts.length; i++) {
            if (fronts[i] == backs[i]) {
                set.add(fronts[i]);
            }
        }
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < fronts.length; i++) {
            int f = fronts[i];
            int b = backs[i];
            if (!set.contains(f)) {
                min = Math.min(min, f);
            }
            if (!set.contains(b)) {
                min = Math.min(min, b);
            }
        }
        return min == Integer.MAX_VALUE ? 0 : min;
    }

    public static void main(String[] args) {
        int[] fronts = {1, 2, 4, 4, 7};
        int[] backs = {1, 3, 4, 1, 3};
        // 输出：2
        System.out.println(new Flipgame822().flipgame(fronts, backs));
    }
}
