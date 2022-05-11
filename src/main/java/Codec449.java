import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * 449. 序列化和反序列化二叉搜索树.
 * medium
 *
 * @author avatarannappa
 * @version 1.0
 * @date 2022/5/11
 */
public class Codec449 {

    // Encodes a tree to a single string.  
    public String serialize(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        preOrder(root, list);
        String str = list.toString();
        return str.substring(1, str.length() - 1);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (data.isEmpty()) {
            return null;
        }
        String[] str = data.split(",");
        Deque<Integer> deque = new ArrayDeque<>();
        for (String s : str) {
            deque.addLast(Integer.parseInt(s.trim()));
        }
        return buildTree(deque, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    private TreeNode buildTree(Deque<Integer> deque, int lower, int upper) {
        if (deque.isEmpty() || deque.peek() < lower || deque.peek() > upper) {
            return null;
        }
        int val = deque.poll();
        TreeNode root = new TreeNode(val);
        root.left = buildTree(deque, lower, val);
        root.right = buildTree(deque, val, upper);
        return root;
    }

    private void preOrder(TreeNode root, List<Integer> list) {
        if (root == null) {
            return;
        }
        list.add(root.val);
        preOrder(root.left, list);
        preOrder(root.right, list);
    }
}
