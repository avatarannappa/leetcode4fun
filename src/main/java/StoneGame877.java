import java.util.HashMap;
import java.util.Map;

/**
 * 877. 石子游戏
 * medium
 *
 * @author avatarannappa
 * @version 1.0, 2021/6/21
 */
public class StoneGame877 {

    int half;
    Map<String, Boolean> map = new HashMap<>();

    public boolean stoneGame(int[] piles) {
        for (int pile : piles) {
            half += pile;
        }
        half = half / 2;
        return recursion(0, piles, 0, piles.length - 1);
    }

    public boolean recursion(int sum, int[] piles, int start, int end) {
        if (end - start == 0) {
            if (sum > half) {
                return true;
            } else {
                return false;
            }
        }
        String key = sum + "-" + start + "-" + end;
        if (map.containsKey(key)) {
            return map.get(key);
        }
        if (piles.length % 2 == 0) {
            boolean a = recursion(sum + piles[start], piles, start + 1, end);
            boolean b = recursion(sum + piles[end], piles, start, end - 1);
            map.put(key, a || b);
            return a || b;
        } else {
            boolean a = recursion(sum, piles, start + 1, end);
            boolean b = recursion(sum, piles, start, end - 1);
            return a && b;
        }
    }

    public boolean stoneGameNew(int[] piles) {
        // 数学问题，博弈论，先手必赢
        return true;
    }

    public static void main(String[] args) {
        int[] piles = {6, 7, 5, 10, 8, 9, 8, 9, 1, 2};
        System.out.println(new StoneGame877().stoneGame(piles));
    }

}
