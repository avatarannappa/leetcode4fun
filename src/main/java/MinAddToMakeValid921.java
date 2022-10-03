/**
 * 921. 使括号有效的最小添加
 * medium
 *
 * @author avatarannappa
 * @version 1.0, 2022/10/4
 */
public class MinAddToMakeValid921 {

    public int minAddToMakeValid(String s) {
        int n = s.length();
        int l = 0;
        int sum = 0;
        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == '(') {
                l++;
            } else {
                if (l > 0) {
                    l--;
                    sum += 2;
                }
            }
        }
        return n - sum;
    }

    public static void main(String[] args) {
        String s = "()))((";
        // 4
        System.out.println(new MinAddToMakeValid921().minAddToMakeValid(s));
    }
}
