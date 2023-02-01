import java.util.HashMap;
import java.util.Map;

/**
 * 2325. 解密消息
 * easy
 *
 * @author avatarannappa
 * @date 2023/2/1
 */
public class DecodeMessage2325 {

    public String decodeMessage(String key, String message) {
        Map<Character, Character> map = new HashMap<>();
        int index = 0;
        for (int i = 0; i < key.length(); i++) {
            char c = key.charAt(i);
            if (c >= 'a' && c <= 'z' && !map.containsKey(c)) {
                map.put(c, (char) ('a' + index++));
            }
        }

        String ans = "";
        for (int i = 0; i < message.length(); i++) {
            if (message.charAt(i) == ' ') {
                ans += ' ';
            } else {
                ans += map.get(message.charAt(i));
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        String key = "the quick brown fox jumps over the lazy dog";
        String message = "vkbs bs t suepuv";
        //输出："this is a secret"
        System.out.println(new DecodeMessage2325().decodeMessage(key, message));
    }
}
