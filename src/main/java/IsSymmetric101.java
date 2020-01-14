/**
 * 101. 对称二叉树
 *
 * @author avatarannapp
 * @version 1.0, 2019/11/26
 */
public class IsSymmetric101 {
    public boolean isSymmetric(TreeNode root) {
        if (root == null) {
            return true;
        }
        return recursion(root.left, root.right);
    }

    public boolean recursion(TreeNode left, TreeNode right) {
        if (left == null && right != null) {
            return false;
        }
        if (left != null && right == null) {
            return false;
        }
        if (left == null && right == null) {
            return true;
        }

        return left.val == right.val && recursion(left.left, right.right) && recursion(left.right, right.left);
    }
}
