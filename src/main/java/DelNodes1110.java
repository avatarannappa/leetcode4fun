import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

/**
 * 1110. 删点成林
 * medium
 *
 * @author avatarannappa
 * @date 2023/5/30
 */
public class DelNodes1110 {

    public List<TreeNode> delNodes(TreeNode root, int[] to_delete) {
        Set<Integer> set = new HashSet<>();
        for (int i : to_delete) {
            set.add(i);
        }

        List<TreeNode> res = new LinkedList<>();
        dfs(root, set, res, true);
        return res;
    }

    public TreeNode dfs(TreeNode root, Set<Integer> set, List<TreeNode> res, boolean isRoot) {
        if (root == null) {
            return null;
        }
        boolean isDelete = set.contains(root.val);
        TreeNode left = null;
        TreeNode right = null;
        if (isDelete) {
            left = dfs(root.left, set, res, true);
            right = dfs(root.right, set, res, true);
        } else {
            left = dfs(root.left, set, res, false);
            right = dfs(root.right, set, res, false);
        }
        if (isDelete) {
            return null;
        } else {
            if (isRoot) {
                res.add(root);
            }
            root.left = left;
            root.right = right;
            return root;
        }
    }


}
