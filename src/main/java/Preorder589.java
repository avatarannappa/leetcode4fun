import java.util.ArrayList;
import java.util.List;

/**
 * 589. N叉树的前序遍历.
 *
 * @author avatarannappa
 * @version 1.0, 2020/7/15
 */
public class Preorder589 {

    List<Integer> result = new ArrayList<>();

    public List<Integer> preorder(Node root) {
        if (root == null) {
            return result;
        }
        result.add(root.val);
        if (root.children!=null) {
            for (Node child : root.children) {
                preorder(child);
            }
        }

        return result;
    }

    static class Node {
        public int val;
        public List<Node> children;

        public Node() {}

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, List<Node> _children) {
            val = _val;
            children = _children;
        }
    }
}
