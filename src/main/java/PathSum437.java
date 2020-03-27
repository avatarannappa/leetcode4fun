/**
 * 437. 路径综合III
 *
 * @author avatarannappa
 * @version 1.0, 2020/3/26
 */
public class PathSum437 {

    public int pathSum(TreeNode root, int sum) {
        return recursion(root, sum, new int[1000], 0);
    }

    public int recursion(TreeNode root, int sum, int[] array, int p) {
        if (root == null) {
            return 0;
        }
        int tmp = root.val;
        int n = root.val == sum ? 1 : 0;
        for (int i = p - 1; i >= 0; i--) {
            tmp += array[i];
            if (tmp == sum) {
                n++;
            }
        }
        array[p] = root.val;
        int n1 = recursion(root.left, sum, array, p + 1);
        int n2 = recursion(root.right, sum, array, p + 1);
        return n + n1 + n2;
    }
}
