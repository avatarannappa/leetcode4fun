/**
 * 538. 把二叉搜索树转换为累加树
 *
 * @author avatarannappa
 * @version 1.0, 2020/2/15
 */
public class ConvertBST538 {

    public int t = 0;

    public TreeNode convertBST(TreeNode root) {
        if (root == null) {
            return null;
        }
        convertBST(root.right);
        root.val += t;
        t = root.val;
        convertBST(root.left);
        return root;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        TreeNode left = new TreeNode(2);
        TreeNode right = new TreeNode(13);
        root.left = left;
        root.right = right;
        System.out.println(new ConvertBST538().convertBST(root));
    }
}
