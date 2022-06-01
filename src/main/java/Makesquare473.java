import java.util.Arrays;

/**
 * 473. 火柴拼正方形.
 * medium
 *
 * @author avatarannappa
 * @version 1.0
 * @date 2022/6/1
 */
public class Makesquare473 {

    public boolean makesquare(int[] matchsticks) {
        if (matchsticks.length < 4) {
            return false;
        }
        int sum = Arrays.stream(matchsticks).sum();
        if (sum % 4 != 0) {
            return false;
        }
        int len = sum / 4;
        Arrays.sort(matchsticks);
        int[] edges = new int[4];
        return backtracking(matchsticks.length - 1, matchsticks, edges, len);
    }

    public boolean backtracking(int index, int[] matchsticks, int[] edges, int len) {
        if (index < 0) {
            return true;
        }
        for (int i = 0; i < edges.length; i++) {
            edges[i] += matchsticks[index];
            if (edges[i] <= len && backtracking(index - 1, matchsticks, edges, len)) {
                return true;
            }
            edges[i] -= matchsticks[index];
        }
        return false;
    }

    public static void main(String[] args) {
        int[] matchsticks = {1, 1, 2, 2, 2};
        System.out.println(new Makesquare473().makesquare(matchsticks));
    }
}
