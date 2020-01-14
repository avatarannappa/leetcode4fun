/**
 * 112. 路径总和
 *
 * @author avatarannappa
 * @version 1.0, 2019/12/08
 */
public class HasPathSum112 {
    public boolean hasPathSum(TreeNode root, int sum) {
        if (root == null) {
            return false;
        }
        if (isLeaf(root) && sum - root.val == 0) {
            return true;
        }
        return hasPathSum(root.left, sum - root.val) || hasPathSum(root.right, sum - root.val);
    }

    public boolean isLeaf(TreeNode node) {
        return node != null && node.left == null && node.right == null;
    }
}
