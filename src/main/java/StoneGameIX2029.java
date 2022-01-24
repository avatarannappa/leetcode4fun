/**
 * 2029. 石子游戏IX.
 * medium
 *
 * @author avatarannappa
 * @version 1.0
 * @date 2022/1/20
 */
public class StoneGameIX2029 {

    public boolean stoneGameIX(int[] stones) {
        // 博弈论
        int c0 = 0;
        int c1 = 0;
        int c2 = 0;
        for (int stone : stones) {
            int remainder = stone % 3;
            if (remainder == 0) {
                c0++;
            } else if (remainder == 1) {
                c1++;
            } else {
                c2++;
            }
        }
        if (c0 % 2 == 0) {
            return c1 >= 1 && c2 >= 1;
        }
        return c1 - c2 > 2 || c2 - c1 > 2;
    }

    public static void main(String[] args) {
        int[] stones = {5, 1, 2, 4, 3};
        // false
        System.out.println(new StoneGameIX2029().stoneGameIX(stones));
    }
}
