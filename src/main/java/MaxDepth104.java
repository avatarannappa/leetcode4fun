/**
 * 104. 二叉树的最大深度.
 *
 * @author avatarannappa
 * @version 1.0, 2019/11/29
 */
public class MaxDepth104 {
    public int maxDepth(TreeNode root) {
        return recursion(0, root);
    }

    public Integer recursion(Integer level, TreeNode root) {
        if (root == null) {
            return level;
        }
        level++;
        return Math.max(recursion(level, root.left), recursion(level, root.right));
    }
}
