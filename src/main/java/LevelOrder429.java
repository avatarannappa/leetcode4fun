import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 429. N叉树的层序遍历
 *
 * @author avatarannappa
 * @version 1.0, 2020/2/27
 */
public class LevelOrder429 {

    public List<List<Integer>> levelOrder(Node root) {
        List<List<Integer>> result = new LinkedList<>();
        if (root == null) {
            return result;
        }
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            List<Integer> temp = new LinkedList<>();
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                Node n = queue.poll();
                temp.add(n.val);
                queue.addAll(n.children);
            }
            result.add(temp);
        }
        return result;
    }

    public static class Node {
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
}
