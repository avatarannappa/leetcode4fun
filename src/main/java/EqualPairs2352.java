import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * 2352. 相等行列对
 * medium
 *
 * @author avatarannappa
 * @date 2023/6/6
 */
public class EqualPairs2352 {

    public int equalPairs(int[][] grid) {
        int ans = 0;
        Set<int[]> set = new HashSet<>();
        for (int i = 0; i < grid.length; i++) {
            set.add(grid[i]);
        }

        for (int[] ints : set) {
            System.out.println(Arrays.toString(ints));
        }
        for (int i = 0; i < grid.length; i++) {
            int[] temp = new int[grid.length];
            for (int j = 0; j < grid.length; j++) {
                temp[j] = grid[j][i];
            }
            for (int[] ints : set) {
                boolean sign = true;
                for (int k = 0; k < grid.length; k++) {
                    if (ints[k] != temp[k]) {
                        sign = false;
                        break;
                    }
                }
                if (sign) {
                    ans++;
                }
            }
        }
        return ans;
    }

}
