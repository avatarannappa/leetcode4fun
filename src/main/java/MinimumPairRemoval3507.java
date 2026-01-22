import java.util.*;

/**
 * 3507. 移除最小数对使数组有序 I.
 * easy
 *
 * @author avatarannappa
 * @version 1.0, 2026/1/22
 */
public class MinimumPairRemoval3507 {

    public int minimumPairRemoval(int[] nums) {
        List<Integer> list = new LinkedList<>();
        for (int num : nums) {
            list.add(num);
        }

        int res = 0;
        while(list.size()>=2){
            if (check(list)) {
                break;
            }
            int min = Integer.MAX_VALUE;
            int index = 0;
            for (int i = 0; i < list.size() - 1; i++) {
                int temp = list.get(i) + list.get(i + 1);
                if (temp < min) {
                    min = temp;
                    index = i;
                }
            }
            list.remove(index);
            list.remove(index);
            list.add(index, min);
            res++;
        }
        return res;
    }

    private boolean check(List<Integer> list) {
        for (int i = 0; i < list.size() - 1; i++) {
            if (list.get(i) > list.get(i + 1)) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        // 2
        int[] nums = {1,2,2};
        System.out.println(new MinimumPairRemoval3507().minimumPairRemoval(nums));
    }

}
