/**
 * 2923. 找到冠军 I
 * easy
 *
 * @author avatarannappa
 * @date 2024/4/12
 */
public class FindChampion2923 {

    public int findChampion(int[][] grid) {
        int n = grid.length;
        int[] wins = new int[n];

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (grid[i][j] == 1) {
                    wins[i]++;
                } else {
                    wins[j]++;
                }
            }
        }

        int max = wins[0];
        int res = 0;
        for (int i = 1; i < n; i++) {
            if (wins[i] > max) {
                res = i;
                max = wins[i];
            }
        }

        return res;
    }

    public static void main(String[] args) {
        int[][] grid = {
            {0, 0, 0},
            {1, 0, 1},
            {1, 0, 0}
        };
        System.out.println(new FindChampion2923().findChampion(grid));
    }
}
