import java.util.HashMap;
import java.util.Map;

/**
 * 1128. 等价多米诺骨牌对的数量
 * easy
 *
 * @author avatarannappa
 * @version 1.0, 2021/1/26
 * @version 1.1， 2025/5/4
 */
public class NumEquivDominoPairs1128 {

    public int numEquivDominoPairsNew(int[][] dominoes) {
        // 规律 + 组合
        int ans = 0;

        int[] arr = new int[100];
        for (int[] d : dominoes) {
            int key = d[0] < d[1] ? d[0] * 10 + d[1] : d[1] * 10 + d[0];
            ans += arr[key];
            arr[key]++;
        }

        return ans;
    }

    public int numEquivDominoPairs(int[][] dominoes) {
        int res = 0;
        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < dominoes.length; i++) {
            int[] temp = dominoes[i];
            if (temp[0] > temp[1]) {
                int t = temp[0];
                temp[0] = temp[1];
                temp[1] = t;
            }
            String key = "" + temp[0] + temp[1];
            if (map.containsKey(key)) {
                map.put(key, map.get(key) + 1);
            } else {
                map.put(key, 1);
            }
        }

        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            int value = entry.getValue();
            if (value == 2) {
                res++;
            } else if (value > 2) {
                res += C2(value);
            }
        }
        return res;
    }

    public static int C2(int m) {
        return m * (m - 1) / 2;
    }

    public int numEquivDominoPairsOld(int[][] dominoes) {
        // 超时
        int count = 0;
        for (int i = 0; i < dominoes.length; i++) {
            for (int j = i + 1; j < dominoes.length; j++) {
                if ((dominoes[i][0] == dominoes[j][0] && dominoes[i][1] == dominoes[j][1]) ||
                    (dominoes[i][0] == dominoes[j][1] && dominoes[i][1] == dominoes[j][0])) {
                    count++;
                }
            }
        }
        return count;
    }

}
