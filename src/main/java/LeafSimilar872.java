import java.util.LinkedList;
import java.util.List;

/**
 * 872. 叶子相似的数
 * easy
 *
 * @author avatarannappa
 * @version 1.0, 2021/5/12
 */
public class LeafSimilar872 {

    List<Integer> l1 = new LinkedList<>();
    List<Integer> l2 = new LinkedList<>();

    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        getLeafs(root1, l1);
        getLeafs(root2, l2);
        if (l1.size() != l2.size()) {
            return false;
        }
        for (int i = 0; i < l1.size(); i++) {
            if (l1.get(i) != l2.get(i)) {
                return false;
            }
        }
        return true;
    }

    public void getLeafs(TreeNode root, List<Integer> list) {
        if (root == null) {
            return;
        }
        if (root.left == null && root.right == null) {
            list.add(root.val);
        }
        getLeafs(root.left, list);
        getLeafs(root.right, list);
    }

}
