import java.util.HashMap;
import java.util.Map;

/**
 * 771. 宝石与石头.
 * easy.
 *
 * @author avatarannappa
 * @version 1.0, 2020/10/17
 */
public class NumJewelsInStones771 {

    public int numJewelsInStones(String J, String S) {
        if (J == null || S == null || J.length() == 0 || S.length() == 0) {
            return 0;
        }
        int result = 0;

        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < S.length(); i++) {
            char c = S.charAt(i);
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        for (int i = 0; i < J.length(); i++) {
            char c = J.charAt(i);
            result += map.getOrDefault(c, 0);
        }

        return result;
    }

    public static void main(String[] args) {
        String J = "aA";
        String S = "aAAbbbb";
        System.out.println(new NumJewelsInStones771().numJewelsInStones(J, S));
    }
}
