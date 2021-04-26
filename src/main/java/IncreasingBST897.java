import java.util.ArrayList;
import java.util.List;

/**
 * 897. 递增顺序搜索树
 * easy
 *
 * @author avatarannappa
 * @version 1.0, 2021/4/26
 */
public class IncreasingBST897 {

    List<TreeNode> list = new ArrayList<>();

    public TreeNode increasingBST(TreeNode root) {
        if (root == null) {
            return root;
        }
        recursion(root);
        root = list.get(0);
        TreeNode iter = root;
        for (int i = 1; i < list.size(); i++) {
            iter.left = null;
            iter.right = list.get(i);
            iter = iter.right;
        }
        iter.left = null;
        iter.right = null;

        return root;
    }

    public void recursion(TreeNode root) {
        if (root == null) {
            return;
        }
        recursion(root.left);
        list.add(root);
        recursion(root.right);
    }

    public static void main(String[] args) {
        Integer[] nums = {5, 3, 6, 2, 4, null, 8, 1, null, null, null, 7, 9};
        TreeNode treeNode = TreeUtils.arrayToTree(nums);
        System.out.println(new IncreasingBST897().increasingBST(treeNode));
    }
}
