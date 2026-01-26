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

    public List<List<Integer>> minimumAbsDifference2(int[] arr) {
        // 一边遍历，关键是排序
        Arrays.sort(arr);
        List<List<Integer>> ans = new ArrayList<>();
        int min = Integer.MAX_VALUE;
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] - arr[i - 1] == min) {
                List<Integer> tuple = new LinkedList<>();
                tuple.add(arr[i - 1]);
                tuple.add(arr[i]);
                ans.add(tuple);
            } else if (arr[i] - arr[i - 1] < min) {
                min = Math.min(min, arr[i] - arr[i - 1]);
                List<Integer> tuple = new LinkedList<>();
                tuple.add(arr[i - 1]);
                tuple.add(arr[i]);
                ans.clear();
                ans.add(tuple);
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] arr = {40, 11, 26, 27, -20};
        System.out.println(new MinimumAbsDifference1200().minimumAbsDifference2(arr));
    }
}
