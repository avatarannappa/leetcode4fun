import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 2225. 找出输掉零场或一场比赛的玩家
 * medium
 *
 * @author avatarannappa
 * @date 2024/5/22
 */
public class FindWinners2225 {

    public List<List<Integer>> findWinners(int[][] matches) {
        // 哈希表
        List<List<Integer>> res = new ArrayList<>();

        Map<Integer, Integer> loseCountMap = new HashMap<>();
        for (int[] match : matches) {
            int win = match[0];
            int lose = match[1];
            loseCountMap.put(win, loseCountMap.getOrDefault(win, 0));
            loseCountMap.put(lose, loseCountMap.getOrDefault(lose, 0) + 1);
        }

        List<Integer> first = new ArrayList<>();
        List<Integer> second = new ArrayList<>();
        for (Map.Entry<Integer, Integer> entry : loseCountMap.entrySet()) {
            Integer key = entry.getKey();
            Integer val = entry.getValue();
            if (val == 0) {
                first.add(key);
            } else if (val == 1) {
                second.add(key);
            }
        }
        first.sort(Integer::compareTo);
        second.sort(Integer::compareTo);
        res.add(first);
        res.add(second);

        return res;
    }

    public static void main(String[] args) {
        int[][] matches = {{1, 3}, {2, 3}, {3, 6}, {5, 6}, {5, 7}, {4, 5}, {4, 8}, {4, 9}, {10, 4}, {10, 9}};
        // [[1,2,10],[4,5,7,8]]
        System.out.println(new FindWinners2225().findWinners(matches));
    }
}
