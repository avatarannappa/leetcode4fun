import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * 2347. 最好的扑克手牌
 * easy
 *
 * @author avatarannappa
 * @date 2023/2/20
 */
public class BestHand2347 {

    public String bestHand(int[] ranks, char[] suits) {
        int n = ranks.length;
        Map<Integer, Integer> rankMap = new HashMap<>();
        Set<Character> suitSet = new HashSet<>();
        int sign = 0;
        for (int i = 0; i < n; i++) {
            int r = rankMap.getOrDefault(ranks[i], 0);
            r++;
            if (sign < 3 && r == 3) {
                sign = 3;
            }
            if (sign < 2 && r == 2) {
                sign = 2;
            }
            rankMap.put(ranks[i], r);
            suitSet.add(suits[i]);
        }
        if (suitSet.size() == 1) {
            return "Flush";
        } else if (sign == 3) {
            return "Three of a Kind";
        } else if (sign == 2) {
            return "Pair";
        } else {
            return "High Card";
        }
    }

    public static void main(String[] args) {
        int[] ranks = {2, 10, 7, 10, 7};
        char[] suits = {'a', 'b', 'c', 'd', 'a'};
        // Pair
        // "Flush"：同花，五张相同花色的扑克牌。
        // "Three of a Kind"：三条，有 3 张大小相同的扑克牌。
        // "Pair"：对子，两张大小一样的扑克牌。
        // "High Card"：高牌，五张大小互不相同的扑克牌。
        System.out.println(new BestHand2347().bestHand(ranks, suits));
    }
}
