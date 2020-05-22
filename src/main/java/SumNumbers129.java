/**
 * 129. 求根到叶子节点数字之和.
 *
 * @author avatarannappa
 * @version 1.0, 2020/5/22
 */
public class SumNumbers129 {

    int sum = 0;

    public int sumNumbers(TreeNode root) {
        if (root == null) {
            return sum;
        }
        recursion("", root);
        return sum;
    }

    public void recursion(String pre, TreeNode root) {
        if (root.left == null && root.right == null) {
            int x = Integer.parseInt(pre + root.val);
            sum += x;
        }
        if (root.left != null) {
            recursion(pre + root.val, root.left);
        }
        if (root.right != null) {
            recursion(pre + root.val, root.right);
        }
    }

    public static void main(String[] args) {
        Integer[] nums = {4, 9, 0, 5, 1};
        TreeNode root = TreeUtils.arrayToTree(nums);
        System.out.println(new SumNumbers129().sumNumbers(root));
    }

}
