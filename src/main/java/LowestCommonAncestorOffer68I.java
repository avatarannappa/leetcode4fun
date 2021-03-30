/**
 * 剑指 Offer 68 - I. 二叉搜索树的最近公共祖先
 * easy
 *
 * @author avatarannappa
 * @version 1.0, 2021/3/30
 */
public class LowestCommonAncestorOffer68I {

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (p.val > q.val) {
            TreeNode temp = p;
            p = q;
            q = temp;
        }
        if (p.val == root.val) {
            return p;
        } else if (q.val == root.val) {
            return q;
        } else if (root.val > p.val && root.val < q.val) {
            return root;
        } else if (root.val > p.val && root.val > q.val) {
            return lowestCommonAncestor(root.left, p, q);
        } else if (root.val < q.val && root.val < q.val) {
            return lowestCommonAncestor(root.right, p, q);
        }
        return root;
    }

    public static void main(String[] args) {
        Integer[] array = {6, 2, 8, 0, 4, 7, 9, null, null, 3, 5};
        TreeNode root = TreeUtils.arrayToTree(array);
        TreeNode p = new TreeNode();
        p.val = 2;
        TreeNode q = new TreeNode();
        q.val = 4;
        System.out.println(new LowestCommonAncestorOffer68().lowestCommonAncestor(root, p, q));
    }
}
