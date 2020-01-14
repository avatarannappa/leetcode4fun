/**
 * 100. 相同的树.
 *
 * @author avatarannappa
 * @version 1.0, 2019/12/6
 */
public class IsSameTree100 {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == q) {
            return true;
        } else if (p == null) {
            return false;
        } else if (q == null) {
            return false;
        }
        if (p.val == q.val) {
            return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
        } else {
            return false;
        }
    }
}
