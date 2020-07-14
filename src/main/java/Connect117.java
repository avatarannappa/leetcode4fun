import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 117. 填充每个节点的下一个右侧节点指针 II
 *
 * @author avatarannappa
 * @version 1.0, 2020/7/14
 */
public class Connect117 {

    public Node connect(Node root) {
        if (root == null) {
            return root;
        }
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            Node temp = queue.poll();
            List<Node> list = new ArrayList<>();
            if (temp.left != null) {
                list.add(temp.left);
            }
            if (temp.right != null) {
                list.add(temp.right);
            }
            while (!queue.isEmpty()) {
                temp.next = queue.poll();
                temp = temp.next;
                if (temp.left != null) {
                    list.add(temp.left);
                }
                if (temp.right != null) {
                    list.add(temp.right);
                }
            }
            queue.addAll(list);
        }
        return root;
    }

}
