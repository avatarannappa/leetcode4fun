import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * 508. 出现次数最多的子树元素和
 * medium
 *
 * @author avatarannappa
 * @version 1.0, 2021/7/1
 */
public class FindFrequentTreeSum508 {

    Map<Integer, Integer> map = new HashMap<>();

    public int[] findFrequentTreeSum(TreeNode root) {
        PriorityQueue<Map.Entry<Integer, Integer>> queue = new PriorityQueue<>(
                (o1, o2) -> o2.getValue() - o1.getValue());
        recursion(root);
        queue.addAll(map.entrySet());
        int size = -1;
        List<Integer> list = new ArrayList<>();
        while (!queue.isEmpty()) {
            Map.Entry<Integer, Integer> entry = queue.poll();
            if (size == -1) {
                size = entry.getValue();
                list.add(entry.getKey());
            } else {
                if (entry.getValue() == size) {
                    list.add(entry.getKey());
                } else {
                    break;
                }
            }
        }
        int[] res = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            res[i] = list.get(i);
        }
        return res;
    }

    public int recursion(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int val = root.val;
        int l = recursion(root.left);
        int r = recursion(root.right);
        val += l + r;
        map.put(val, map.getOrDefault(val, 0) + 1);
        return val;
    }

    public static void main(String[] args) {
        Integer[] array = {5, 2, 1};
        TreeNode root = TreeUtils.arrayToTree(array);
        System.out.println(Arrays.toString(new FindFrequentTreeSum508().findFrequentTreeSum(root)));
    }
}
