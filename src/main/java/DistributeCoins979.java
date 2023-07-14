/**
 * 979. 在二叉树中分配硬币
 * medium
 *
 * @author avatarannappa
 * @date 2023/7/14
 */
public class DistributeCoins979 {

    private int res = 0;

    public int distributeCoins(TreeNode root) {
        // 贡献法+dfs，边通过的coin数量
        dfs(root);
        return res;
    }

    public int dfs(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int d = dfs(root.left) + dfs(root.right) + root.val - 1;
        res += Math.abs(d);
        return d;
    }

    public static void main(String[] args) {
        Integer[] arr = {3, 0, 0};
        // 输出：2
        TreeNode root = TreeUtils.arrayToTree(arr);
        System.out.println(new DistributeCoins979().distributeCoins(root));
    }
}
