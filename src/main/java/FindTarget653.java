import java.util.HashSet;
import java.util.Set;

/**
 * 653. 两数之和 IV - 输入 BST.
 *
 * @author avatarannappa
 * @version 1.0, 2020/7/31
 */
public class FindTarget653 {

    public boolean findTarget(TreeNode root, int k) {
        if (root == null) {
            return false;
        }
        Set<Integer> set = new HashSet<>();
        return recursion(root, k, set);
    }

    public boolean recursion(TreeNode root, int k, Set<Integer> set) {
        if (root == null) {
            return false;
        }
        if (set.contains(k - root.val)) {
            return true;
        } else {
            set.add(root.val);
        }

        return recursion(root.left, k, set) || recursion(root.right, k, set);
    }

    public static void main(String[] args) {
        Integer[] array = {2, 1, 3};
        TreeNode root = TreeUtils.arrayToTree(array);
        System.out.println(root);
        System.out.println(new FindTarget653().findTarget(root, 4));
    }

}
