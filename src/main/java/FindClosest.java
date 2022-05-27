/**
 * 试题 17.11. 单词距离.
 * medium
 *
 * @author avatarannappa
 * @version 1.0
 * @date 2022/5/27
 */
public class FindClosest {

    public int findClosest(String[] words, String word1, String word2) {
        int p1 = -1;
        int p2 = -1;
        int res = Integer.MAX_VALUE;
        for (int i = 0; i < words.length; i++) {
            String w = words[i];
            if (w.equals(word1)) {
                p1 = i;
            } else if (w.equals(word2)) {
                p2 = i;
            }
            if (p1 != -1 && p2 != -1) {
                res = Math.min(res, Math.abs(p1 - p2));
            }
        }
        return res;
    }

    public int findClosestOld(String[] words, String word1, String word2) {
        int[] a1 = new int[words.length];
        int[] a2 = new int[words.length];
        int res = Integer.MAX_VALUE;
        for (int i = 0; i < words.length; i++) {
            String w = words[i];
            a1[i] = i == 0 ? -1 : a1[i - 1];
            a2[i] = i == 0 ? -1 : a2[i - 1];
            if (w.equals(word1)) {
                a1[i] = i;
                if (a2[i] > 0) {
                    res = Math.min(res, i - a2[i]);
                }
            } else if (w.equals(word2)) {
                a2[i] = i;
                if (a1[i] > 0) {
                    res = Math.min(res, i - a1[i]);
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        String[] words = {"I", "am", "a", "student", "from", "a", "university", "in", "a", "city"};
        String word1 = "a";
        String word2 = "in";
        System.out.println(new FindClosest().findClosest(words, word1, word2));
    }
}
