import java.util.ArrayList;
import java.util.List;

/**
 * 116. 填充每个节点的下一个右侧节点指针
 *
 * @author avatarannappa
 * @version 1.0, 2019/12/3
 */
public class Connect116 {
    public Node connect(Node root) {
        recursion(0, root, new ArrayList<>());
        return root;
    }

    public void recursion(Integer level, Node node, List<Node> indexList) {
        if (node == null) {
            return;
        }
        if (indexList.size() <= level) {
            indexList.add(node);
        } else {
            indexList.get(level).next = node;
            indexList.set(level, node);
        }
        level++;
        recursion(level, node.left, indexList);
        recursion(level, node.right, indexList);
    }

    public Node connect2(Node root) {
        if (root == null) {
            return root;
        }
        Node cur = root;
        Node pre = null;

        while (cur != null) {
            while (pre != null) {
                pre.left.next = pre.right;
                if (pre.next != null) {
                    pre.right.next = pre.next.left;
                }
                pre = pre.next;
            }
            pre = cur;
            cur = cur.left;
        }
        return root;
    }
}
