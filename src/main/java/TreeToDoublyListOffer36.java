import java.util.ArrayList;
import java.util.List;

/**
 * 剑指 Offer 36. 二叉搜索树与双向链表
 * medium
 *
 * @author avatarannappa
 * @version 1.0, 2021/6/8
 */
public class TreeToDoublyListOffer36 {

    Node head = null;
    List<Node> list = new ArrayList<>();

    public Node treeToDoublyList(Node root) {
        if (root == null || (root.left == null && root.right == null)) {
            return null;
        }
        recursion(root);
        if (list.size() == 1) {
            root.left = root;
            root.right = root;
            return root;
        }
        for (int i = 0; i < list.size(); i++) {
            Node now = list.get(i);
            if (i == 0) {
                now.left = list.get(list.size() - 1);
                now.right = list.get(i + 1);
            } else if (i == list.size() - 1) {
                now.right = list.get(0);
                now.left = list.get(i - 1);
            } else {
                now.left = list.get(i - 1);
                now.right = list.get(i + 1);
            }
        }
        return head;
    }

    public void recursion(Node root) {
        if (root == null) {
            return;
        }
        recursion(root.left);
        if (head == null) {
            head = root;
        }
        list.add(root);
        recursion(root.right);
    }

}
