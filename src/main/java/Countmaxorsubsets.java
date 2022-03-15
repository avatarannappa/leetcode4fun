import java.util.TreeMap;

/**
 * 2044. 统计按位或能得到最大值的子集数目.
 * medium
 *
 * @author avatarannappa
 * @version 1.0
 * @date 2022/3/15
 */
public class Countmaxorsubsets {

    TreeMap<Integer, Integer> map = new TreeMap<>();
    int[] nums;

    public int countMaxOrSubsets(int[] nums) {
        // O(2^^n) dfs，遍历中计算或值，前面路径，减少了计算量
        // TODO 状压DP
        this.nums = nums;
        dfs(0,0);
        System.out.println(map);
        return map.get(map.lastKey());
    }

    private void dfs(int i, int v) {
        if (i == nums.length) {
            // 所有位都计算过了，再统计
            map.put(v, map.getOrDefault(v, 0) + 1);
            return;
        }
        dfs(i + 1, v);
        dfs(i + 1, v | nums[i]);
    }

    public int countMaxOrSubsetsOld(int[] nums) {
        // O(2^^n * n) 求子集的复杂度2^^n。关键是求子集[0, 2^^n)，0表示没选，1表示选了
        TreeMap<Integer, Integer> map = new TreeMap<>((o1, o2) -> o2 - o1);
        for (int i = 0; i < 1 << nums.length; i++) {
            int temp = 0;
            for (int j = 0; j < nums.length; j++) {
                if (((i >> j) & 1) == 1) {
                    temp |= nums[j];
                }
            }
            map.put(temp, map.getOrDefault(temp, 0) + 1);
        }
        return map.get(map.firstKey());
    }

    public static void main(String[] args) {
        int[] nums = {3, 2, 1, 5};
        // 最大值7，数量6
        System.out.println(new Countmaxorsubsets().countMaxOrSubsets(nums));
    }

}
