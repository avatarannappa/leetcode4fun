import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeSet;

/**
 * 1488. 避免洪水泛滥
 * medium
 *
 * @author avatarannappa
 * @date 2023/10/13
 */
public class AvoidFlood1488 {

    public int[] avoidFlood(int[] rains) {
        // 贪心 + TreeMap(二分)
        Map<Integer, Integer> holeIndexMap = new HashMap<>();
        TreeSet<Integer> zeroIndexTreeSet = new TreeSet<>();

        Map<Integer, Integer> remove = new HashMap<>();
        for (int i = 0; i < rains.length; i++) {
            int indexOfHole = rains[i];
            if (indexOfHole == 0) {
                zeroIndexTreeSet.add(i);
            } else {
                if (holeIndexMap.containsKey(indexOfHole)) {
                    int indexOfRains = holeIndexMap.get(indexOfHole);
                    if (zeroIndexTreeSet.size() == 0 || zeroIndexTreeSet.higher(indexOfRains) == null) {
                        return new int[0];
                    } else {
                        int zeroIndex = zeroIndexTreeSet.higher(indexOfRains);
                        zeroIndexTreeSet.remove(zeroIndex);
                        holeIndexMap.put(indexOfHole, i);

                        remove.put(zeroIndex, indexOfHole);
                    }
                } else {
                    holeIndexMap.put(indexOfHole, i);
                }
            }
        }

        int[] ans = new int[rains.length];
        for (int i = 0; i < rains.length; i++) {
            int ind = rains[i];
            if (ind == 0) {
                if (remove.containsKey(i)) {
                    ans[i] = remove.get(i);
                } else {
                    ans[i] = 1;
                }
            } else {
                ans[i] = -1;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] rains = {1, 0, 2, 0, 3, 0, 2, 0, 0, 0, 1, 2, 3};
        // 输出：[-1,1,-1,2,-1,3,-1,2,1,1,-1,-1,-1]
        System.out.println(Arrays.toString(new AvoidFlood1488().avoidFlood(rains)));
    }
}
