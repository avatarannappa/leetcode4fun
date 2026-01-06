import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * 1161. 最大层内元素和.
 * medium
 *
 * @author avatarannappa
 * @version 1.0, 2026/1/6
 */
public class MaxLevelSum1161 {

    int levelMin = Integer.MAX_VALUE;
    int sumMax = Integer.MIN_VALUE;

    public int maxLevelSum(TreeNode root) {
        Deque<TreeNode> q = new ArrayDeque<>();
        q.offer(root);
        int level = 1;
        while (!q.isEmpty()) {
            List<TreeNode> list = new ArrayList<>();
            int sum = 0;
            while(!q.isEmpty()) {
                TreeNode node = q.poll();
                if (node.left != null) {
                    list.add(node.left);
                }
                if (node.right != null) {
                    list.add(node.right);
                }
                sum += node.val;
            }
            if (sum > sumMax) {
                levelMin = level;
                sumMax = sum;
            } else if (sum == sumMax) {
                levelMin = Math.min(levelMin, level + 1);
            }
            level++;
            q.addAll(list);
        }
        return levelMin;
    }

    public static void main(String[] args) {
        Integer[] arr = {989, null, 10250, 98693, -89388, null, null, null, -32127};
        TreeNode root = TreeUtils.arrayToTree(arr);
        System.out.println(new MaxLevelSum1161().maxLevelSum(root));
    }
}
