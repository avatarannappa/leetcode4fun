import java.util.HashMap;
import java.util.Map;

/**
 * 914. 卡牌分组
 *
 * @author avatarannappa
 * @version 1.0, 2020/3/28
 */
public class HasGroupsSizeX914 {

    public boolean hasGroupsSizeX(int[] deck) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i : deck) {
            if (map.containsKey(i)) {
                map.put(i, map.get(i) + 1);
            } else {
                map.put(i, 1);
            }
        }
        if (map.size() == 1) {
            for (Integer value : map.values()) {
                if (value > 1) {
                    return true;
                }
            }
        }
        int t = 0;
        for (Integer value : map.values()) {
            if (t == 0) {
                t = value;
            } else {
                t = gcd(value, t);
            }
            if (t == 1) {
                return false;
            }
        }
        return t > 1;
    }

    public int gcd(int a, int b) {
        return b == 0 ? a : gcd(b, a % b);
    }

    public static void main(String[] args) {
        int[] deck = {1, 2, 3, 4, 4, 3, 2, 1};
        System.out.println(new HasGroupsSizeX914().hasGroupsSizeX(deck));
    }
}
