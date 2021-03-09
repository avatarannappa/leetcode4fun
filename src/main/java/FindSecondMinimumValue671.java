import java.util.TreeSet;

/**
 * 671. 二叉树中第二小的节点
 * easy
 *
 * @author avatarannappa
 * @version 1.0, 2021/3/9
 */
public class FindSecondMinimumValue671 {

    TreeSet<Integer> treeSet = new TreeSet<>();

    public int findSecondMinimumValue(TreeNode root) {
        dfs(root);
        if (treeSet.size() >= 2) {
            Integer first = treeSet.pollFirst();
            Integer second = treeSet.pollFirst();
            return second;
        }
        return -1;
    }

    public void dfs(TreeNode root) {
        if (root == null) {
            return;
        }
        treeSet.add(root.val);
        dfs(root.left);
        dfs(root.right);
    }

    public static void main(String[] args) {
        Integer[] array = {2, 2, 5, null, null, 5, 7};
        TreeNode tree = TreeUtils.arrayToTree(array);
        System.out.println(new FindSecondMinimumValue671().findSecondMinimumValue(tree));
    }
}
