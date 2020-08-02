import java.util.*;

/**
 * 501. 二叉搜索树中的众数
 *
 * @author avatarannappa
 * @version 1.0, 2020/08/02
 */
public class FindMode510 {

    Map<Integer, Integer> map = new HashMap<>();

    public int[] findMode(TreeNode root) {

        int[] array = new int[0];
        if (root == null) {
            return array;
        }
        recursion(root);
        List<Map.Entry<Integer, Integer>> list = new ArrayList<>(map.entrySet());
        list.sort(((o1, o2) -> o2.getValue() - o1.getValue()));
        int max = list.get(0).getValue();
        List<Integer> result = new LinkedList<>();

        for (Map.Entry<Integer, Integer> entry : list) {
            if (entry.getValue() == max) {
                result.add(entry.getKey());
            }
        }

        array = new int[result.size()];
        for (int i = 0; i < result.size(); i++) {
            array[i] = result.get(i);
        }
        return array;
    }

    public void recursion(TreeNode root) {
        if (root == null) {
            return;
        }
        map.put(root.val, map.getOrDefault(root.val, 0) + 1);
        recursion(root.left);
        recursion(root.right);
    }

    public static void main(String[] args) {
        Integer[] nums = {1, null, 2, 2};
        TreeNode root = TreeUtils.arrayToTree(nums);
        System.out.println(Arrays.toString(new FindMode510().findMode(root)));
    }

}
