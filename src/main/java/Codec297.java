import java.util.LinkedList;
import java.util.Queue;

/**
 * 297. 二叉树的序列化与反序列化
 *
 * @author avatarannappa
 * @version 1.0, 2020/5/9
 */
public class Codec297 {
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        String str = "[";

        if (root != null) {
            Queue<TreeNode> queue = new LinkedList<>();
            queue.add(root);
            while (!queue.isEmpty()) {
                TreeNode now = queue.poll();
                if (now == null) {
                    str += "null,";
                } else {
                    str += now.val + ",";
                    queue.add(now.left);
                    queue.add(now.right);
                }
            }
            str.substring(str.lastIndexOf(","));
        }

        str += "]";
        return str;
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (data == null || data.length() == 0) {
            return null;
        }
        data = data.substring(1, data.length() - 1);
        if (data.length() == 0) {
            return null;
        }
        String[] nums = data.split(",");
        // 数组转树
        int index = 0;
        Queue<TreeNode> queue = new LinkedList<>();
        TreeNode root = new TreeNode(Integer.valueOf(nums[index++]));
        queue.offer(root);
        while (index < nums.length && !queue.isEmpty()) {
            TreeNode now = queue.poll();
            String leftStr = nums[index++];
            if ("null".equals(leftStr)) {
                now.left = null;
            } else {
                now.left = new TreeNode(Integer.valueOf(leftStr));
                queue.add(now.left);
            }
            String rightStr = nums[index++];
            if ("null".equals(rightStr)) {
                now.right = null;
            } else {
                now.right = new TreeNode(Integer.valueOf(rightStr));
                queue.add(now.right);
            }

        }
        return root;
    }

    public static void main(String[] args) {
        String str = "[1,2,3,null,null,4,5]";
        Codec297 code = new Codec297();
        System.out.println(code.serialize(code.deserialize(str)));
    }
}
