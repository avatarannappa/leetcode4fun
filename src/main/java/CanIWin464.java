import java.util.HashMap;
import java.util.Map;

/**
 * 464. 我能赢吗.
 * medium
 *
 * @author avatarannappa
 * @version 1.0, 2022/5/22
 */
public class CanIWin464 {

    Map<Integer, Boolean> memMap = new HashMap<Integer, Boolean>();

    public boolean canIWin(int maxChoosableInteger, int desiredTotal) {
        if (maxChoosableInteger >= desiredTotal) {
            return true;
        }
        if ((maxChoosableInteger + 1) * maxChoosableInteger / 2 < desiredTotal) {
            return false;
        }
        return dfs(maxChoosableInteger, desiredTotal, 0, 0);
    }

    public boolean dfs(int max, int des, int mask, int curTotal) {
        // 记忆+dfs
        if (memMap.containsKey(mask)) {
            return memMap.get(mask);
        }
        for (int i = 0; i < max; i++) {
            // 状态压缩
            if (((mask >> i) & 1) == 1) {
                continue;
            }
            if (i + 1 + curTotal >= des) {
                memMap.put(mask, true);
                return true;
            }
            if (!dfs(max, des, mask | 1 << i, curTotal + i + 1)) {
                memMap.put(mask, true);
                return true;
            }
        }
        memMap.put(mask, false);
        return false;
    }

    public boolean dfsOld(int max, int des, int mask, int curTotal) {
        // 超时 41/57通过
        for (int i = 0; i < max; i++) {
            if (((mask >> i) & 1) == 1) {
                continue;
            }
            if (i + 1 + curTotal >= des) {
                return true;
            }
            if (!dfsOld(max, des, mask | 1 << i, curTotal + i + 1)) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(new CanIWin464().canIWin(10, 11));
    }
}
