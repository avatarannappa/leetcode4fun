import java.util.HashSet;
import java.util.Set;

/**
 * 剑指 Offer 54. 二叉搜索树的第k大节点
 * easy
 *
 * @author avatarannappa
 * @version 1.0, 2021/4/14
 */
public class KthLargestOffer54 {

    int result;
    Set<Integer> set = new HashSet<>();
    int k;

    public int kthLargest(TreeNode root, int k) {
        this.k = k;
        recursion(root);
        return result;
    }

    public void recursion(TreeNode root) {
        if (root == null) {
            return;
        }
        recursion(root.right);
        set.add(root.val);
        recursion(root.left);
        if (set.size() == k) {
            result = root.val;
        }
    }
}
