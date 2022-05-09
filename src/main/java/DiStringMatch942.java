import java.util.Arrays;

/**
 * 942. 增减字符串匹配.
 * easy
 *
 * @author avatarannappa
 * @version 1.0
 * @date 2022/5/9
 */
public class DiStringMatch942 {

    public int[] diStringMatch(String s) {
        int[] res = new int[s.length() + 1];
        int left = 0;
        int right = s.length();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == 'I') {
                res[i] = left;
                left++;
            } else {
                res[i] = right;
                right--;
            }
        }
        res[s.length()] = left;

        return res;
    }

    public static void main(String[] args) {
        DiStringMatch942 diStringMatch942 = new DiStringMatch942();
        System.out.println(Arrays.toString(diStringMatch942.diStringMatch("IDID")));
    }
}
