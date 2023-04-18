/**
 * 1026. 节点与其祖先之间的最大差值
 * medium
 *
 * @author avatarannappa
 * @date 2023/4/18
 */
public class MaxAncestorDiff1026 {

    int res = 0;
    int min_val = 100010;
    int max_val = -1;

    public int maxAncestorDiff(TreeNode root) {
        // 记录最小值和最大值，dfs
        dfs(root, min_val, max_val);
        return res;
    }

    public void dfs(TreeNode root, int min, int max) {
        if (root == null) {
            return;
        }
        int val = root.val;
        if (min != min_val) {
            res = Math.max(res, Math.abs(min - val));
        }
        if (max != max_val) {
            res = Math.max(res, Math.abs(max - val));
        }
        min = Math.min(min, val);
        max = Math.max(max, val);
        dfs(root.left, min, max);
        dfs(root.right, min, max);
    }
}
