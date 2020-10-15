import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * 501. 二叉搜索树中的众数.
 *
 * @author avatarannappa
 * @version 1.0, 2020/10/15
 */
public class FindMode501 {

    Map<Integer, Integer> map = new HashMap<>();

    public int[] findMode(TreeNode root) {
        recursion(root);
        Set<Map.Entry<Integer, Integer>> set = map.entrySet();
        List<Map.Entry<Integer, Integer>> list = new ArrayList<>(map.entrySet());
        list.sort(((o1, o2) -> o2.getValue() - o1.getValue()));
        int pre = -1;
        List<Integer> result = new ArrayList<>();
        for (Map.Entry<Integer, Integer> entry : list) {
            if (entry.getValue() >= pre) {
                pre = entry.getValue();
                result.add(pre);
            }
        }
        int[] res = new int[result.size()];
        for (int i = 0; i < result.size(); i++) {
            res[i] = result.get(i);
        }
        return res;
    }

    public void recursion(TreeNode root) {
        if (root == null) {
            return;
        }
        int val = root.val;
        int count = map.getOrDefault(val, 0);
        map.put(val, count + 1);
        recursion(root.left);
        recursion(root.right);
    }

}
