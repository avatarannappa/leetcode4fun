import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 107. 二叉树的层次遍历 II
 *
 * @author avatarannappa
 * @version 1.0, 2019/12/9
 */
public class LevelOrderBottom107 {
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> list = new ArrayList<>();
        level(list, 0, root);
        Collections.reverse(list);
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
