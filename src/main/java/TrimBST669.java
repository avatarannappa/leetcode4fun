/**
 * 669. 修剪二叉搜索树.
 *
 * @author avatarannappa
 * @version 1.0, 2019/12/11
 */
public class TrimBST669 {
    int l;
    int r;

    public TreeNode trimBST(TreeNode root, int L, int R) {
        if (root == null) {
            return null;
        }
        l = L;
        r = R;
        return recursion(root);
    }

    public TreeNode recursion(TreeNode node) {
        if (node == null) {
            return null;
        }
        if (node.val < l) {
            return recursion(node.right);
        } else if (node.val > r) {
            return recursion(node.left);
        } else {
            node.left = recursion(node.left);
            node.right = recursion(node.right);
            return node;
        }
    }
}
