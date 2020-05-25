import java.util.ArrayList;
import java.util.List;

/**
 * 120. 三角形最小路径和.
 *
 * @author avatarannappa
 * @version 1.0, 2020/5/25
 */
public class MinimumTotal120 {

    int len;
    List<List<Integer>> dp;

    public int minimumTotal(List<List<Integer>> triangle) {
        if (triangle == null || triangle.size() == 0) {
            return 0;
        }
        this.len = triangle.size();
        dp = new ArrayList<>();
        for (int i = 0; i < triangle.size(); i++) {
            List<Integer> row = new ArrayList<>();
            for (int j = 0; j < triangle.get(i).size(); j++) {
                row.add(null);
            }
            dp.add(row);
        }
        return backTrack(0, 0, triangle);
    }

    public int backTrack(int level, int index, List<List<Integer>> triangle) {
        int now = triangle.get(level).get(index);
        if (level == len - 1) {
            return now;
        }
        if (dp.get(level).get(index) != null) {
            return dp.get(level).get(index);
        }
        int left = backTrack(level + 1, index, triangle);
        int right = backTrack(level + 1, index + 1, triangle);
        int result = now + Math.min(left, right);
        dp.get(level).add(index, result);
        return result;
    }

    public static void main(String[] args) {
        List<List<Integer>> triangle = new ArrayList<>(3);
        List<Integer> one = new ArrayList<>();
        one.add(1);
        List<Integer> two = new ArrayList<>();
        two.add(2);
        two.add(3);
        List<Integer> three = new ArrayList<>();
        three.add(4);
        three.add(5);
        three.add(6);
        triangle.add(one);
        triangle.add(two);
        triangle.add(three);
        System.out.println(new MinimumTotal120().minimumTotal(triangle));
    }
}
