/**
 * 110. 平衡二叉树
 *
 * @author avatarannappa
 * @version 1.0, 2019/12/5
 */
public class IsBalanced110 {
    boolean res = true;

    public boolean isBalanced(TreeNode root) {
        recursion(root);
        return res;
    }

    public int recursion(TreeNode node) {
        if (node == null) {
            return 0;
        }
        int left = recursion(node.left) + 1;
        int right = recursion(node.right) + 1;
        if (Math.abs(left - right) > 1) {
            res = false;
        }
        return Math.max(left, right);
    }
}
