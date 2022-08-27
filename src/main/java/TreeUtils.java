import java.util.ArrayList;
import java.util.List;

/**
 * 树工具类.
 *
 * @author avatarannappa
 * @version 1.0, 2020/2/22
 */
public class TreeUtils {

    public static TreeNode arrayToTree(Integer[] nums) {
        // 数组转树
        int index = 0;
        List<TreeNode> list = new ArrayList<>(nums.length);
        TreeNode root = new TreeNode(nums[0]);
        list.add(root);
        int col = 0;
        for (int i = 1; i < nums.length; i++) {
            Integer num = nums[i];
            TreeNode node = null;
            if (num != null) {
                node = new TreeNode(num);
            }
            list.add(node);

            while (list.get(index) == null) {
                index++;
            }
            TreeNode now = list.get(index);
            if (col == 0) {
                // left
                now.left = node;
                col++;
            } else if (col == 1) {
                // right
                now.right = node;
                index++;
                col = 0;
            }
        }
        return list.get(0);
    }
}
