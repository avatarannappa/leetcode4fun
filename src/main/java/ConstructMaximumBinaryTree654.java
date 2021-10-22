/**
 * 654. 最大二叉树,Maximum Binary Tree. medium
 *
 * @author avatarannappa
 * @version 1.0
 * @date 2021/10/22
 */
public class ConstructMaximumBinaryTree654 {

    public TreeNode constructMaximumBinaryTree(int[] nums) {
        if (nums == null || nums.length == 0) {
            return null;
        }
        return recursion(nums, 0, nums.length - 1);
    }

    public TreeNode recursion(int[] nums, int l, int r) {
        if (l > r) {
            return null;
        }

        int index = l;
        int max = Integer.MIN_VALUE;
        for (int i = l; i <= r; i++) {
            if (nums[i] > max) {
                max = nums[i];
                index = i;
            }
        }
        TreeNode root = new TreeNode(max);
        root.left = recursion(nums, l, index - 1);
        root.right = recursion(nums, index + 1, r);
        return root;
    }

    public static void main(String[] args) {
        int[] nums = { 3, 2, 1, 6, 0, 5 };
        TreeNode res = new ConstructMaximumBinaryTree654().constructMaximumBinaryTree(nums);
        System.out.println(res);
    }
}
