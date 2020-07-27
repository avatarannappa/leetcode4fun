import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * 299. 猜数字游戏.
 *
 * @author avatarannappa
 * @version 1.0, 2020/7/27
 */
public class GetHint299 {

    public String getHint(String secret, String guess) {
        if (secret == null || secret.length() == 0) {
            return secret;
        }
        int A = 0;
        int B = 0;
        Map<Character, Integer> map = new HashMap<>();
        List<Character> list = new LinkedList<>();
        char[] secretArray = secret.toCharArray();
        char[] guessArray = guess.toCharArray();
        for (int i = 0; i < secretArray.length; i++) {
            char g = guessArray[i];
            char s = secretArray[i];
            if (s == g) {
                A++;
            } else {
                map.put(s, map.getOrDefault(s, 0) + 1);
                list.add(g);
            }
        }
        for (Character c : list) {
            if (map.getOrDefault(c, 0) > 0) {
                B++;
                map.put(c, map.get(c) - 1);
            }
        }
        return A + "A" + B + "B";
    }

    public static void main(String[] args) {
        String secret = "1122";
        String guess = "1222";
        System.out.println(new GetHint299().getHint(secret, guess));
    }
}
