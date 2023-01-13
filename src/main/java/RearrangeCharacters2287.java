import java.util.HashMap;
import java.util.Map;

/**
 * 2287. 重排字符形成目标字符串.
 * easy
 *
 * @author avatarannappa
 * @date 2023/1/13
 */
public class RearrangeCharacters2287 {

    public int rearrangeCharacters(String s, String target) {
        // 模拟
        int ans = 101;
        Map<Character, Integer> map = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        Map<Character, Integer> tMap = new HashMap<>();
        for (int i = 0; i < target.length(); i++) {
            char c = target.charAt(i);
            tMap.put(c, tMap.getOrDefault(c, 0) + 1);
        }

        for (Character key : tMap.keySet()) {
            int t = tMap.get(key);
            int o = map.getOrDefault(key, 0);
            int count = o / t;
            ans = Math.min(ans, count);
        }

        return ans;
    }

    public static void main(String[] args) {
        String s = "ilovecodingonleetcode";
        String target = "code";
        // 2
        System.out.println(new RearrangeCharacters2287().rearrangeCharacters(s, target));
    }
}
