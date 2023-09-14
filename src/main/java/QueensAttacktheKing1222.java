import java.util.LinkedList;
import java.util.List;

/**
 * 1222. 可以攻击国王的皇后
 * medium
 *
 * @author avatarannappa
 * @date 2023/9/14
 */
public class QueensAttacktheKing1222 {


    public List<List<Integer>> queensAttacktheKing(int[][] queens, int[] king) {
        // 模拟，king能看到的queue
        int[][] steps = {{0, 1}, {1, 1}, {1, 0}, {1, -1}, {0, -1}, {-1, -1}, {-1, 0}, {-1, 1}};

        List<List<Integer>> ans = new LinkedList<>();
        boolean[][] mask = new boolean[8][8];
        for (int[] queen : queens) {
            mask[queen[0]][queen[1]] = true;
        }
        for (int[] step : steps) {
            int x = king[0];
            int y = king[1];
            while (x >= 0 && x < 8 && y >= 0 && y < 8) {
                if (mask[x][y]) {
                    List<Integer> l = new LinkedList<>();
                    l.add(x);
                    l.add(y);
                    ans.add(l);
                    break;
                }
                x += step[0];
                y += step[1];
            }
        }

        return ans;
    }

}
