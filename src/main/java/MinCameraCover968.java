/**
 * 968. 监控二叉树.
 *
 * @author avatarannappa
 * @version 1.0, 2020/9/22
 */
public class MinCameraCover968 {

    int count = 0;

    public int minCameraCover(TreeNode root) {
        return dfs(root) == 0 ? count + 1 : count;
    }

    public int dfs(TreeNode root) {
        // 0 待覆盖 1 已覆盖 2相机
        if (root == null) {
            return 1;
        }
        int left = dfs(root.left);
        int right = dfs(root.right);
        if (left == 0 || right == 0) {
            count++;
            return 2;
        } else if (left == 1 && right == 1) {
            return 0;
        } else {
            return 1;
        }
    }

}
