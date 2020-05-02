/**
 * 124. 二叉树中的最大路径和.
 *
 * @author avatarannappa
 * @version 1.0, 2020/5/2
 */
public class MaxPathSum124 {

    int max = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {
        recursion(root);
        return max;
    }

    public int recursion(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = Math.max(recursion(root.left), 0);
        int right = Math.max(recursion(root.right), 0);
        max = Math.max(max, left + right + root.val);
        return root.val + Math.max(left, right);
    }

    public static void main(String[] args) {
        Integer[] nums = {1, -2, -3, 1, 3, -2, null, -1};
        TreeNode treeNode = TreeUtils.arrayToTree(nums);
        System.out.println(new MaxPathSum124().maxPathSum(treeNode));
    }
}
