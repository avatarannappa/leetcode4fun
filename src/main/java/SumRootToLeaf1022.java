/**
 * 1022. 从根到叶的二进制数之和.
 *
 * @author avatarannappa
 * @version 1.0, 2020/08/22
 */
public class SumRootToLeaf1022 {

    int result = 0;

    public int sumRootToLeaf(TreeNode root) {

        int mod = 1000000000 + 7;
        if (root != null) {
            recursion(root, 0);
        }
        return result % mod;
    }

    public void recursion(TreeNode root, int temp) {
        if (root == null) {
            return;
        }
        temp = (temp << 1) + root.val;
        if (root.left == null && root.right == null) {
            result += temp;
        } else {
            recursion(root.left, temp);
            recursion(root.right, temp);
        }
    }

    public static void main(String[] args) {
        Integer[] nums = {1, 0, 1, 0, 1, 0, 1};
        System.out.println(new SumRootToLeaf1022().sumRootToLeaf(TreeUtils.arrayToTree(nums)));
    }
}
