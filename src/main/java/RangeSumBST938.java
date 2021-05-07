/**
 * 938. 二叉搜索树的范围和
 * easy
 *
 * @author avatarannappa
 * @version 1.0, 2021/5/7
 */
public class RangeSumBST938 {

    int sum = 0;

    public int rangeSumBST(TreeNode root, int low, int high) {
        if (root == null) {
            return 0;
        }
        if (root.val >= low && root.val <= high) {
            sum += root.val;
            rangeSumBST(root.left, low, high);
            rangeSumBST(root.right, low, high);
        } else if (root.val < low) {
            rangeSumBST(root.right, low, high);
        } else if (root.val > high) {
            rangeSumBST(root.left, low, high);
        }
        return sum;
    }

}
