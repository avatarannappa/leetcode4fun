import java.util.ArrayList;
import java.util.List;

/**
 * 662. 二叉树的最大宽度
 * medium
 *
 * @author avatarannappa
 * @version 1.0, 2022/8/27
 */
public class WidthOfBinaryTree662 {

    public int widthOfBinaryTree(TreeNode root) {
        int res = 1;
        List<Pair<TreeNode, Integer>> arr = new ArrayList<>();
        arr.add(new Pair<>(root, 1));
        while (!arr.isEmpty()) {
            List<Pair<TreeNode, Integer>> tmp = new ArrayList<>();
            for (Pair<TreeNode, Integer> pair : arr) {
                TreeNode node = pair.getKey();
                int index = pair.getValue();
                if (node.left != null) {
                    tmp.add(new Pair<>(node.left, index * 2));
                }
                if (node.right != null) {
                    tmp.add(new Pair<>(node.right, index * 2 + 1));
                }
            }
            res = Math.max(res, arr.get(arr.size() - 1).getValue() - arr.get(0).getValue() + 1);
            arr = tmp;
        }
        return res;
    }

    public static class Pair<K, V> {
        K key;
        V value;

        public Pair(K k, V v) {
            key = k;
            value = v;
        }

        public K getKey() {
            return key;
        }

        public void setKey(K key) {
            this.key = key;
        }

        public V getValue() {
            return value;
        }

        public void setValue(V value) {
            this.value = value;
        }
    }

    public static void main(String[] args) {
        Integer[] arr = {1, 3, 2, 5, null, null, 9, 6, null, 7};
        // 7
        TreeNode root = TreeUtils.arrayToTree(arr);
        System.out.println(new WidthOfBinaryTree662().widthOfBinaryTree(root));
    }
}
