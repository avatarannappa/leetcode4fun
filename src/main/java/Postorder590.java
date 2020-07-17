import java.util.ArrayList;
import java.util.List;

/**
 * 590. N叉树的后序遍历.
 *
 * @author avatarannappa
 * @version 1.0, 2020/7/17
 */
public class Postorder590 {

    List<Integer> result = new ArrayList();

    public List<Integer> postorder(Node root) {
        if (root == null) {
            return result;
        }
        if (root.children != null) {
            for (Node child : root.children) {
                postorder(child);
            }
        }
        result.add(root.val);
        return result;
    }

    static class Node {
        public int val;
        public List<Node> children;

        public Node() {
        }

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, List<Node> _children) {
            val = _val;
            children = _children;
        }
    }
}
