/**
 * 543. 二叉树的直径
 *
 * @author avatarannappa
 * @version 1.0, 2020/2/17
 */
public class DiameterOfBinaryTree543 {

    public int diameter = 0;

    public int diameterOfBinaryTree(TreeNode root) {
        if (root == null) {
            return 0;
        }
        recursion(root);
        return diameter;
    }

    public int recursion(TreeNode t) {
        if (t == null) {
            return 0;
        }
        int left = recursion(t.left);
        int right = recursion(t.right);
        diameter = Math.max(diameter, left + right);
        return Math.max(left, right) + 1;
    }

}
