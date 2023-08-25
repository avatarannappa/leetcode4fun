/**
 * 1448. 统计二叉树中好节点的数目
 * medium
 *
 * @author avatarannappa
 * @date 2023/8/25
 */
public class GoodNodes1448 {

    int cnt = 0;

    public int goodNodes(TreeNode root) {
        dfs(root, Integer.MIN_VALUE);
        return cnt;
    }

    public void dfs(TreeNode root, int max) {
        if (root == null) {
            return;
        }
        if (root.val >= max) {
            cnt++;
            max = root.val;
        }
        dfs(root.left, max);
        dfs(root.right, max);
    }

}
