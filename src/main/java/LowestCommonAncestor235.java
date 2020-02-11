/**
 * 235. 二叉搜索树的最近公共祖先
 *
 * @author avatarannappa
 * @version 1.0, 2020/2/8
 */
public class LowestCommonAncestor235 {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        int r = root.val;
        int pv = p.val;
        int qv = q.val;
        if (r > pv && r > qv) {
            return lowestCommonAncestor(root.left, p, q);
        } else if (r < pv && r < qv) {
            return lowestCommonAncestor(root.right, p, q);
        } else {
            return root;
        }
    }
}
