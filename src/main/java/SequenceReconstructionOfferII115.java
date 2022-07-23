import java.util.HashMap;
import java.util.Map;

/**
 * 剑指offer II 115. 重构序列
 * medium
 *
 * @author avatarannappa
 * @version 1.0, 2022/7/23
 */
public class SequenceReconstructionOfferII115 {
    public boolean sequenceReconstruction(int[] nums, int[][] sequences) {
        // 同主站444题，会员题目
        // 拓扑
        if (nums.length <= 1) {
            return true;
        }
        Map<Integer, Integer> map = new HashMap<>();
        Map<Integer, Integer> map2 = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], i);
        }

        for (int[] sequence : sequences) {
            for (int j = 1; j < sequence.length; j++) {
                if (map.get(sequence[j]) - map.get(sequence[j - 1]) == 1) {
                    map2.put(sequence[j - 1], map2.getOrDefault(sequence[j - 1], 0) + 1);
                    map2.put(sequence[j], map2.getOrDefault(sequence[j], 0) + 1);
                }
            }
        }
        if (map2.size() != nums.length) {
            return false;
        }
        for (Integer k : map2.keySet()) {
            int v = map2.get(k);
            if (v < 2 && (map.get(k) != 0 && map.get(k) != nums.length - 1)) {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
//        int[] nums = {1,2,3};
//        int[][] seqquences = {{1,2}, {1,3}};
        int[] nums = {5, 4, 8, 9, 1, 6, 3, 2, 7, 10};
        int[][] seqquences = {{8, 9, 1}, {6, 3, 2, 7, 10}, {5, 4}};
        // false
        System.out.println(new SequenceReconstructionOfferII115().sequenceReconstruction(nums, seqquences));
    }
}
