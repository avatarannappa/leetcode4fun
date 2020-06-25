import java.util.ArrayList;
import java.util.List;

/**
 * 257. 二叉树的所有路径.
 *
 * @author avatarannappa
 * @version 1.0, 2020/6/25
 */
public class BinaryTreePaths257 {

    List<String> result = new ArrayList<>();

    public List<String> binaryTreePaths(TreeNode root) {
        if (root == null) {
            return result;
        }
        recursion(root, "");
        return result;
    }

    public void recursion(TreeNode root, String str) {
        if (root.left == null && root.right == null) {
            String s = str + "->" + root.val;
            result.add(s.substring(2, s.length()));
            return;
        }
        if (root.left != null) {
            recursion(root.left, str + "->" + root.val);
        }
        if (root.right != null) {
            recursion(root.right, str + "->" + root.val);
        }
    }

    public static void main(String[] args) {
        Integer[] array = {1, 2, 3, null, 5};
        TreeNode root = TreeUtils.arrayToTree(array);
        System.out.println(new BinaryTreePaths257().binaryTreePaths(root));
    }
}
