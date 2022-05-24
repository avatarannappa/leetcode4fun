/**
 * 965. 单值二叉树.
 * easy
 *
 * @author avatarannappa
 * @version 1.0
 * @date 2022/5/24
 */
public class IsUnivalTree965 {

    public boolean isUnivalTree(TreeNode root) {
        if (root == null) {
            return true;
        }
        if (root.left != null && root.left.val != root.val) {
            return false;
        }
        if (root.right != null && root.right.val != root.val) {
            return false;
        }
        return isUnivalTree(root.left) && isUnivalTree(root.right);
    }
    
}
