/**
 * 563. 二叉树的坡度
 * easy
 *
 * @author avatarannappa
 * @version 1.0, 2021/3/4
 */
public class FindTilt563 {

    int result = 0;

    public int findTilt(TreeNode root) {
        recursion(root);
        return result;
    }

    public int recursion(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = recursion(root.left);
        int right = recursion(root.right);
        result += Math.abs(left - right);
        return left + right + root.val;
    }

    public static void main(String[] args) {
        Integer[] array = {21, 7, 14, 1, 1, 2, 2, 3, 3};
        // result = 9
        TreeNode tree = TreeUtils.arrayToTree(array);
        System.out.println(new FindTilt563().findTilt(tree));
    }
}
