import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * 60. 第k个排列.
 *
 * @author avatarannappa
 * @version 1.0, 2020/5/28
 */
public class GetPermutation60 {

    public String getPermutation(int n, int k) {
        // math
        int[] factorials = new int[n];
        List<Integer> nums = new ArrayList() {{add(1);}};

        factorials[0] = 1;
        for(int i = 1; i < n; ++i) {
            // generate factorial system bases 0!, 1!, ..., (n - 1)!
            factorials[i] = factorials[i - 1] * i;
            // generate nums 1, 2, ..., n
            nums.add(i + 1);
        }

        --k;

        StringBuilder sb = new StringBuilder();
        for (int i = n - 1; i >= 0; --i) {
            int idx = k / factorials[i];
            k -= idx * factorials[i];

            sb.append(nums.get(idx));
            nums.remove(idx);
        }
        return sb.toString();
    }

    public String getPermutationOld(int n, int k) {
        // 超时 n=8 k=38790
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = i + 1;
        }
        List<List<Integer>> list = permute(nums);
        Queue<String> queue = new PriorityQueue<>();
        for (List<Integer> integers : list) {
            String s = "";
            for (Integer integer : integers) {
                s += integer;
            }
            queue.add(s);
        }
        for (int i = 0; i < k; i++) {
            String s = queue.poll();
            if (i == k - 1) {
                return s;
            }
        }
        return null;
    }

    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        if (nums == null || nums.length == 0) {
            List<Integer> list = new ArrayList<>();
            result.add(list);
            return result;
        }
        if (nums.length == 1) {
            List<Integer> list = new ArrayList<>();
            list.add(nums[0]);
            result.add(list);
            return result;
        }
        int length = nums.length;
        for (int i = 0; i < length; i++) {
            int num = nums[i];
            // int[] newNums = ArrayUtils.remove(nums,i);
            int[] newNums = new int[length - 1];
            System.arraycopy(nums, 0, newNums, 0, i);
            if (i < length - 1) {
                System.arraycopy(nums, i + 1, newNums, i, length - i - 1);
            }
            List<List<Integer>> wtf = permute(newNums);
            for (List<Integer> l : wtf) {
                l.add(num);
                result.add(l);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int n = 3;
        int k = 3;
        System.out.println(new GetPermutation60().getPermutation(n, k));
    }
}
