/**
 * 700. 二叉搜索树中的搜索 easy
 *
 * @author avatarannappa
 * @version 1.0
 * @date 2021/9/8
 */
public class SearchBST700 {

    public TreeNode searchBST(TreeNode root, int val) {
        if (root == null) {
            return null;
        }
        if (root.val == val) {
            return root;
        } else if (root.val > val) {
            return searchBST(root.left, val);
        } else {
            return searchBST(root.right, val);
        }
    }
}
