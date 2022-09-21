/**
 * 854. 相似度为 K 的字符串
 * hard
 *
 * @author avatarannappa
 * @date 2022/9/21
 */
public class KSimilarity854 {

    int ans = Integer.MAX_VALUE;
    char[] a1;
    char[] a2;
    int n;

    public int kSimilarity(String s1, String s2) {
        this.a1 = s1.toCharArray();
        this.a2 = s2.toCharArray();
        this.n = s1.length();
        recursion(0, 0);
        return ans;
    }

    private void recursion(int cur, int count) {
        if (cur == n) {
            return;
        }
        if (count >= ans) {
            return;
        }
        boolean same = true;
        for (int i = 0; i < a1.length; i++) {
            if (a1[i] != a2[i]) {
                same = false;
                break;
            }
        }
        if (same) {
            ans = Math.min(ans, count);
            return;
        }

        if (a1[cur] == a2[cur]) {
            recursion(cur + 1, count);
        }
        
        for (int i = cur + 1; i < n; i++) {
            if (a1[cur] == a2[i]) {
                swap(cur, i);
                recursion(cur + 1, count + 1);
                swap(cur, i);
            }
        }
    }

    private void swap(int i, int j) {
        char temp = a2[i];
        a2[i] = a2[j];
        a2[j] = temp;
    }

    public static void main(String[] args) {
        String s1 = "abac";
        String s2 = "baca";
        // 2
        System.out.println(new KSimilarity854().kSimilarity(s1, s2));
    }
}
