import java.util.LinkedList;
import java.util.List;

/**
 * 2200. 找出数组中的所有 K 近邻下表.
 * easy
 *
 * @author avatarannappa
 * @version 1.0, 2025/6/24
 */
public class FindKDistantIndices2200 {
    public List<Integer> findKDistantIndices(int[] nums, int key, int k) {
        List<Integer> keyIndices = new LinkedList<>();
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == key) {
                keyIndices.add(i);
            }
        }

        List<Integer> res = new LinkedList<>();
        if (keyIndices.isEmpty()) {
            return res;
        }
        int j = 0;
        for (int i = 0; i < nums.length; ) {
            if (i <= keyIndices.get(j)) {
                if (keyIndices.get(j) - i <= k) {
                    res.add(i++);
                } else {
                    i++;
                }
            } else if (i > keyIndices.get(j)) {
                if (i - keyIndices.get(j) <= k) {
                    res.add(i++);
                } else {
                    if (j < keyIndices.size() - 1) {
                        j++;
                    } else {
                        break;
                    }
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        int key = 2;
        int k = 5;
        // 1,2,3,4,5,6
        System.out.println(new FindKDistantIndices2200().findKDistantIndices(nums, key, k));
    }
}
