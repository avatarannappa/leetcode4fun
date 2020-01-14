import java.util.ArrayList;
import java.util.List;

/**
 * 559. N叉树的最大深度
 *
 * @author avatarannappa
 * @version 1.0, 2019/12/22
 */
public class MaxDepth559 {
    class Node {
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

    ;

    public int maxDepth(Node root) {
        if (root == null) {
            return 0;
        }
        int max = 0;
        for (Node child : root.children) {
            max = Math.max(maxDepth(child), max);
        }
        max = max + 1;
        return max;
    }
}
