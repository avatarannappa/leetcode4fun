/**
 * 530. 二叉搜索树的最小绝对差.
 *
 * @author avatarannappa
 * @version 1.0, 2020/8/1
 */
public class GetMinimumDifference530 {
    int min = Integer.MAX_VALUE;

    public int getMinimumDifference(TreeNode root) {
        min = Math.min(min, recursion(root, root.val));
        if (root.left != null) {
            min = Math.min(min, getMinimumDifference(root.left));
        }
        if (root.right != null) {
            min = Math.min(min, getMinimumDifference(root.right));
        }
        return min;
    }

    public int recursion(TreeNode node, int val) {
        int rightVal = Integer.MAX_VALUE;
        TreeNode right = node.right;
        while (right != null) {
            rightVal = right.val;
            right = right.left;
        }

        int leftVal = Integer.MAX_VALUE;
        TreeNode left = node.left;
        while (left != null) {
            leftVal = left.val;
            left = left.right;
        }
        return Math.min(Math.abs(val - rightVal), Math.abs(val - leftVal));
    }

    public static void main(String[] args) {
        Integer[] array = {1, null, 3, 2, null};
        TreeNode root = TreeUtils.arrayToTree(array);
        System.out.println(root);
        System.out.println(new GetMinimumDifference530().getMinimumDifference(root));
    }
}
