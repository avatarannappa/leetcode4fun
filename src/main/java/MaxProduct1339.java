import java.util.HashMap;
import java.util.Map;

/**
 * 1339. 分裂二叉树的最大乘积.
 * medium
 *
 * @author avatarannappa
 * @version 1.0, 2026/1/7
 */
public class MaxProduct1339 {
    int sum = 0;
    int mod = 1000000007;
    long max = 0;

    public int maxProduct(TreeNode root) {
        sum = dfs(root);
        calculate(root);
        return (int) (max % mod);
    }

    public int dfs(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return root.val + dfs(root.left) + dfs(root.right);
    }

    public int calculate(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int s = root.val + calculate(root.left) + calculate(root.right);
        max = Math.max(max, (long) s * (sum - s));
        return s;
    }

    public static void main(String[] args) {
        Integer[] arr = {9,1,8,7,null,null,null,null,5,7,3};
        TreeNode root = TreeUtils.arrayToTree(arr);
        // 396
        System.out.println(new MaxProduct1339().maxProduct(root));
    }
}
