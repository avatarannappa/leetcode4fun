/**
 * 236. 二叉树的最近公共祖先.
 *
 * @author avatarannappa
 * @version 1.0, 2020/2/22
 */
public class LowestCommonAncestor236 {

    public TreeNode t = null;

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) {
            return null;
        }
        recursion(root, p, q);
        return t;
    }

    public boolean recursion(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || t != null) {
            return false;
        }
        boolean left = recursion(root.left, p, q);
        boolean right = recursion(root.right, p, q);
        if (left && right) {
            t = root;
        } else if (left && in(root, p, q)) {
            t = root;
        } else if (right && in(root, p, q)) {
            t = root;
        } else if (in(root, p, q)) {
            return true;
        } else if (left || right) {
            return true;
        }
        return false;
    }

    public boolean in(TreeNode root, TreeNode p, TreeNode q) {
        return root.val == p.val || root.val == q.val;
    }


    public static void main(String[] args) {
//        Integer[] nums = {3, 5, 1, 6, 2, 0, 8, null, null, 7, 4};
//        TreeNode p = new TreeNode(5);
//        TreeNode q = new TreeNode(4);
        Integer[] nums = {1, 2};
        TreeNode p = new TreeNode(1);
        TreeNode q = new TreeNode(2);
        TreeNode root = TreeUtils.arrayToTree(nums);
        System.out.println(root);
        System.out.println(new LowestCommonAncestor236().lowestCommonAncestor(root, p, q));
    }

}
