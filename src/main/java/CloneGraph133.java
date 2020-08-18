import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

/**
 * 133. 克隆图.
 *
 * @author avatarannappa
 * @version 1.0, 2020/8/18
 */
public class CloneGraph133 {

    public Node cloneGraph(Node node) {
        if (node == null) {
            return node;
        }

        Map<Integer, List<Integer>> map = new HashMap<>();
        Map<Integer, Node> nodeMap = new HashMap<>();
        Queue<Node> queue = new LinkedList<>();
        queue.add(node);
        Node result = null;
        while (!queue.isEmpty()) {
            List<Node> list = new ArrayList<>();
            while (!queue.isEmpty()) {
                Node i = queue.poll();
                if (!map.containsKey(i.val)) {
                    Node newNode = new Node(i.val);
                    if (result == null) {
                        result = newNode;
                    }
                    nodeMap.put(i.val, newNode);

                    List<Node> neighbors = i.neighbors;
                    List<Integer> l = new ArrayList<>();
                    if (neighbors != null) {
                        for (Node neighbor : neighbors) {
                            l.add(neighbor.val);
                            list.add(neighbor);
                        }
                    }
                    map.put(i.val, l);
                }
            }
            queue.addAll(list);
        }
        for (Map.Entry<Integer, List<Integer>> entry : map.entrySet()) {
            Integer key = entry.getKey();
            List<Integer> values = entry.getValue();
            List<Node> list = new ArrayList<>();
            for (Integer value : values) {
                list.add(nodeMap.get(value));
            }
            nodeMap.get(key).neighbors = list;
        }
        return result;
    }

    class Node {
        public int val;
        public List<Node> neighbors;

        public Node() {
            val = 0;
            neighbors = new ArrayList<Node>();
        }

        public Node(int _val) {
            val = _val;
            neighbors = new ArrayList<Node>();
        }

        public Node(int _val, ArrayList<Node> _neighbors) {
            val = _val;
            neighbors = _neighbors;
        }
    }
}
