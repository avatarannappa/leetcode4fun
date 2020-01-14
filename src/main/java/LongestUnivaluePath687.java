/**
 * 687. 最长同值路径
 *
 * @author avatarannappa
 * @version 1.0, 2019/11/10
 */
public class LongestUnivaluePath687 {
    public int longestUnivaluePath(TreeNode root) {
        int result = 0;
        return result;
    }

    public TreeNode arrayToTree(int[] array) {
        TreeNode root = new TreeNode(array[0]);
        TreeNode index = root;
        int sign = 0;
        for (int i = 1; i < array.length; i++) {
            if (sign == 0) {
                TreeNode node = new TreeNode(array[i]);
                index.left = node;
                sign = 1;
            } else {
                TreeNode node = new TreeNode(array[i]);
                index.right = node;
                sign = 0;
            }
        }
        return root;
    }

    public static void main(String[] args) {
        LongestUnivaluePath687 l = new LongestUnivaluePath687();
        int[] treeArray = {5, 4, 5, 1, 1, 5};
        TreeNode treeNode = l.arrayToTree(treeArray);
        int result = l.longestUnivaluePath(treeNode);
        System.out.println(result);
    }
}
