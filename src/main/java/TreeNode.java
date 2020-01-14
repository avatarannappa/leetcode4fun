import java.util.ArrayList;
import java.util.List;

public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int x) {
        val = x;
    }

    public int getVal() {
        return val;
    }

    public void setVal(int val) {
        this.val = val;
    }

    public TreeNode getLeft() {
        return left;
    }

    public void setLeft(TreeNode left) {
        this.left = left;
    }

    public TreeNode getRight() {
        return right;
    }

    public void setRight(TreeNode right) {
        this.right = right;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        List<List<Integer>> result = levelOrder(this);
        for (List<Integer> integers : result) {
            for (Integer integer : integers) {
                sb.append(integer);
                sb.append(" ");
            }
            sb.append("\n");
        }
        return sb.toString();
    }

    private List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> list = new ArrayList<>();
        level(list, 0, root);
        return list;
    }

    private void level(List<List<Integer>> list, Integer level, TreeNode node) {
        if (node == null) {
            if (list.size() <= level) {
                List<Integer> l = new ArrayList<>();
                l.add(null);
                list.add(l);
            } else {
                list.get(level).add(null);
            }
            return;
        }
        if (list.size() <= level) {
            List<Integer> l = new ArrayList<>();
            l.add(node.val);
            list.add(l);
        } else {
            list.get(level).add(node.val);
        }
        level++;
        level(list, level, node.left);
        level(list, level, node.right);
    }
}
