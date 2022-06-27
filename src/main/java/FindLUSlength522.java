/**
 * 522. 最长特殊序列 II
 * medium
 *
 * @author chenhao138
 * @date 2022/6/27
 */
public class FindLUSlength522 {

    public int findLUSlength(String[] strs) {
        int max = -1;

        for (int i = 0; i < strs.length; i++) {
            boolean sign = false;
            for (int j = 0; j < strs.length; j++) {
                if (i == j) {
                    continue;
                }
                if (check(strs[i], strs[j])) {
                    sign = true;
                    break;
                }
            }
            if (!sign) {
                max = Math.max(strs[i].length(), max);
            }
        }

        return max;
    }

    private boolean check(String origin, String target) {
        int i = 0;
        int j = 0;

        while (i < origin.length() && j < target.length()) {
            if (origin.charAt(i) == target.charAt(j)) {
                i++;
                j++;
            } else {
                j++;
            }
        }
        return i == origin.length();
    }

    public static void main(String[] args) {
        String[] strs = {"aaa", "a", "aa"};
        // 3
        System.out.println(new FindLUSlength522().findLUSlength(strs));
    }
}
