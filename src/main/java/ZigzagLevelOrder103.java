import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.google.common.collect.Lists;

/**
 * 103. 二叉树的锯齿形层次遍历
 *
 * @author avatarnnappa
 * @version 1.0, 2019/11/28
 */
public class ZigzagLevelOrder103 {

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> list = new ArrayList<>();
        level(list, 0, root);
        if (list != null && list.size() > 0) {
            for (int i = 0; i < list.size(); i++) {
                if (i % 2 ==1) {
                    Collections.reverse(list.get(i));
                }
            }
        }
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
