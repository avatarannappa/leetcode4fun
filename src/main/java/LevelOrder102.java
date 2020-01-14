import java.util.ArrayList;
import java.util.List;

/**
 * 102. 二叉树的层次遍历.
 *
 * @author avatarannapa
 * @version 1.0, 2019/11/27
 */
public class LevelOrder102 {
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
