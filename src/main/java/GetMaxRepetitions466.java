import java.util.HashMap;
import java.util.Map;

/**
 * 466. 统计重复个数
 * hard
 *
 * @author avatarannappa
 * @date 2024/1/2
 */
public class GetMaxRepetitions466 {

    public int getMaxRepetitions(String s1, int n1, String s2, int n2) {
        // 规律题，循环节
        // 两种解法，在最后算头 + 尾的时候略有不同，是否后面index重置0
        int s1Cnt = 0;
        int s2Cnt = 0;
        int index = 0;
        Map<Integer, int[]> map = new HashMap<>();
        map.put(0, new int[]{0, 0});
        int[] preLoop;
        int[] inLoop;

        while (true) {
            s1Cnt++;
            for (int i = 0; i < s1.length(); i++) {
                if (s1.charAt(i) == s2.charAt(index)) {
                    index++;
                    if (index == s2.length()) {
                        s2Cnt++;
                        index = 0;
                    }
                }
            }
            // 还没有找到循环节，所有的 s1 就用完了
            if (s1Cnt == n1) {
                return s2Cnt / n2;
            }
            // 出现了之前的 index，表示找到了循环节
            if (map.containsKey(index)) {
                int[] value = map.get(index);
                int s1Pre = value[0];
                int s2Pre = value[1];
                // 前 s1Pre 个 s1 包含了 s2Pre 个 s2
                preLoop = new int[]{s1Pre, s2Pre};
                // 以后的每 (s1Cnt - s1Pre) 个 s1 包含了 (s2Cnt - s2Pre) 个 s2
                inLoop = new int[]{s1Cnt - s1Pre, s2Cnt - s2Pre};
                break;
            } else {
                map.put(index, new int[]{s1Cnt, s2Cnt});
            }
        }
        // 循环节点包含的s2的数量
        int ans = (n1 - preLoop[0]) / inLoop[0] * inLoop[1];
        // 头+尾，暴力匹配
        int rest = preLoop[0] + (n1 - preLoop[0]) % inLoop[0];
        index = 0;
        for (int i = 0; i < rest; ++i) {
            for (int j = 0; j < s1.length(); ++j) {
                char ch = s1.charAt(j);
                if (ch == s2.charAt(index)) {
                    ++index;
                    if (index == s2.length()) {
                        ++ans;
                        index = 0;
                    }
                }
            }
        }
        return ans / n2;
    }

    public int getMaxRepetitionsNew(String s1, int n1, String s2, int n2) {
        int s1Cnt = 0;
        int s2Cnt = 0;
        int index = 0;
        Map<Integer, int[]> map = new HashMap<>();

        int[] preLoop;
        int[] inLoop;

        while (true) {
            s1Cnt++;
            for (int i = 0; i < s1.length(); i++) {
                if (s1.charAt(i) == s2.charAt(index)) {
                    index++;
                    if (index == s2.length()) {
                        s2Cnt++;
                        index = 0;
                    }
                }
            }
            // 还没有找到循环节，所有的 s1 就用完了
            if (s1Cnt == n1) {
                return s2Cnt / n2;
            }
            // 出现了之前的 index，表示找到了循环节
            if (map.containsKey(index)) {
                int[] value = map.get(index);
                int s1Pre = value[0];
                int s2Pre = value[1];
                // 前 s1Pre 个 s1 包含了 s2Pre 个 s2
                preLoop = new int[] { s1Pre, s2Pre };
                // 以后的每 (s1Cnt - s1Pre) 个 s1 包含了 (s2Cnt - s2Pre) 个 s2
                inLoop = new int[] { s1Cnt - s1Pre, s2Cnt - s2Pre };
                break;
            } else {
                map.put(index, new int[] { s1Cnt, s2Cnt });
            }
        }
        // 非循环和循环节点包含的s2的数量
        int ans = preLoop[1] + (n1 - preLoop[0]) / inLoop[0] * inLoop[1];
        // S1 的末尾还剩下一些 s1，暴力匹配
        int rest = (n1 - preLoop[0]) % inLoop[0];

        for (int i = 0; i < rest; ++i) {
            for (int j = 0; j < s1.length(); ++j) {
                char ch = s1.charAt(j);
                if (ch == s2.charAt(index)) {
                    ++index;
                    if (index == s2.length()) {
                        ++ans;
                        index = 0;
                    }
                }
            }
        }
        return ans / n2;
    }

    public static void main(String[] args) {
        String s1 = "baba";
        int n1 = 11;
        String s2 = "baab";
        int n2 = 1;
        // 7
        System.out.println(new GetMaxRepetitions466().getMaxRepetitions(s1, n1, s2, n2));
    }
}
