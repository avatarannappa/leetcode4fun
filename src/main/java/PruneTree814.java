/**
 * 814. 二叉树剪枝
 * medium
 *
 * @author avatarannappa
 * @date 2022/7/21
 */
public class PruneTree814 {

    public TreeNode pruneTree(TreeNode root) {
        // 后序遍历 递归
        if (root == null) {
            return null;
        }
        root.left = pruneTree(root.left);
        root.right = pruneTree(root.right);
        if (root.left == null && root.right == null) {
            return root.val == 1 ? root : null;
        }
        return root;
    }

    public static void main(String[] args) {
        Integer[] arr = {1, 0, 1, 0, 0, 0, 1};
        TreeNode root = TreeUtils.arrayToTree(arr);
        // [1,null,1,null,1]
        System.out.println(new PruneTree814().pruneTree(root));
    }
}
