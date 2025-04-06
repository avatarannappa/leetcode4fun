import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeSet;

/**
 * 2597. 美丽子集的数目.
 * medium
 *
 * @author avatarannappa
 * @version 2025/3/7
 */
public class BeautifulSubsets2597 {

    Set<String> sameKey = new HashSet<>();

    public int beautifulSubsets(int[] nums, int k) {
        // 组合数
        // TODO DP
        int res = 0;
        int n = (1 << nums.length) - 1;
        for (int i = 1; i <= n; i++) {
            if (isBeautiful(nums, k, i)) {
                res++;
            }
        }
        return res;
    }

    public boolean isBeautiful(int[] nums, int k, int mask) {
        List<Integer> l = new ArrayList<>();
        int index = 0;
        while (mask > 0) {
            int t = mask & 1;
            if (t == 1) {
                l.add(nums[index]);
            }
            mask >>= 1;
            index++;
        }
        if (l.isEmpty()) {
            return false;
        }
        for (int j = 0; j < l.size(); j++) {
            for (int a = j + 1; a < l.size(); a++) {
                if (Math.abs(l.get(j) - l.get(a)) == k) {
                    return false;
                }
            }
        }
        return true;
    }

    public int beautifulSubsetsOld(int[] nums, int k) {
        // 回溯 O(2^N)超时
        return dfs(nums, new TreeSet<>(), k);
    }

    public int dfs(int[] nums, SortedSet<Integer> removeIndex, int k) {
        String key = key(removeIndex);
        if (sameKey.contains(key)) {
            return 0;
        }
        int res = isBeautiful(nums, removeIndex, k) ? 1 : 0;
        for (int i = 0; i < nums.length; i++) {
            if (removeIndex.contains(i)) {
                continue;
            }
            removeIndex.add(i);
            res += dfs(nums, removeIndex, k);
            removeIndex.remove(i);
        }
        sameKey.add(key);
        return res;
    }

    public String key(SortedSet<Integer> set) {
        StringBuilder sb = new StringBuilder();
        for (Integer i : set) {
            sb.append(i).append("_");
        }
        return sb.toString();
    }

    public boolean isBeautiful(int[] nums, SortedSet<Integer> removedIndex, int k) {
        if (nums.length - removedIndex.size() == 1) {
            return true;
        } else if (nums.length == removedIndex.size()) {
            return false;
        }
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            if (!removedIndex.contains(i)) {
                list.add(nums[i]);
            }
        }
        for (int i = 0; i < list.size(); i++) {
            for (int j = i + 1; j < list.size(); j++) {
                if (Math.abs(list.get(i) - list.get(j)) == k) {
                    return false;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        int[] nums = {2, 4, 6};
        int k = 2;
        // 4
        System.out.println(new BeautifulSubsets2597().beautifulSubsets(nums, k));
    }
}
