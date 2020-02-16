/**
 * 222. 完全二叉树的节点个数
 *
 * @author avatarannappa
 * @version 1.0, 2020/2/16
 */
public class CountNodes222 {

    int count = 0;

    public int countNodes(TreeNode root) {
        if (root == null) {
            return count;
        }
        count++;
        countNodes(root.left);
        countNodes(root.right);
        return count;
    }

}
