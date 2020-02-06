import java.util.ArrayList;
import java.util.List;

/**
 * 114. 二叉树展开为链表
 *
 * @author avatarannappa
 * @version 1.0, 2020/2/6
 */
public class Flatten114 {

    private List<TreeNode> result = new ArrayList<>();

    public void flatten(TreeNode root) {
        if (root != null) {
            toList(root);
            if (result.size() > 1) {
                for (int i = 0; i < result.size() - 1; i++) {
                    result.get(i).left = null;
                    result.get(i).right = result.get(i + 1);
                }
            }
        }
    }

    public void toList(TreeNode root) {
        if (root == null) {
            return;
        }

        result.add(root);
        toList(root.left);
        toList(root.right);
    }
}
