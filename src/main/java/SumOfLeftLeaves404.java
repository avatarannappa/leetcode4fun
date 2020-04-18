/**
 * 404. 左叶子之和
 *
 * @author avatarannappa
 * @version 1.0, 2020/4/18
 */
public class SumOfLeftLeaves404 {

    int sum = 0;

    public int sumOfLeftLeaves(TreeNode root) {
        if (root == null) {
            return 0;
        }
        if (root.left != null && (root.left.left == null && root.left.right == null)) {
            sum += root.left.val;
        }
        sumOfLeftLeaves(root.left);
        sumOfLeftLeaves(root.right);
        return sum;
    }

    public static void main(String[] args) {
        Integer[] nums = {1, 2, 3, 4, 5};
        TreeNode treeNode = TreeUtils.arrayToTree(nums);
        System.out.println(treeNode);
        System.out.println(new SumOfLeftLeaves404().sumOfLeftLeaves(treeNode));
    }
}
