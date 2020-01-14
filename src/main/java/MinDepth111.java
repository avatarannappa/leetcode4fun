/**
 * 111. 二叉树的最小深度
 *
 * @author avatarannappa
 * @version 1.0, 2019/12/07
 */
public class MinDepth111 {

    public int minDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = minDepth(root.left);
        int right = minDepth(root.right);
        return root.left == null || root.right == null ? left + right + 1 : Math.min(left, right) + 1;
    }
}
