/**
 * 98. 验证二叉搜索树.
 *
 * @author avatarannappa
 * @version 1.0, 2019/11/25
 */
public class IsValidBST98 {

    public boolean isValidBST(TreeNode root) {
        return recursion(root, null, null);
    }

    public boolean recursion(TreeNode root, Integer low, Integer upper) {
        if (root == null) {
            return true;
        }
        int val = root.val;
        if (low != null && val <= low) {
            return false;
        }
        if (upper != null && val >= upper) {
            return false;
        }

        return recursion(root.left, low, val) && recursion(root.right, val, upper);
    }

}
