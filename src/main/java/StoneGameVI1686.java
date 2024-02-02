import java.util.Arrays;

/**
 * 1686. 石子游戏 VI
 * medium
 *
 * @author avatarannappa
 * @date 2024/2/2
 */
public class StoneGameVI1686 {

    public int stoneGameVI(int[] aliceValues, int[] bobValues) {
        // 根据基础的石子游戏
        // 本题a选i则b选不了i，则a[i] + b[i]最大最优转换成基础石子游戏
        int res = 0;
        int[][] temp = new int[aliceValues.length][2];
        for (int i = 0; i < aliceValues.length; i++) {
            temp[i][0] = aliceValues[i] + bobValues[i];
            temp[i][1] = i;
        }

        Arrays.sort(temp, (a, b) -> b[0] - a[0]);
        for (int i = 0; i < temp.length; i++) {
            int index = temp[i][1];
            if (i % 2 == 0) {
                res += aliceValues[index];
            } else {
                res -= bobValues[index];
            }
        }

        return res > 0 ? 1 : res < 0 ? -1 : 0;
    }

    public static void main(String[] args) {
        int[] aliceValues = {9, 8, 3, 8};
        int[] bobValues = {10, 6, 9, 5};
        // 1 
        System.out.println(new StoneGameVI1686().stoneGameVI(aliceValues, bobValues));
    }
}
