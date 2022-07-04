import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * 1200. 最小绝对差
 * easy
 *
 * @author avatarannappa
 * @date 2022/7/4
 */
public class MinimumAbsDifference1200 {

    public List<List<Integer>> minimumAbsDifference(int[] arr) {
        Arrays.sort(arr);
        List<List<Integer>> ans = new ArrayList<>();

        int min = Integer.MAX_VALUE;
        for (int i = 1; i < arr.length; i++) {
            min = Math.min(min, arr[i] - arr[i - 1]);
        }
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] - arr[i - 1] == min) {
                List<Integer> tuple = new LinkedList<>();
                tuple.add(arr[i - 1]);
                tuple.add(arr[i]);
                ans.add(tuple);
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        int[] arr = {3, 8, -10, 23, 19, -4, -14, 27};
        // [[-14,-10],[19,23],[23,27]]
        System.out.println(new MinimumAbsDifference1200().minimumAbsDifference(arr));
    }
}
