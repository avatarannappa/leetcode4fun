import java.util.ArrayList;
import java.util.List;

/**
 * 199. 二叉树的右视图.
 *
 * @author chenhao15
 * @version 1.0, 2020/2/26
 */
public class RightSideView199 {

    public List<Integer> rightSideView(TreeNode root) {
        List<List<Integer>> orderList = levelOrder(root);
        List<Integer> result = new ArrayList<>();

        for (List<Integer> integers : orderList) {
            result.add(integers.get(integers.size() - 1));
        }

        return result;
    }

    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> list = new ArrayList<>();
        level(list, 0, root);
        return list;
    }

    public void level(List<List<Integer>> list, Integer level, TreeNode node) {
        if (node == null) {
            return;
        }
        if (list.size() <= level) {
            List<Integer> l = new ArrayList<>();
            l.add(node.val);
            list.add(l);
        } else {
            list.get(level).add(node.val);
        }
        level++;
        level(list, level, node.left);
        level(list, level, node.right);
    }

}
