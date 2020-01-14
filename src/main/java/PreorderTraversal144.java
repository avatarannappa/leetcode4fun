import java.util.ArrayList;
import java.util.List;

/**
 * 687. 最长同值路径
 *
 * @author avatarannappa
 * @version 1.0, 2019/11/10
 */
public class PreorderTraversal144 {

    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        recursion(result, root);
        return result;
    }


    public void recursion(List<Integer> r, TreeNode t) {
        if (t == null) {
            return;
        }
        r.add(t.val);
        recursion(r, t.left);
        recursion(r, t.right);
    }
}
