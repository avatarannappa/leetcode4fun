/**
 * 421. 数组中两个数的最大异或值
 * medium
 *
 * @author avatarannappa
 * @version 1.0, 2021/4/25
 */
public class FindMaximumXOR421 {

    class TrieNode {
        TrieNode[] son = new TrieNode[2];
    }

    TrieNode root = new TrieNode();

    // 将x插入字段树
    public void insert(int x) {
        TrieNode p = root;
        for (int i = 30; i >= 0; i--) {
            int u = x >> i & 1;
            if (p.son[u] == null) {
                p.son[u] = new TrieNode();
            }
            p = p.son[u];
        }
    }

    // 返回字典树中与x异或后最大的数
    public int search(int x) {
        TrieNode p = root;
        int res = 0;
        for (int i = 30; i >= 0; i--) {
            int u = x >> i & 1;
            if (p.son[1 ^ u] != null) {
                // 优先走x二进制表示中第i位取反的路径
                res += 1 << i;
                p = p.son[1 ^ u];
            } else {
                p = p.son[u];
            }
        }
        return res;
    }

    public int findMaximumXOR(int[] nums) {
        for (int num : nums) {
            insert(num);
        }
        int res = 0;
        for (int num : nums) {
            res = Math.max(res, search(num));
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = {3, 10, 5, 25, 2, 8};
        // 28
        System.out.println(new FindMaximumXOR421().findMaximumXOR(nums));
    }
}
