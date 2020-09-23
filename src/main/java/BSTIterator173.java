import java.util.LinkedList;
import java.util.List;

/**
 * 173. 二叉搜索树迭代器.
 *
 * @author avatarannappa
 * @version 1.0, 2020/9/23
 */
public class BSTIterator173 {

    List<Integer> list;

    public BSTIterator173(TreeNode root) {
        list = inorder(root);
    }

    public static List<Integer> inorder(TreeNode root) {
        List<Integer> result = new LinkedList<>();
        if (root == null) {
            return result;
        }

        result.addAll(inorder(root.left));
        result.add(root.val);
        result.addAll(inorder(root.right));
        return result;
    }

    /**
     * @return the next smallest number
     */
    public int next() {
        return list.remove(0);
    }

    /**
     * @return whether we have a next smallest number
     */
    public boolean hasNext() {
        return !list.isEmpty();
    }

}
