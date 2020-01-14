import java.util.ArrayList;
import java.util.List;

/**
 * 39. 组合总和
 *
 * @author avatarannappa
 * @version 1.0, 2019/11/20
 */
public class CombinationSum39 {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();

        return result;
    }

    public static void main(String[] args) {
        CombinationSum39 c = new CombinationSum39();
        int[] candidates = {2, 3, 6, 7};
        int target = 7;
        List<List<Integer>> result = c.combinationSum(candidates, target);
        System.out.println(result);
    }
}
