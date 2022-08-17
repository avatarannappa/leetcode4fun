import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * 1302. 层数最深叶子节点的和
 * medium
 *
 * @author avatarannappa
 * @date 2022/8/17
 */
public class DeepestLeavesSum1302 {

    public int deepestLeavesSum(TreeNode root) {
        int ans = 0;
        Deque<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            ans = 0;
            List<TreeNode> tempList = new LinkedList<>();
            while (!queue.isEmpty()) {
                TreeNode node = queue.pop();
                ans += node.val;
                if (node.left != null) {
                    tempList.add(node.left);
                }
                if (node.right != null) {
                    tempList.add(node.right);
                }
            }
            queue.addAll(tempList);
        }
        return ans;
    }

    public static void main(String[] args) {
        Integer[] arr = {6, 7, 8, 2, 7, 1, 3, 9, null, 1, 4, null, null, null, 5};
        TreeNode root = TreeUtils.arrayToTree(arr);
        System.out.println(new DeepestLeavesSum1302().deepestLeavesSum(root));
    }
}
