import java.util.Map;
import java.util.TreeMap;

/**
 * 846. 一手顺子.
 * medium
 *
 * @author avatarannappa
 * @version 1.0 2021/12/9
 */
public class IsNStraightHand846 {

    public boolean isNStraightHand(int[] hand, int groupSize) {
        // 同1296. 划分数组为连续数字的集合
        // TreeMap
        if (hand.length % groupSize != 0) {
            return false;
        }
        Map<Integer, Integer> map = new TreeMap<>();
        for (int i : hand) {
            map.put(i, map.getOrDefault(i, 0) + 1);
        }
        for (Map.Entry<Integer, Integer> en : map.entrySet()) {
            int key = en.getKey();
            int val = en.getValue();
            for (int x = 0; x < val; x++) {
                for (int i = 1; i < groupSize; i++) {
                    int nextKey = key + i;
                    int nextVal = map.getOrDefault(nextKey, 0);
                    if (nextVal <= 0) {
                        return false;
                    }
                    map.put(nextKey, nextVal - 1);
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        int[] hand = {1, 2, 3, 1, 2, 3};
        int groupSize = 3;
        System.out.println(new IsNStraightHand846().isNStraightHand(hand, groupSize));
    }
}
